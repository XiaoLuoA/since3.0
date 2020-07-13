package com.since.sincethird.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.since.sincethird.common.Config;
import com.since.sincethird.common.Status;
import com.since.sincethird.dto.Attach;
import com.since.sincethird.entity.Book;
import com.since.sincethird.entity.WXList;
import com.since.sincethird.repository.ListRepository;
import com.since.sincethird.service.ListService;
import com.since.sincethird.util.OrderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * @author 王英豪111
 */
@Service

public class ListServiceImpl implements ListService {


    @Autowired
    private ListRepository listRepository;

    @Autowired
    private BookServiceImpl bookService;


    @Override
    public synchronized WXList buy(WXList wxList) {
        Integer book_id = Integer.valueOf(wxList.getBookId());
        boolean b = bookService.updateStock(book_id,wxList.getBookNum());
        if (b){
            WXList ret =  save(wxList);
            System.out.println("success "+ JSON.toJSONString(ret));
            return ret;
        }else {
            System.out.println("error");
            return null;
        }
    }

    @Override
    public WXList save(WXList wxList) {
        Long book_id = Long.valueOf(wxList.getBookId());
        Book book = null;
        try {
            book = bookService.findById(book_id);
        }catch (NoSuchElementException e){
            int n = book.getBookcount() - wxList.getBookNum();
            synchronized (book){
                if (n < 0){
                    return null;
                } else if(n == 0){
                    book.setBookstatus(Status.BOOK_EMPTY);
                }
                //修改book库存
                book.setBookcount(n);
                bookService.save(book);
            }
        }
        Long time = System.currentTimeMillis();
        String no = time + String.valueOf(new Random().nextInt(899) + 100);
        wxList.setNo(no);
        wxList.setBookImage(book.getBookimage1());
        wxList.setBookName(book.getBookname());
        wxList.setBookPrice(book.getBookprice());
        return wxList;
    }


    @Override
    public WXList preList(String openid, Attach attach, String wxImage){
        WXList wxList = new WXList();
        wxList.setNo(OrderUtil.genOrderNo());
        wxList.setOpenId(openid);
        wxList.setAddress(attach.getAddr());
        wxList.setPhone(attach.getTel());
        wxList.setWxImage(wxImage);
        wxList.setStatus(Status.NORMAL);
        wxList.setBookId(attach.getBookId());
        Book book = bookService.findById(Long.parseLong(attach.getBookId()));
        wxList.setTotal(book.getBookprice()*attach.getBuyNum());
        wxList.setBookImage(book.getBookimage1());
        wxList.setBookName(book.getBookname());
        wxList.setBookNum(attach.getBuyNum());
        wxList.setBookPrice(book.getBookprice());
        return wxList;
    }

    @Override
    public WxPayUnifiedOrderRequest getWxPayUnifiedOrder(String openid, String remoteAddr, String no, int total) {
        WxPayUnifiedOrderRequest request = new WxPayUnifiedOrderRequest();
        request.setTradeType("JSAPI");
        request.setSignType("MD5");
        request.setBody("since-book");
        request.setNotifyUrl(Config.HOST +"/pay/unifiedOrder");
        request.setSpbillCreateIp(remoteAddr);
        request.setOutTradeNo(no);
        request.setTotalFee(total);
        return request;
    }

    @Override
    public WXList pay(WXList wxList, String WXcode) {
        Long book_id = Long.valueOf(wxList.getBookId());
        Book book = bookService.findById(book_id);
         if (WXcode == "fail" ){
                //库存返回原来的数量
             book.setBookcount(book.getBookcount() + wxList.getBookNum());
             bookService.save(book);
             return null;
          }

        //成功，添加订单总金额
        wxList.setTotal(wxList.getBookNum() * wxList.getBookPrice());
        return listRepository.save(wxList);
    }




    @Override
    public List<WXList> findListByOpenId(String open_id) {
        return listRepository.findAllByOpenId(open_id);
    }


    @Override
    public WXList findWXListById(Long id) {
        return listRepository.findWXListById(id);
    }

    @Override
    public WXList modifyList(WXList wxList) {
        wxList.setStatus(Status.WxList_NotPay);
        return listRepository.save(wxList);
    }

    @Override
    public WXList deleteList(WXList wxList) {
        wxList.setStatus(Status.WxList_Delete);
        return listRepository.save(wxList);
    }


}

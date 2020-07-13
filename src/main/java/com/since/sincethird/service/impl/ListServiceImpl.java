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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        Book book = bookService.findById(book_id);
        int n = book.getBookcount() - wxList.getBookNum();
        synchronized (book){
            if (n < 0){
                return null;
            } else if(n == 0){
                book.setBookstatus(2);
            }
            //修改book库存
            book.setBookcount(n);
            bookService.save(book);
        }
        return wxList;
    }


    @Override
    public WXList add(String openid, String addr,String tel,String bookId,Integer bookNum,String wxImage){
        WXList wxList = new WXList();
        wxList.setOpenId(openid);
        wxList.setAddress(addr);
        wxList.setWxImage(wxImage);
        wxList.setStatus(Status.NORMAL);
        wxList.setBookId(bookId);
        Book book = bookService.findById(Long.parseLong(bookId));
        wxList.setTotal(book.getBookprice()*bookNum);
        wxList.setBookImage(book.getBookimage1());
        wxList.setBookName(book.getBookname());
        wxList.setBookNum(bookNum);
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


}

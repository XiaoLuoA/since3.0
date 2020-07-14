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
        Integer bookId = Integer.valueOf(wxList.getBookId());
        boolean b = bookService.updateStock(bookId,wxList.getBookNum());
        if (b){
            WXList ret =  listRepository.save(wxList);
            System.out.println("success "+ JSON.toJSONString(ret));
            return ret;
        }else {
            System.out.println("error");
            return null;
        }
    }

    @Override
    public WXList save(WXList wxList) {
        Long bookId = Long.valueOf(wxList.getBookId());
        Book book = null;
        try {
            book = bookService.findById(bookId);
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
        wxList.setStatus(Status.WX_LIST_NOT_PAY);
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
        request.setNotifyUrl(Config.HOST +"/pay/notify/order");
        request.setSpbillCreateIp(remoteAddr);
        request.setOutTradeNo(no);
        request.setTotalFee(total);
        request.setOpenid(openid);
        return request;
    }






    @Override
    public List<WXList> findListByOpenId(String openId) {
        return listRepository.findAllByOpenId(openId);
    }


    @Override
    public WXList findWxListById(Long id) {
        return listRepository.findWxListById(id);
    }

    @Override
    public WXList findByNo(String no) {
        return listRepository.findByNo(no);
    }


    @Override
    public boolean modifyList(String id,Integer status) {
        return listRepository.updateStatus(id,status) > 0;
    }



    @Override
    public void findAllByWxListStatus() {
        List<WXList> wxLists = listRepository.findAllByStatus(Status.WX_LIST_NOT_PAY);
        System.out.println(wxLists);
        for (WXList wxList: wxLists) {
             long listTime = Long.parseLong((String.valueOf(wxList.getNo()).substring(0,13)));
             long nowTime = System.currentTimeMillis();
             //间隔时间
             long intervalTime = Long.parseLong(String.valueOf(30 * 60 * 1000));
             long time = nowTime - listTime;
             if ( time >= intervalTime){
                 listRepository.updateStatus(wxList.getNo(),Status.WX_LIST_DELETE);
             }
        }

    }


    @Override
    public List<WXList> findAllWxList() {
        return listRepository.findAll();
    }


}

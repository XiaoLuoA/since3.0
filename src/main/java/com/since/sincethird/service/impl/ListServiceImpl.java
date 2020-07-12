package com.since.sincethird.service.impl;

import com.since.sincethird.entity.Book;
import com.since.sincethird.entity.WXList;
import com.since.sincethird.repository.ListRepository;
import com.since.sincethird.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public WXList add(WXList wxList) {
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

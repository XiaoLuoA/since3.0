package com.since.sincethird.controller;


import com.since.sincethird.common.ListResult;
import com.since.sincethird.common.Result;
import com.since.sincethird.common.Ret;
import com.since.sincethird.entity.Book;
import com.since.sincethird.entity.WXList;
import com.since.sincethird.service.BookService;
import com.since.sincethird.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 王英豪111
 */
@RestController
@RequestMapping("/list")
public class ListController {

    @Autowired
    private ListService listService;

    @Autowired
    private BookService bookService;



    @RequestMapping("/add")
    public Ret add(WXList wxList){
        Long book_id = Long.valueOf(wxList.getBook_id());
        Book book = bookService.findById(book_id);
        Ret ret = null;
        if ( wxList.getBook_num() >= book.getBookcount()){
            ret = new Ret(ListResult.NO_NUM,"");
            return ret;
        }
        List<WXList> wxLists = listService.save(wxList);
        ret = new Ret(Result.SUCCESS,wxLists);
        return ret;
    }



    @RequestMapping("/findListByOpenId")
    public Ret findListByOpenId(String open_id){
        List<WXList> wxLists = listService.findListByOpenId(open_id);
        Ret ret = null;
        if (open_id == null){
           ret = new Ret(ListResult.OPENID_NOT_FOUND,"");
           return ret;
       }
        ret = new Ret(Result.SUCCESS,wxLists);

       return ret;
    }

    @RequestMapping("/modify")
    public Ret modify(WXList wxList){
       List<WXList> wxLists = listService.save(wxList);
        Ret ret = null;
        if (wxList.getOpen_id() == null){
            ret = new Ret(ListResult.ORDERID_NOT_FOUND,"");
            return ret;
        }
        ret = new Ret(Result.SUCCESS,wxLists);

        return ret;
    }
}

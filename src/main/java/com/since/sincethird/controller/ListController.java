package com.since.sincethird.controller;


import com.since.sincethird.ret.ListResult;
import com.since.sincethird.ret.Result;
import com.since.sincethird.ret.Ret;
import com.since.sincethird.entity.Book;
import com.since.sincethird.entity.WXList;
import com.since.sincethird.service.BookService;
import com.since.sincethird.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 王英豪111
 */
@Controller
@RequestMapping("/list")
public class ListController {

    @Autowired
    private ListService listService;

    @Autowired
    private BookService bookService;



    @RequestMapping("/add")
    @ResponseBody
    public Ret add(@RequestBody WXList wxList){
        Long book_id = Long.valueOf(wxList.getBookId());
        Book book = bookService.findById(book_id);
        Ret ret = null;
        if ( wxList.getBookNum() > book.getBookcount()){
            ret = new Ret(ListResult.LIST_BOOK_NUM_NO,"");
            return ret;
        } else if(book.getBookcount() - wxList.getBookNum() == 0){
            book.setBookstatus(2);
        }
        WXList wxLists = listService.save(wxList);
        ret = new Ret(Result.SUCCESS,wxLists);
        return ret;
    }



    @RequestMapping("/findListByOpenId")
    @ResponseBody
    public Ret findListByOpenId(@RequestBody HashMap<String,String> map){
        List<WXList> wxLists = listService.findListByOpenId(map.get("openId"));
        Ret ret = null;
        if (map.get("openId") == ""){
           ret = new Ret(ListResult.LIST_OPENID_NOT_FOUND,"");
           return ret;
       }
        ret = new Ret(Result.SUCCESS,wxLists);

       return ret;
    }


    @RequestMapping("/modify")
    @ResponseBody
    public Ret modify(@RequestBody HashMap<String,String> map){
        Ret ret = null;
        if (map.get("id") == ""){
            ret = new Ret(ListResult.LIST_ID_NOT_FOUND,"");
            return ret;
        }
        Long list_id = Long.valueOf(map.get("id"));
        WXList wxList = listService.findWXListById(list_id);
        wxList.setStatus(1);
        WXList wxLists = listService.save(wxList);
        ret = new Ret(Result.SUCCESS,wxLists);

        return ret;
    }
}

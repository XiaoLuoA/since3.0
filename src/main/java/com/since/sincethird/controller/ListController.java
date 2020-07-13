package com.since.sincethird.controller;


import com.since.sincethird.ret.ListResult;
import com.since.sincethird.ret.Result;
import com.since.sincethird.ret.Ret;
import com.since.sincethird.entity.Book;
import com.since.sincethird.entity.WXList;
import com.since.sincethird.service.BookService;
import com.since.sincethird.service.ListService;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
        Ret ret = null;
        WXList wxList1 = listService.save(wxList);
        if (wxList1 == null){
            ret = new Ret(ListResult.LIST_BOOK_NUM_NO,"");
            return ret;
        }
        ret = new Ret(Result.SUCCESS,wxList1);
        return ret;
    }

    @RequestMapping("/pay")
    @ResponseBody
    public Ret pay(@RequestBody WXList wxList,String WXcode){

        Ret ret = null;
        WXList wxList1 = listService.pay(wxList,WXcode);
        if (wxList1 == null){
            ret = new Ret(ListResult.LIST_PAY_FAIL,"");
            return ret;
        }

        ret = new Ret(Result.SUCCESS,wxList1);
        return ret;
    }

    @RequestMapping("/buy")
    @ResponseBody
    public Ret buy(@RequestBody WXList wxList){
        Ret ret;
        WXList wxList1 = listService.buy(wxList);
        if (wxList1 == null){
            ret = new Ret(ListResult.LIST_PAY_FAIL,"");
            return ret;
        }

        ret = new Ret(Result.SUCCESS,wxList1);
        return ret;
    }





    @RequestMapping("/findListByOpenId")
    @ResponseBody
    public Ret findListByOpenId(String openId){

        List<WXList> wxLists = listService.findListByOpenId(openId);
        Ret ret = null;
        if (openId == null || "".equals(openId)){
           ret = new Ret(ListResult.LIST_OPENID_NOT_FOUND,"");
           return ret;
       }
        ret = new Ret(Result.SUCCESS,wxLists);

       return ret;
    }


    @RequestMapping("/modify")
    @ResponseBody
    public Ret modify(String id){
        Ret ret = null;
        if (id == null || "".equals(id)){
            ret = new Ret(ListResult.LIST_ID_NOT_FOUND,"");
            return ret;
        }
        Long list_id = Long.valueOf(id);
        WXList wxList = listService.findWXListById(list_id);
        WXList wxLists = listService.modifyList(wxList);
        ret = new Ret(Result.SUCCESS,wxLists);

        return ret;
    }


    @RequestMapping("/delete")
    @ResponseBody
    public Ret detele(String id){
        Ret ret = null;
        if (id == null || "".equals(id)){
            ret = new Ret(ListResult.LIST_ID_NOT_FOUND,"");
            return ret;
        }
        Long list_id = Long.valueOf(id);
        WXList wxList = listService.findWXListById(list_id);
        WXList wxLists = listService.deleteList(wxList);
        ret = new Ret(Result.SUCCESS,wxLists);

        return ret;
    }
}

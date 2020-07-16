package com.since.sincethird.controller;


import com.since.sincethird.common.Status;
import com.since.sincethird.ret.ListResult;
import com.since.sincethird.ret.Ret;
import com.since.sincethird.entity.WXList;
import com.since.sincethird.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("/add")
    @ResponseBody
    public Ret add(@RequestBody WXList wxList){
        WXList wxList1 = listService.save(wxList);
        if (wxList1 == null){
            return Ret.error(ListResult.LIST_BOOK_NUM_NO);
        }
        return Ret.success(wxList1);
    }



    @RequestMapping("/buy")
    @ResponseBody
    public Ret buy(@RequestBody WXList wxList){
        WXList wxList1 = listService.buy(wxList);
        if (wxList1 == null){
            return Ret.error(ListResult.LIST_PAY_FAIL);
        }
        return Ret.success(wxList1);
    }





    @RequestMapping("/findListByOpenId")
    @ResponseBody
    public Ret findListByOpenId(String openId){
        List<WXList> wxLists = listService.findListByOpenId(openId);
        if (openId == null || "".equals(openId)){
           return Ret.error(ListResult.LIST_ID_NOT_FOUND);
       }
       return Ret.success(wxLists);
    }



    @RequestMapping("/findAllWxList")
    @ResponseBody
    public Ret findAllWxList(){
        List<WXList> wxLists = listService.findAllWxList();
           return Ret.success(wxLists);
    }


    @RequestMapping("/modify")
    @ResponseBody
    public Ret sendGoods(String no){
         if (no == null || "".equals(no)){
             return Ret.error(ListResult.LIST_ID_NOT_FOUND);
         }
         WXList wxList = listService.findByNo(no);
         if (wxList.getStatus() != Status.WX_LIST_PAY){
             return Ret.error(ListResult.LIST_SEND_FAIL);
         }
         Boolean flag = listService.modifyList(no,Status.WX_LIST_PAY_SEND);
         if (flag == false){
             return Ret.error(ListResult.LIST_SEND_FAIL);
         }
         return Ret.success(null);
    }
}

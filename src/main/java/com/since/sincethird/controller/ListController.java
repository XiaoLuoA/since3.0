package com.since.sincethird.controller;


import com.since.sincethird.common.ListResult;
import com.since.sincethird.common.Ret;
import com.since.sincethird.entity.WXList;
import com.since.sincethird.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 王英豪111
 */
@RestController
@RequestMapping("/list")
public class ListController {

    @Autowired
    private ListService listService;



    @RequestMapping("/add")
    public Ret add(WXList wxList){
        listService.add(wxList);
        Ret ret = new Ret();

        return ret;
    }



    @RequestMapping("findListByOpenId")
    private Ret findListByOpenId(String open_id){
       WXList wxList = listService.findListByOpenId(open_id);
        Ret ret = null;
        if (open_id == null){
           ret = new Ret(ListResult.OPENID_NOT_FOUND,wxList);
       }

       return ret;
    }

    @RequestMapping("modify")
    private Ret modify(Long id){
       listService.modify(id);
        Ret ret = null;
        if (id == null){
            ret = new Ret(ListResult.ORDERID_NOT_FOUND,null);
        }

        return ret;
    }
}

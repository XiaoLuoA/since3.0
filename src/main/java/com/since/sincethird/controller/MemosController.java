package com.since.sincethird.controller;

import com.since.sincethird.common.MemosResult;
import com.since.sincethird.common.Ret;
import com.since.sincethird.common.UserResult;
import com.since.sincethird.entity.WXMemos;
import com.since.sincethird.service.MemosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static com.since.sincethird.common.MemosResult.*;

/**
 * @author jayzh
 */
@Controller
@RequestMapping("/memos")
public class MemosController {
    @Autowired
    MemosService memosService;

    @RequestMapping("/add")
    @ResponseBody
    public Ret addMemos(@RequestBody WXMemos wXMemos){
        System.out.println(wXMemos);
        Ret ret ;
        if (null==wXMemos){
            ret= new Ret(MEMOS_OBJ_IS_NULL,null);
        }
        if (null==wXMemos.getMessage()){
            ret= new Ret(MEMOS_MESSAGE_IS_NULL,null);
        }
        WXMemos xWMemos=memosService.save(wXMemos);
        ret= new Ret(MemosResult.SUCCESS,xWMemos);
        return ret;
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public Ret findAllMemos(){
        System.out.println("访问到数据");
        List<WXMemos> allMemos=memosService.findAllMemos();
        Ret ret;
        if (allMemos.size()<1){
            ret= new Ret(MemosResult.MEMOS_GET_IS_NULL,null);
        }
        System.out.println(allMemos);
        ret= new Ret(MemosResult.SUCCESS,allMemos);
        return ret;
    }
}

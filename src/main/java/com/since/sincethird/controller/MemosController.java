package com.since.sincethird.controller;

import com.since.sincethird.ret.MemosResult;
import com.since.sincethird.ret.Ret;
import com.since.sincethird.entity.WXMemos;
import com.since.sincethird.service.MemosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static com.since.sincethird.ret.MemosResult.*;

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
        Ret ret ;
        if (null==wXMemos){
            ret= new Ret(MEMOS_OBJ_IS_NULL,null);
            return ret;
        }
        if (null==wXMemos.getMessage()){
            ret= new Ret(MEMOS_MESSAGE_IS_NULL,null);
            return ret;
        }
        WXMemos xWMemos=memosService.save(wXMemos);
        ret= new Ret(MemosResult.SUCCESS,xWMemos);
        return ret;
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public Ret findAllMemos(){
        List<WXMemos> allMemos=memosService.findAllMemos();
        Ret ret;
        if (allMemos.size()<1){
            ret= new Ret(MemosResult.MEMOS_GET_IS_NULL,null);
            return ret;
        }
        ret= new Ret(MemosResult.SUCCESS,allMemos);
        return ret;
    }
}

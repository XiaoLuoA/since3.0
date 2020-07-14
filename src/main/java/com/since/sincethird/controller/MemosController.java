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
    public Ret addMemos(@RequestBody WXMemos wxMemos){
        if (null==wxMemos){
            return Ret.error(MEMOS_OBJ_IS_NULL);
        }
        if (null==wxMemos.getMessage()){
            return Ret.error(MEMOS_MESSAGE_IS_NULL);
        }
        WXMemos data =memosService.save(wxMemos);
        return Ret.success(data);
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public Ret findAllMemos(){
        List<WXMemos> allMemos=memosService.findAllMemos();
        if (allMemos.size()<1){
            return Ret.error(MEMOS_GET_IS_NULL);
        }
        return Ret.success(allMemos);
    }
    @RequestMapping("/delete")
    @ResponseBody
    public Ret deleteMemos(String  id){
        Integer mid;
        try{
            mid=Integer.parseInt(id);
            try{
                memosService.deleteById(mid);
            }catch (Exception e){
                return Ret.error(MEMOS_NOT_EXIT);
            }
        }catch (NumberFormatException e){
            return Ret.error(MEMOS_ID_GET_FAIL);
        }
        return Ret.success("删除成功");
    }

}

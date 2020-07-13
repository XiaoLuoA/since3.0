package com.since.sincethird.controller;

import com.since.sincethird.dto.Attach;
import com.since.sincethird.ret.Ret;
import com.since.sincethird.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * @author luoxinyuan
 */
@Controller
@RequestMapping("/test")
public class DogController{

    @Autowired
    DogService dogService;

    @RequestMapping("/login")
    @ResponseBody
    public Ret login(@RequestBody Attach attach){
        //  在转成不同的实体类
        System.out.println(attach);
        return new Ret();
    }

}

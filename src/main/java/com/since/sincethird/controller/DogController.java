package com.since.sincethird.controller;

import com.since.sincethird.common.CODE;
import com.since.sincethird.common.Ret;
import com.since.sincethird.entity.Dog;
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
    public Ret login(@RequestBody Dog dog){
        System.out.println(dog);
        dog = dogService.findById(dog.getId());
        Ret ret = new Ret(CODE.USER_NOT_FIND_ERROR,dog);
        return ret;
    }

}

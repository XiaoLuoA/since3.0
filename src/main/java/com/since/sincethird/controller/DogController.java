package com.since.sincethird.controller;

import com.since.sincethird.ret.Ret;
import com.since.sincethird.ret.UserResult;
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
        Ret ret = new Ret(UserResult.USER_NOT_FIND,dog);
        return ret;
    }

}

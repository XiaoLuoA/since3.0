package com.since.sincethird.controller;

import com.since.sincethird.common.CODE;
import com.since.sincethird.common.Ret;
import com.since.sincethird.entity.WXUser;
import com.since.sincethird.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author luoxinyuan
 */
@Controller
@RequestMapping("/user")
public class UserController{

    @Autowired
    UserService userService;

    @RequestMapping("/add")
    @ResponseBody
    public Ret add(@RequestBody WXUser WXUser){
        System.out.println(WXUser);
        WXUser.setStatus("1");
        WXUser = userService.save(WXUser);
        Ret ret = new Ret(CODE.USER_NOT_FIND_ERROR, WXUser);
        return ret;
    }

    @RequestMapping("/find")
    @ResponseBody
    public Ret add(Long id){
        WXUser user = userService.findById(id);
        Ret ret = new Ret(CODE.USER_NOT_FIND_ERROR, user);
        return ret;
    }

}


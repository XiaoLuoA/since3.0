package com.since.sincethird.controller;
import com.since.sincethird.common.Ret;
import com.since.sincethird.common.UserResult;
import com.since.sincethird.entity.WXUser;
import com.since.sincethird.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


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
        WXUser user=userService.findByOpenId(WXUser.getOpenId());
        if (user!=null){
            user.setStatus("1");
            user = userService.save(user);
            Ret ret = new Ret(UserResult.USER_SUCCESS, user);
            return ret;
        }else{
            Ret ret = new Ret(UserResult.USER_SUCCESS, user);
            return ret;
        }



    }

    @RequestMapping("/find")
    @ResponseBody
    public Ret add(Long id){
        WXUser user = userService.findById(id);
        Ret ret = new Ret(UserResult.USER_NOT_FIND, user);
        return ret;
    }

    @RequestMapping("/findUserByOpenId")
    @ResponseBody
    public Ret findByOpenId(@RequestBody Map<String,String> map){
        WXUser user=userService.findByOpenId(map.get("open_id"));
        if (user!=null){
            Ret ret = new Ret(UserResult.USER_SUCCESS, user);
            return ret;
        }else{
            Ret ret = new Ret(UserResult.USER_NOT_FIND, user);
            return ret;
        }

    }


}


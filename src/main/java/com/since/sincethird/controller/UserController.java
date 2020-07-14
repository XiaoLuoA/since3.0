package com.since.sincethird.controller;
import com.since.sincethird.ret.Ret;
import com.since.sincethird.common.SessionKey;
import com.since.sincethird.ret.UserResult;
import com.since.sincethird.entity.WXUser;
import com.since.sincethird.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


/**
 * @author luoxinyuan
 */
@Controller
@RequestMapping("/user")
public class UserController{

    @Autowired
    UserService userService;

    @Autowired
    HttpServletRequest httpServletRequest;

    @RequestMapping("/index")
    public String index(){
        return "user/index";
    }


    @RequestMapping("/login")
    @ResponseBody
    public Ret add(){
        WXUser wxUser = (WXUser)(httpServletRequest.getSession().getAttribute(SessionKey.LOGIN_USER));
        if (wxUser==null){
            return Ret.error(UserResult.USER_NOT_FIND);
        }
        return Ret.success(wxUser);
    }

    @RequestMapping("/findUserByOpenId")
    @ResponseBody
    public Ret findByOpenId(String openId){
        WXUser user=userService.findByOpenId(openId);
        if (user!=null){
            return Ret.success(user);
        }else{
            return Ret.error(UserResult.USER_NOT_FIND);
        }
    }


}


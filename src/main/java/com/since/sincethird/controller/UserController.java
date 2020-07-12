package com.since.sincethird.controller;
import com.since.sincethird.ret.Result;
import com.since.sincethird.ret.Ret;
import com.since.sincethird.common.SessionKey;
import com.since.sincethird.ret.UserResult;
import com.since.sincethird.entity.WXUser;
import com.since.sincethird.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
        Ret ret ;
        if (wxUser==null){
             ret = new Ret(UserResult.USER_NOT_FIND, wxUser);
            return ret;
        }
        ret = new Ret(Result.SUCCESS,wxUser);
        return ret;
    }

    @RequestMapping("/findUserByOpenId")
    @ResponseBody
    public Ret findByOpenId(String open_id){
        WXUser user=userService.findByOpenId(open_id);
        if (user!=null){
            Ret ret = new Ret(Result.SUCCESS, user);
            return ret;
        }else{
            Ret ret = new Ret(UserResult.USER_NOT_FIND, user);
            return ret;
        }
    }


}


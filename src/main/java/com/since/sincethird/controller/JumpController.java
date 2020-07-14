package com.since.sincethird.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/to")
public class JumpController {

    @RequestMapping("/about")
    public String about(){
        return "/about/index";
    }

    @RequestMapping("/attention")
    public String attention(){
        return "/attention/index";
    }

    @RequestMapping("/cooperation")
    public String coperation(){
        return "/cooperation/index";
    }

    @RequestMapping("/error")
    public String error(){
        return "/error/index";
    }

    @RequestMapping("/push_list")
    public String push(){
        return "/push_list/index";
    }

    @RequestMapping("/user")
    public String user(){
        return "/wx_user/index";
    }

    @RequestMapping("/test")
    public String test(){
        return "/user/index";
    }


    @RequestMapping("/buy")
    public String buy(){
        return "/wx_buy/index";
    }

    @RequestMapping("/index")
    public String index(){
        return "/wx_index/index";
    }

    @RequestMapping("/memos")
    public String memos(){
        return "/wx_memos/index";
    }

    @RequestMapping("/list")
    public String list(){
        return "/wx_list/index";
    }

}

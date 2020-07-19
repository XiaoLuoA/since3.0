package com.since.sincethird.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author luoxinyuan
 */
@Controller

public class IndexController {
    @RequestMapping("/")
    public String index()  {
        return "forward:/to/index";
    }
}

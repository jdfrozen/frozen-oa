package com.zjjw.zjjwserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: Frozen
 * @create: 2019-08-23 13:59
 * @description:
 **/
@Controller
@RequestMapping("/")
public class IndexController {
    @RequestMapping(value = "sendMsg")
    @ResponseBody
    public String sendMsg(@RequestParam String msg){
        return "success";
    }
}

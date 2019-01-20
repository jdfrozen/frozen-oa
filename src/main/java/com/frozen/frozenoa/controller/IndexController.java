package com.frozen.frozenoa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: 冯默风
 * @Date: 2019/1/20 15:48
 * @Description:
 */
@Controller
public class IndexController {
    @RequestMapping("/index")
    public String index(ModelMap map){
        map.put("welcome","SpringBoot Hello World！");
        return "index";
    }

    @RequestMapping("/love")
    public String love(ModelMap map){
        map.put("welcome","SpringBoot Hello World！");
        return "love";
    }
}

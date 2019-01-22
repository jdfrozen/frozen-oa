package com.frozen.frozenoa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: 冯默风
 * @Date: 2019/1/20 15:48
 * @Description:
 */
@Controller
public class LoveController {
    @RequestMapping("/frozen/index")
    public String index(ModelMap map){
        map.put("welcome","SpringBoot Hello World！");
        return "frozen/index.html";
    }

    @RequestMapping("/frozen/love")
    public String love(ModelMap map){
        map.put("welcome","SpringBoot Hello World！");
        return "frozen/love.html";
    }
}

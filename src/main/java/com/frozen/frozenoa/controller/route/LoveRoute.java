package com.frozen.frozenoa.controller.route;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: Frozen
 * @Date: 2019/1/30 17:09
 * @Description:
 */
@Controller
public class LoveRoute {
    @RequestMapping("/frozen/love")
    public String love(ModelMap map){
        map.put("welcome","SpringBoot Hello World！");
        return "frozen/love.html";
    }
}

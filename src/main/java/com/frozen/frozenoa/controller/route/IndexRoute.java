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
public class IndexRoute {
    /**
     * 主页
     * @param map
     * @return
     */
    @RequestMapping("/index")
    public String index(ModelMap map){
        return "index.html";
    }
}

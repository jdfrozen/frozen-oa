package com.frozen.frozenoa.controller.route;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: Frozen
 * @Date: 2019/1/30 17:09
 * @Description: 主页相关的路由
 */
@Controller
public class SystemRoute {
    /**
     * 主页
     * @param map
     * @return
     */
    @RequestMapping("/system/main")
    public String index(ModelMap map){
        return "/system/main/main";
    }


}

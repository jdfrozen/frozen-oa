package com.frozen.frozenoa.controller.route;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @Auther: Frozen
 * @Date: 2019/1/30 17:09
 * @Description:
 */
@Controller
public class LoginRoute {
    /**
     * 登出
     * @param session
     * @return
     */
    @RequestMapping("/logOut")
    public String logOut(HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
//        session.removeAttribute("user");
        return "login";
    }
    /**
     * 登录
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}

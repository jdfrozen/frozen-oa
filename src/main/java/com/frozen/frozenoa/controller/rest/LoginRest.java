package com.frozen.frozenoa.controller.rest;

import com.frozen.frozenoa.web.AjaxResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Auther: Frozen
 * @Date: 2019/1/30 17:09
 * @Description:
 */
@RestController
public class LoginRest {
    /**
     * 用户登录
     * @param username
     * @param password
     * @param session
     * @return
     */
    @RequestMapping("/loginUser")
    public AjaxResult loginUser(String username, String password, HttpSession session) {
        //授权认证
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        try {
            //完成登录
            subject.login(usernamePasswordToken);
            return new AjaxResult();
        } catch(Exception e) {
            return new AjaxResult(AjaxResult.FAILED);
        }
    }
}

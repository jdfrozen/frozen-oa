package com.frozen.frozenoa.shiro.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: 冯默风
 * @Date: 2019/1/30 10:00
 * @Description:
 */
@Configuration
@ConfigurationProperties(prefix = "shiro.user")
@Data
public class ShiroUserProperties {
    // 验证码开关
    private boolean captchaEnabled;

    // 验证码类型
    private String captchaType;

    // 登录地址
    private String loginUrl;

    // 权限认证失败地址
    private String unauthorizedUrl;
}

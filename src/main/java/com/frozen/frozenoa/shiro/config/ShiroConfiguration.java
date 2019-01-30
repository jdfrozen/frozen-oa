package com.frozen.frozenoa.shiro.config;

import com.frozen.frozenoa.shiro.filter.OnlineSessionFilter;
import com.frozen.frozenoa.shiro.realm.AuthRealm;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro的配置类
 * @author frozen
 *
 */
@Slf4j
@Configuration
public class ShiroConfiguration {

    @Autowired
    ShiroUserProperties shiroUserProperties;

    @Bean(name="shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        // Shiro的核心安全接口,这个属性是必须的
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //配置登录的url和登录成功的url
        shiroFilterFactoryBean.setLoginUrl(shiroUserProperties.getLoginUrl());
        // 权限认证失败，则跳转到指定页面
        shiroFilterFactoryBean.setUnauthorizedUrl(shiroUserProperties.getUnauthorizedUrl());
        // Shiro连接约束配置，即过滤链的定义
        LinkedHashMap<String, String> filterChainDefinitionMap=new LinkedHashMap<>();
        // 对静态资源设置匿名访问
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/docs/**", "anon");
        filterChainDefinitionMap.put("/fonts/**", "anon");
        filterChainDefinitionMap.put("/img/**", "anon");
        filterChainDefinitionMap.put("/ajax/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/druid/**", "anon");
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/loginUser", "anon");
        // 退出 logout地址，shiro去清除session
        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/*", "authc");//表示需要认证才可以访问
        filterChainDefinitionMap.put("/**", "authc");//表示需要认证才可以访问
        filterChainDefinitionMap.put("/*.*", "authc");
        // 系统权限列表
        Map<String, Filter> filters = new LinkedHashMap<>();
        filters.put("onlineSession", onlineSessionFilter());
        shiroFilterFactoryBean.setFilters(filters);
        // 所有请求需要认证
        filterChainDefinitionMap.put("/**", "user,onlineSession");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }
    //配置核心安全事务管理器
    @Bean(name="securityManager")
    public SecurityManager securityManager(@Qualifier("authRealm") AuthRealm authRealm) {
        log.info("--------------shiro已经加载----------------");
        DefaultWebSecurityManager manager=new DefaultWebSecurityManager();
        manager.setRealm(authRealm);
        return manager;
    }
    //配置自定义的权限登录器
    @Bean(name="authRealm")
    public AuthRealm authRealm() {
        AuthRealm authRealm=new AuthRealm();
        return authRealm;
    }

    /**
     * 开启Shiro注解通知器
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager manager) {
        AuthorizationAttributeSourceAdvisor advisor=new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(manager);
        return advisor;
    }

    /**
     * 自定义在线用户处理过滤器
     */
    @Bean
    public OnlineSessionFilter onlineSessionFilter()
    {
        OnlineSessionFilter onlineSessionFilter = new OnlineSessionFilter();
        onlineSessionFilter.setLoginUrl(shiroUserProperties.getLoginUrl());
        return onlineSessionFilter;
    }
}
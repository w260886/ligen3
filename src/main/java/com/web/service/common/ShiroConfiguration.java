package com.web.service.common;

import com.web.service.controller.BaseController;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;


@Configuration
public class ShiroConfiguration extends BaseController {
    /**
     * 注入Realm
     * @return MyRealm
     */
    @Bean(name = "myRealm")
    public MyRealm myAuthRealm() {
        MyRealm myRealm = new MyRealm();
        log.info("myRealm注册完成");
        return myRealm;
    }


    /**
     * 注入SecurityManager
     * @param myRealm
     * @return SecurityManager
     */
    @Bean(name = "securityManager")
    public SecurityManager securityManager(@Qualifier("myRealm")MyRealm myRealm) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(myRealm);
        log.info("securityManager注册完成");
        return manager;
    }

    /**
     * 注入Filter
     * @param securityManager
     * @return ShiroFilterFactoryBean
     */
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager securityManager) {
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        filterFactoryBean.setSecurityManager(securityManager);
        // 配置登录的url和登录成功的url
        filterFactoryBean.setLoginUrl("/login.html");
        filterFactoryBean.setSuccessUrl("/index.html");
        // 配置未授权跳转页面
        filterFactoryBean.setUnauthorizedUrl("/errorPage/403");
        // 配置访问权限
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/common/**", "anon"); // 表示可以匿名访问
        filterChainDefinitionMap.put("/login_in", "anon"); // 表示可以匿名访问
//        filterChainDefinitionMap.put("/common/css/**", "anon");
//        filterChainDefinitionMap.put("/common/font/**", "anon");
//        filterChainDefinitionMap.put("/common/font-awesome-4.0.3/**", "anon");
//        filterChainDefinitionMap.put("/common/images/**", "anon");
//        filterChainDefinitionMap.put("/common/img/**", "anon");
//        filterChainDefinitionMap.put("/common/javascript/**", "anon");
//        filterChainDefinitionMap.put("/common/js/**", "anon");
//        filterChainDefinitionMap.put("/common/style/**", "anon");
//        filterChainDefinitionMap.put("/common/webjars/**", "anon");
        filterChainDefinitionMap.put("/login.html", "anon");
        filterChainDefinitionMap.put("/404-page.html", "anon");
        filterChainDefinitionMap.put("/admin/**", "roles[admin]");// 表示admin权限才可以访问，多个加引号用逗号相隔
        filterChainDefinitionMap.put("/*", "authc");// 表示需要认证才可以访问
        filterChainDefinitionMap.put("/**", "authc");
        filterChainDefinitionMap.put("/*.*", "authc");
        filterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        log.info("shiroFilter注册完成");
        return filterFactoryBean;
    }

}

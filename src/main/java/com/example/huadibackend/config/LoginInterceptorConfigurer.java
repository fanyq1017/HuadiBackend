package com.example.huadibackend.config;

import com.example.huadibackend.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/** 注册处理器拦截器 */
@Configuration
public class LoginInterceptorConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 创建拦截器对象
        HandlerInterceptor interceptor = new LoginInterceptor();

        // 设置白名单
        List<String> patterns = new ArrayList<String>();
        // 先将所有静态资源放入白名单，否则加载页面时静态资源会被拦截
        patterns.add("/bootstrap3/**");
        patterns.add("/css/**");
        patterns.add("images/**");
        patterns.add("/js/**");


        // 通过注册工具添加拦截器
        registry.addInterceptor(interceptor).addPathPatterns("/**")
                .excludePathPatterns(patterns);

    }
}

package com.getnovel.config;

import com.getnovel.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置
 */
@Configuration
public class InterCeptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册登陆拦截
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/OAuth/user/*/**","/OAuth/user");// 需要拦截的路径
      //  registry.addInterceptor(new LoginInterceptor()).excludePathPatterns("/"); /*放过的路径*/
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}

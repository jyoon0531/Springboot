package com.study.Ex14RealDB.config;

import com.study.Ex14RealDB.interceptor.AdminInterceptor;
import com.study.Ex14RealDB.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AdminInterceptor())
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin", "/admin/adminLoginAction");

        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/customer/**");
    }
}

package com.study.Ex14RealDB.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String loginId = (String) request.getSession().getAttribute("loginId");
        if (loginId == null) {
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            String alertScript = "<script>alert('로그인을 해주세요.'); location.href='/member/login';</script>";
            response.getWriter().write(alertScript);
            return false;
        }
        return true;
    }
}

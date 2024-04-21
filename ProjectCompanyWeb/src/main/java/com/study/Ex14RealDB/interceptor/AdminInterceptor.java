package com.study.Ex14RealDB.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String adminId = (String) request.getSession().getAttribute("adminId");
        if (adminId == null) {
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            String alertScript = "<script>alert('관리자만 접근 가능합니다.'); location.href='/admin';</script>";
            response.getWriter().write(alertScript);
            return false;
        }
        return true;
    }
}

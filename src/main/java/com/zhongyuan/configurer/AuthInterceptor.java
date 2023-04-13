package com.zhongyuan.configurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;


public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String method = request.getMethod();
        if(method!=null && "OPTIONS".equals(method))
            return true;

        //TODO： 处理TOKEN
        String header = request.getHeader("X-TOKEN");
        return true;
    }
}

package com.wxy.config;

import com.wxy.pojo.Admin;
import com.wxy.pojo.User;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        User userInfo =(User) request.getSession().getAttribute("user");
        Admin admin =(Admin) request.getSession().getAttribute("admin");

        if (!StringUtils.isEmpty(userInfo)){
            return true;
        }

        if (!StringUtils.isEmpty(admin)){
            return true;
        }
        request.setAttribute("Msg","没有权限请登录");
        request.getRequestDispatcher("/toLogin").forward(request,response);
        return false;
    }

}

package com.lmj.forum.controller.Intercept;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserIntercept implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //System.out.println("preHandle 拦截器拦截了");
        //判断是否有登陆,没有登陆跳转到登陆界面
        HttpSession session = request.getSession();
        Object object = session.getAttribute("user");
        if(object!=null) {
            //放行
            return true;
        }else {
            //跳转到登陆界面
            response.sendRedirect(request.getContextPath()+ "/login");
            return false;
        }
    }

}

package com.coder520.common.interceptor;

import com.coder520.user.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author : Hellxz
 * @Description: 检查session中是否有
 * @Date : 2018/3/7 12:41
 */
public class SessionInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String uri = request.getRequestURI();
        if(uri.indexOf("login")>=0){ //uri中有login字样，说明是正常登录，放行
            return true;
        }
        User user = (User)request.getSession().getAttribute("userinfo");
        if(user!=null){ //判断session中是否有这个用户对象
            return true;
        }
        //转发到登录页面
        request.getRequestDispatcher("/login").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}

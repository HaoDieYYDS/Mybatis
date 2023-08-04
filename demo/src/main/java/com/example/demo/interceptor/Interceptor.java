package com.example.demo.interceptor;

import com.example.demo.pojo.Employee;
import com.example.demo.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.print.DocFlavor;
import java.util.List;

public class Interceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        System.out.println(session.getAttribute("user"));
        String url = request.getRequestURI();
        if(user != null)
        {
            System.out.println("放行！");
            return true;
        }

            System.out.println("拦截成功！");
            return false;

    }


}

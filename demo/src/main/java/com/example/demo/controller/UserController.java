package com.example.demo.controller;

import com.example.demo.dao.UserMapper;
import com.example.demo.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserMapper userMapper;

    @RequestMapping("/login")
    public User login(@RequestBody User user, HttpSession session)
    {
        User user1 =  userMapper.login(user);

        if(user1!=null)
        {
            System.out.println("登录成功！！！！");
            session.setAttribute("user",user1);
            System.out.println(session.getAttribute("user"));
            return user1;
        }
        else {
            System.out.println("用户名或者密码错误！");
            return null;
        }
    }

    @RequestMapping("/register")
    public User register(@RequestBody User user)
    {
        userMapper.register(user);
        System.out.println("注册成功！");
        return user;
    }
    @RequestMapping("/logout/{username}")
    public User logout(@RequestBody @PathVariable String username, HttpSession session, HttpServletRequest request)
    {
        User user = userMapper.selectByName(username);
        session = request.getSession();
        session.invalidate();
        System.out.println("删除成功！");
        return user;
    }

    @RequestMapping("/test")
    public String nothing(HttpSession session){
        User user = new User();
        user.setUsername("asd");
        user.setPassword("123456");
        session.setAttribute("user",user);
        return "Hello World!";
    }
}

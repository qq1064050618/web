package com.moli.servlet;

import com.google.gson.Gson;
import com.moli.entity.User;
import com.moli.service.UserService;
import com.moli.service.impl.UserServiceImpl;
import com.moli.vo.LoginVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/loginServ"})
public class LoginServ extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf-8");
       PrintWriter out=  resp.getWriter();
        String username= req.getParameter("username");
       String password= req.getParameter("password");
        UserService userService=new UserServiceImpl();
       User user= userService.selectUserByUsername(username);
       if (user != null ){
           if (user.getPassword().equals(password)) {
               HttpSession httpSession = req.getSession();
               //登陆成功后将信息存入session中
               httpSession.setAttribute("user", user);
               Cookie cookie = new Cookie("username", user.getUsername());
               cookie.setMaxAge(60 * 60 * 24);
               resp.addCookie(cookie);
               LoginVO loginVO = LoginVO.success();
               String jsonStr = new Gson().toJson(loginVO);
               out.print(jsonStr);
              //resp.sendRedirect("empServ");
           }else {
               LoginVO loginVO=LoginVO.error(1,"密码输入错误！");
               String jsonStr=new Gson().toJson(loginVO);
               out.print(jsonStr);
           }
       }else {
           LoginVO loginVO = LoginVO.error(2,"用户名不存在！");
           String jsonStr = new Gson().toJson(loginVO);
           out.print(jsonStr);
          // resp.sendRedirect("toLoginServ");
       }
    }
}

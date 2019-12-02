package com.moli.servlet;

import com.google.gson.Gson;
import com.moli.entity.Emp;
import com.moli.service.EmpService;
import com.moli.service.impl.EmpServiceImpl;
import com.moli.vo.LoginVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/checkEmp"})
public class CheckEmp extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String name= req.getParameter("name");
        EmpService empService=new EmpServiceImpl();
        Emp emp=empService.selectByName(name);
        if (emp != null){
            resp.setContentType("application/json;charset=utf-8");
            PrintWriter out=resp.getWriter();
            LoginVO loginVO=LoginVO.ok();
            String jsonStr = new Gson().toJson(loginVO);
            out.print(jsonStr);
        }
    }
}

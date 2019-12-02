package com.moli.servlet;

import com.moli.entity.Dept;
import com.moli.service.impl.DeptServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/toAddEmpServ"})
public class ToAddEmpServ extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DeptServiceImpl deptService=new DeptServiceImpl();
        List<Dept> depts=deptService.selectDept();
       // req.setCharacterEncoding("utf-8");
        req.setAttribute("depts",depts);
        //转发
        req.getRequestDispatcher("/WEB-INF/page/addEmp.jsp").forward(req,resp);
    }
}

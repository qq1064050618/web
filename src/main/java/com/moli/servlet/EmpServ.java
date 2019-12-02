package com.moli.servlet;
import com.moli.entity.Emp;
import com.moli.service.EmpService;
import com.moli.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class EmpServ extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmpService empService=new EmpServiceImpl();
        List<Emp> emps=empService.selectEmpDept();
       // req.setCharacterEncoding("utf-8");
        req.setAttribute("emps",emps);
       req.getRequestDispatcher("/WEB-INF/page/empServ.jsp").forward(req,resp);
    }




}

package com.moli.servlet;

import com.moli.entity.Emp;
import com.moli.service.EmpService;
import com.moli.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(urlPatterns = {"/updateServ"})
public class UpdateServ extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmpService empService=new EmpServiceImpl();
        Emp emp=new Emp();
        emp.setEmpId(Integer.parseInt(req.getParameter("empId")));
        emp.setName(req.getParameter("name"));
        emp.setAge(Integer.parseInt(req.getParameter("age")));
        emp.setDeptId(Integer.parseInt(req.getParameter("deptId")));
        emp.setSalary(new BigDecimal(req.getParameter("salary")));
        emp.setSex(req.getParameter("sex"));
        empService.updateEmpById(emp);
        resp.sendRedirect("empServ");
    }
}

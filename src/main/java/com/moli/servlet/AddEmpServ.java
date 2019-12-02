package com.moli.servlet;

import com.moli.entity.Emp;
import com.moli.mapper.EmpMapper;
import com.moli.service.EmpService;
import com.moli.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(urlPatterns = {"/addEmpServ"})
public class AddEmpServ extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        Integer age = Integer.parseInt(req.getParameter("age"));
        String sex = req.getParameter("sex");
        BigDecimal salary = new BigDecimal(req.getParameter("salary"));
       // System.out.println("--------------------------"+req.getParameter("deptId"));
        Integer deptId = Integer.parseInt(req.getParameter("deptId"));
        Emp emp = new Emp();
        emp.setName(name);
        emp.setAge(age);
        emp.setSex(sex);
        emp.setSalary(salary);
        emp.setDeptId(deptId);
        EmpServiceImpl empService=new EmpServiceImpl();
        if (empService.addEmp(emp) > 0){
            resp.sendRedirect("empServ");
        }

    }
}

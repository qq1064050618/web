package com.moli.servlet;

import com.moli.entity.Dept;
import com.moli.entity.Emp;
import com.moli.service.DeptService;
import com.moli.service.EmpService;
import com.moli.service.impl.DeptServiceImpl;
import com.moli.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/toUpdateServ"})
public class ToUpdateServ extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmpService empService=new EmpServiceImpl();
        /*dept需要做选择部门名称的默认选中   dept.deptId=emp.deptId=*/
        DeptService deptService=new DeptServiceImpl();
        List<Dept> depts=deptService.selectDept();
        req.setAttribute("depts",depts);
        int id=Integer.parseInt(req.getParameter("id"));
        Emp emp=empService.selectById(id);
        req.setAttribute("emp",emp);
        req.getRequestDispatcher("/WEB-INF/page/updateEmp.jsp").forward(req,resp);
    }
}

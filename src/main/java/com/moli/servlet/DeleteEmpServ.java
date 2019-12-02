package com.moli.servlet;

import com.moli.service.EmpService;
import com.moli.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = {"/deleteEmpServ"})
public class DeleteEmpServ extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      // req.getParameter("id")
        EmpService empService=new EmpServiceImpl();
        int id=Integer.parseInt(req.getParameter("id"));
        empService.deleteEmp(id);
        resp.sendRedirect("empServ");
    }
}

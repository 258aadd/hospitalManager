package com.ml.controller.depart;

import com.ml.pojo.Departments;
import com.ml.service.DepartmentsService;
import com.ml.service.impl.DepartmentsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/depart/updateDepart")
public class UpdateDepartServlet extends HttpServlet {
    DepartmentsService departmentsService = new DepartmentsServiceImpl();//
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String departname = req.getParameter("departname");
        String departdesc = req.getParameter("departdesc");
        String id = req.getParameter("id");

        Departments departments = new Departments();
        departments.setDepartment_name(departname);
        departments.setDepartment_description(departdesc);
        if(id != null && !id.equals("")) {
            departments.setDepartment_id(Integer.valueOf(id));
        }

        boolean flag = departmentsService.updateDepartment(departments);
        if(flag){
            resp.sendRedirect(req.getContextPath()+"/depart/getDepartList");
        }

    }
}

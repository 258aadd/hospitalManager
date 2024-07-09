package com.ml.controller.depart;

import com.github.pagehelper.PageInfo;
import com.ml.pojo.Departments;
import com.ml.service.DepartmentsService;
import com.ml.service.impl.DepartmentsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/depart/toUpdate")
public class ToUpdateDepartServlet extends HttpServlet {
    DepartmentsService departmentsService = new DepartmentsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String did = req.getParameter("did");
        Departments departments = departmentsService.getDepartmentById(did);
        req.setAttribute("departments", departments);
        req.getRequestDispatcher("/updateDepart.jsp").forward(req, resp);
    }
}

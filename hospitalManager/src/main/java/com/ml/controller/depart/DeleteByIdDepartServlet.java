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

@WebServlet("/depart/deleteById")
public class DeleteByIdDepartServlet extends HttpServlet {
    DepartmentsService departmentsService = new DepartmentsServiceImpl();//
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        boolean flag = departmentsService.deleteById(id);
        if(flag){
            resp.sendRedirect(req.getContextPath()+"/depart/getDepartList");
        }

    }
    /*全部上传标签*/
}

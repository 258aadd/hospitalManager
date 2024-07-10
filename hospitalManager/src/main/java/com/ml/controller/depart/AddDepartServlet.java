package com.ml.controller.depart;

import com.alibaba.fastjson.JSON;
import com.ml.pojo.Departments;
import com.ml.service.DepartmentsService;
import com.ml.service.impl.DepartmentsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/depart/addDepart")
public class AddDepartServlet extends HttpServlet {
    DepartmentsService departmentsService = new DepartmentsServiceImpl();//
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String departname = req.getParameter("departname");
        String departdesc = req.getParameter("departdesc");
        String pid = req.getParameter("pid");

        Departments departments = new Departments();
        departments.setDepartment_name(departname);
        departments.setDepartment_description(departdesc);
        if (pid != null && !pid.equals("")) {
            int dpid = Integer.parseInt(pid);
            departments.setDepartment_pid(Integer.valueOf(pid));
            if (dpid == 0){
                departments.setDepartment_level(1);
            }else {
                departments.setDepartment_level(2);
            }
        }

        boolean flag = departmentsService.addDepartment(departments);
        if(flag){
            resp.sendRedirect(req.getContextPath()+"/depart/getDepartList");
        }

    }
    /*全部上传标签*/
}

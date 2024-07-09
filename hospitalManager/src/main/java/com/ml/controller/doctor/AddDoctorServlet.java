package com.ml.controller.doctor;

import com.ml.pojo.Departments;
import com.ml.service.DepartmentsService;
import com.ml.service.DoctorsService;
import com.ml.service.impl.DepartmentsServiceImpl;
import com.ml.service.impl.DoctorsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doctor/addDoctor")
public class AddDoctorServlet extends HttpServlet {
    private DoctorsService doctorsService = new DoctorsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cid = req.getParameter("cid");
        String num = req.getParameter("num");


        boolean flag = doctorsService.addDoctors(cid,num);
        if(flag){
            resp.sendRedirect(req.getContextPath()+"/doctor/getDoctorList");
        }

    }
}

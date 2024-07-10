package com.ml.controller.doctor;

import com.ml.service.DoctorsService;
import com.ml.service.impl.DoctorsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doctor/deleteById")
public class DeleteByIdServlet extends HttpServlet {
    private DoctorsService doctorsService = new DoctorsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        boolean flag = doctorsService.deleteById(id);
        if(flag){
            resp.sendRedirect(req.getContextPath()+"/doctor/getDoctorList");
        }

    }
    /*全部上传标签*/
}

package com.ml.controller;

import com.ml.pojo.Admins;
import com.ml.pojo.Doctors;
import com.ml.service.AdminsService;
import com.ml.service.DoctorsService;
import com.ml.service.impl.AdminsServiceImpl;
import com.ml.service.impl.DoctorsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
    private AdminsService adminsService = new AdminsServiceImpl();
    private DoctorsService doctorsService = new DoctorsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String rid = req.getParameter("rid");

        if("1".equals(rid)) {
            Admins admins = adminsService.login(name, password);
            System.out.println(admins);
            if(admins != null) {
                req.getSession().setAttribute("admins", admins);
                resp.sendRedirect(req.getContextPath() + "/adminIndex.jsp");
            } else{
                resp.sendRedirect( req.getContextPath() + "/login.jsp?flag=false");
            }
        } else if("2".equals(rid)) {
            System.out.println(name);
            System.out.println(password);

            Doctors doctors = doctorsService.login(name,password);

            if(doctors != null) {
                req.getSession().setAttribute("doctors", doctors);
                resp.sendRedirect(req.getContextPath() + "/doctorIndex.jsp");
            } else {
                resp.sendRedirect( req.getContextPath() + "/login.jsp?flag=false");
            }
        }


    }
}
/*全部上传标签*/
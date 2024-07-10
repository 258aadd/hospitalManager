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

@WebServlet("/user/logout")
public class LogoutServlet extends HttpServlet {
    private AdminsService adminsService = new AdminsServiceImpl();
    private DoctorsService doctorsService = new DoctorsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String rid = req.getParameter("r");
        if("1".equals(rid)){
            req.getSession().removeAttribute("admins");
        } else if("2".equals(rid)){
            req.getSession().removeAttribute("doctors");
        }
        resp.sendRedirect(req.getContextPath() + "/login.jsp");
    }
}
/*全部上传标签*/
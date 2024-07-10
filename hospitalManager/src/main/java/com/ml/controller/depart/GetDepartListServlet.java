package com.ml.controller.depart;

import com.github.pagehelper.PageInfo;
import com.ml.pojo.Admins;
import com.ml.pojo.Doctors;
import com.ml.service.AdminsService;
import com.ml.service.DepartmentsService;
import com.ml.service.DoctorsService;
import com.ml.service.impl.AdminsServiceImpl;
import com.ml.service.impl.DepartmentsServiceImpl;
import com.ml.service.impl.DoctorsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/depart/getDepartList")
public class GetDepartListServlet extends HttpServlet {
    DepartmentsService departmentsService = new DepartmentsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = req.getParameter("page");
        PageInfo pageInfo = departmentsService.getDepartListPage(page, 0);
        req.setAttribute("pageInfo", pageInfo);
        req.getRequestDispatcher("/departList.jsp").forward(req, resp);
    }
    /*全部上传标签*/
}

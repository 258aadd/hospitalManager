package com.ml.controller.doctor;

import com.github.pagehelper.PageInfo;
import com.ml.pojo.DoctorsQuery;
import com.ml.service.DoctorsService;
import com.ml.service.impl.DoctorsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//分页多条件查询
@WebServlet("/doctor/getDoctorList")
public class GetDoctorListServlet extends HttpServlet {
    private DoctorsService doctorsService = new DoctorsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String did = req.getParameter("did");
        String pid = req.getParameter("pid");
        String dname = req.getParameter("dname");
        String jobnum = req.getParameter("jobnum");
        String page = req.getParameter("page");

        DoctorsQuery doctorsQuery = new DoctorsQuery(did, pid, dname, jobnum, page);

        System.out.println();
        System.out.println(doctorsQuery);

        PageInfo pageInfo = doctorsService.getDoctorListPage(doctorsQuery);
        System.out.println();
        System.out.println(pageInfo);
        req.setAttribute("pageInfo", pageInfo);
        req.setAttribute("doctorsQuery", doctorsQuery);
        req.getRequestDispatcher("/doctorList.jsp").forward(req, resp);

    }
}

package com.ml.controller.depart;

import com.alibaba.fastjson.JSON;
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
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/depart/getChildDepartList")
public class GetChildDepartListServlet extends HttpServlet {
    DepartmentsService departmentsService = new DepartmentsServiceImpl();//
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pid = req.getParameter("pid");
        System.out.println("pid = " + pid);
        List<Departments> dlist = departmentsService.getDepartListAll(pid);
        System.out.println("dlist = " + dlist);
        PrintWriter out = resp.getWriter();
        out.print(JSON.toJSON(dlist));
    }
}

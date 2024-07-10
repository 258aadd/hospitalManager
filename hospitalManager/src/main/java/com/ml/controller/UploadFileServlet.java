package com.ml.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet("/uploadFile")
@MultipartConfig
public class UploadFileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("myfile");

        String realPath = req.getServletContext().getRealPath("");
        System.out.println("realPath = " + realPath);
        String submittedFileName = part.getSubmittedFileName();
        System.out.println("submittedFileName = " + submittedFileName);
        part.write(realPath + "/" + submittedFileName);
        req.setAttribute("name", submittedFileName);
        req.getRequestDispatcher("/success.jsp").forward(req, resp);
    }
}

package com.ml.controller.doctor;

import com.ml.pojo.Doctors;
import com.ml.service.DoctorsService;
import com.ml.service.impl.DoctorsServiceImpl;
import com.ml.util.FileUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet("/doctor/updateDoctor")
@MultipartConfig
public class UpdateDoctorServlet extends HttpServlet {

    private DoctorsService doctorsService = new DoctorsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jobnum       = req.getParameter("job_number");
        String name         = req.getParameter("name");
        String phone        = req.getParameter("phone");
        String registerfee  = req.getParameter("registration_fee");
        String introduce    = req.getParameter("introduction");
        String pid          = req.getParameter("pid");
        String entrydate    = req.getParameter("entry_date");
        String email        = req.getParameter("email");
        String avatar       = req.getParameter("avatar");

        Doctors doctor = new Doctors(jobnum,  name,  phone, Double.valueOf(registerfee) ,  introduce,  entrydate,  email, Integer.valueOf(pid) );
        doctor.setAvatar(avatar);

        Part part = req.getPart("myfile");
        if(part != null && part.getSize()> 0){
            String myfile = FileUtil.transferTo(req,"myfile");

            doctor.setAvatar(myfile);
        }

        DoctorsService doctorsService = new DoctorsServiceImpl();
        boolean flag = doctorsService.updateDoctorByJobNumber(doctor);

        if(flag){
            //Doctors doctors = doctorsService.getDoctorByJobNumber(jobnum);
            //req.getSession().setAttribute("doctors",doctors);
            //resp.sendRedirect(req.getContextPath()+"/doctorIndex.jsp");
        }

    }
}

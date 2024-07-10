package com.ml.listener;

import com.ml.pojo.Departments;
import com.ml.pojo.Professional_titles;
import com.ml.service.DepartmentsService;
import com.ml.service.DoctorsService;
import com.ml.service.ProfessionalTitlesService;
import com.ml.service.impl.DepartmentsServiceImpl;
import com.ml.service.impl.ProfessionalTitlesServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

@WebListener
public class MyWebApplicationListener implements ServletContextListener {
    private DepartmentsService departmentsService = new DepartmentsServiceImpl();
    private ProfessionalTitlesService professionalTitlesService = new ProfessionalTitlesServiceImpl();

    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized");

        List<Professional_titles> professional_titlesList = professionalTitlesService.getAllProfessionalTitlesList();

        List<Departments> dlistLevelf = departmentsService.getDepartListLevel(1);
        List<Departments> dlistLevelt = departmentsService.getDepartListLevel(2);

        System.out.println("1111111111111111111111111111111111111111111");
        System.out.println(dlistLevelt);
        System.out.println();

        ServletContext application = sce.getServletContext();
        application.setAttribute("ptlist", professional_titlesList);
        application.setAttribute("dlistLevelf", dlistLevelf);
        application.setAttribute("dlistLevelt", dlistLevelt);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

}
/*全部上传标签*/
package com.ml.service;

import com.github.pagehelper.PageInfo;
import com.ml.pojo.Doctors;
import com.ml.pojo.DoctorsQuery;

import java.sql.SQLException;

public interface DoctorsService {
    Doctors login(String name, String password);

    boolean addDoctors(String cid, String num);

    PageInfo getDoctorListPage(DoctorsQuery doctorsQuery);

    boolean deleteById(String id);
}

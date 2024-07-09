package com.ml.service;

import com.ml.pojo.Doctors;

import java.sql.SQLException;

public interface DoctorsService {
    Doctors login(String name, String password);

    boolean addDoctors(String cid, String num);
}

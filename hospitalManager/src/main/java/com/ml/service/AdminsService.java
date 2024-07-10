package com.ml.service;

import com.ml.pojo.Admins;

import java.sql.SQLException;

public interface AdminsService {
    Admins login(String name, String password);
}
/*全部上传标签*/
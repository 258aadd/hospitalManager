package com.ml.service;

import com.github.pagehelper.PageInfo;
import com.ml.pojo.Departments;

import java.util.List;

public interface DepartmentsService {
    PageInfo getDepartListPage(String page, int pid);

    List<Departments> getDepartListAll(String pid);

    boolean addDepartment(Departments departments);

    Departments getDepartmentById(String did);

    boolean updateDepartment(Departments departments);

    boolean deleteById(String id);

    List<Departments> getDepartListLevel(Integer i);
}
/*全部上传标签*/
package com.ml.service;

import com.github.pagehelper.PageInfo;
import com.ml.pojo.Departments;

import java.util.List;

public interface DepartmentsService {
    PageInfo getDepartListPage(String page, int pid);
}

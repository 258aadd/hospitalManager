package com.ml.mapper;

import com.ml.pojo.Departments;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentsMapper {

    @Select("select * from departments where department_pid = #{pid}")
    List<Departments> getDepartList(int pid) throws SQLException;

    @Insert("insert into departments(department_name, department_pid, department_level, department_description) values (#{department_name}, #{department_pid}, #{department_level}, #{department_description})")
    int addDepartment(Departments departments) throws SQLException;
}

package com.ml.mapper;

import com.ml.pojo.Departments;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentsMapper {

    @Select("select * from departments where department_pid = #{pid}")
    List<Departments> getDepartList(int pid) throws SQLException;

    @Insert("insert into departments(department_name, department_pid, department_level, department_description) values (#{department_name}, #{department_pid}, #{department_level}, #{department_description})")
    int addDepartment(Departments departments) throws SQLException;

    @Select("select * from departments where department_id = #{did}")
    Departments getDepartmentById(@Param("did") String did);

    @Update("update departments set department_name = #{department_name}, department_description = #{department_description} where department_id = #{department_id}")
    void updateDepartment(Departments departments);
}

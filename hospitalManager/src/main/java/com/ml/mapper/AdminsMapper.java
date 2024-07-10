package com.ml.mapper;

import com.ml.pojo.Admins;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;

public interface AdminsMapper {

    @Select("select * from admins where username = #{uname} and password = #{password}")
    Admins login(@Param("uname") String name,@Param("password") String password) throws SQLException;
}
/*全部上传标签*/
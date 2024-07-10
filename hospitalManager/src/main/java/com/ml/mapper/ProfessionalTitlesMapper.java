package com.ml.mapper;

import com.ml.pojo.Professional_titles;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;
import java.util.List;

public interface ProfessionalTitlesMapper {
    @Select("select * from professional_titles")
    List<Professional_titles> getProfessionalTitlesList() throws SQLException;
}
/*全部上传标签*/
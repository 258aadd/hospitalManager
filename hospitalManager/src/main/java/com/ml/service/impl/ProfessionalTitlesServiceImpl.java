package com.ml.service.impl;

import com.ml.mapper.ProfessionalTitlesMapper;
import com.ml.pojo.Professional_titles;
import com.ml.service.ProfessionalTitlesService;
import com.ml.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class ProfessionalTitlesServiceImpl implements ProfessionalTitlesService {
    @Override
    public List<Professional_titles> getAllProfessionalTitlesList() {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            ProfessionalTitlesMapper professionalTitlesMapper = sqlSession.getMapper(ProfessionalTitlesMapper.class);
            return  professionalTitlesMapper.getProfessionalTitlesList();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return null;
    }
}

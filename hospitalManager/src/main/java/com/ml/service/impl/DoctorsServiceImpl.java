package com.ml.service.impl;

import com.ml.mapper.DoctorsMapper;
import com.ml.pojo.Doctors;
import com.ml.service.DoctorsService;
import com.ml.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;

public class DoctorsServiceImpl implements DoctorsService {
    @Override
    public Doctors login(String name, String password) {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            DoctorsMapper doctorsMapper = sqlSession.getMapper(DoctorsMapper.class);
            return doctorsMapper.login(name, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return null;
    }

    @Override
    public boolean addDoctors(String cid, String num) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            DoctorsMapper doctorsMapper = sqlSession.getMapper(DoctorsMapper.class);
            String jobnumber = doctorsMapper.getJobNumberMax();
            int jobNum = Integer.parseInt(jobnumber);
            for (int i = 0; i < Integer.parseInt(num); i++) {
                doctorsMapper.addDoctor(cid,++jobNum);
            }
            sqlSession.commit();
            return true;
        } catch (SQLException e)
        {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return false;

    }
}

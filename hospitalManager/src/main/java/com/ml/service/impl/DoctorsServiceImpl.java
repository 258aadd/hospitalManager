package com.ml.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ml.mapper.DoctorsMapper;
import com.ml.pojo.Doctors;
import com.ml.pojo.DoctorsQuery;
import com.ml.service.DoctorsService;
import com.ml.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.List;

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

    @Override
    public PageInfo getDoctorListPage(DoctorsQuery doctorsQuery) {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            DoctorsMapper doctorsMapper = sqlSession.getMapper(DoctorsMapper.class);

            String page = doctorsQuery.getPage();
            if(page != null && !"".equals(page)){
                PageHelper.startPage(Integer.valueOf(page), 5);
            } else {
                PageHelper.startPage(1, 5);
            }

            System.out.println();
            System.out.println(doctorsQuery);
            System.out.println();

            List<Doctors> dlist = doctorsMapper.getDoctorList(doctorsQuery);

            PageInfo pageInfo = new PageInfo(dlist);
            System.out.println(pageInfo);
            return pageInfo;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return null;
    }

    @Override
    public boolean deleteById(String id) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            DoctorsMapper doctorsMapper = sqlSession.getMapper(DoctorsMapper.class);
            doctorsMapper.deleteById(id);
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

    @Override
    public boolean updateDoctorByJobNumber(Doctors doctor) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            DoctorsMapper doctorsMapper = sqlSession.getMapper(DoctorsMapper.class);
            doctorsMapper.updateDoctorByJobNumber(doctor);
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
/*全部上传标签*/
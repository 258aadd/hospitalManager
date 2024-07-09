package com.ml.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ml.mapper.DepartmentsMapper;
import com.ml.pojo.Departments;
import com.ml.service.DepartmentsService;
import com.ml.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Collections;
import java.util.List;

public class DepartmentsServiceImpl implements DepartmentsService {
    @Override
    public PageInfo getDepartListPage(String page, int pid) {
        try{
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            DepartmentsMapper departmentsMapper = sqlSession.getMapper(DepartmentsMapper.class);

            if(page != null && ! "".equals(page)){
                PageHelper.startPage(Integer.valueOf(page), 5);
            } else {
                PageHelper.startPage(1, 5);
            }

            List<Departments> departList = departmentsMapper.getDepartList(pid);
            PageInfo<Departments> pageInfo = new PageInfo<>(departList);
            System.out.println(pageInfo);
            return pageInfo;

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return null;
    }

    @Override
    public List<Departments> getDepartListAll(String pid) {
        try{
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            DepartmentsMapper departmentsMapper = sqlSession.getMapper(DepartmentsMapper.class);
            List<Departments> departList = departmentsMapper.getDepartList(Integer.valueOf(pid));
            return departList;

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return null;
    }

    @Override
    public boolean addDepartment(Departments departments) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try{
            DepartmentsMapper departmentsMapper = sqlSession.getMapper(DepartmentsMapper.class);
            departmentsMapper.addDepartment(departments);
            sqlSession.commit();
            return true;
        }catch (Exception e){
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return false;
    }

    @Override
    public Departments getDepartmentById(String did) {
        try{
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            DepartmentsMapper departmentsMapper = sqlSession.getMapper(DepartmentsMapper.class);
            Departments departments = departmentsMapper.getDepartmentById(did);
            return departments;
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return null;
    }

    @Override
    public boolean updateDepartment(Departments departments) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try{
            DepartmentsMapper departmentsMapper = sqlSession.getMapper(DepartmentsMapper.class);
            departmentsMapper.updateDepartment(departments);
            sqlSession.commit();
            return true;
        }catch (Exception e){
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return false;
    }

    @Override
    public boolean deleteById(String id) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try{
            DepartmentsMapper departmentsMapper = sqlSession.getMapper(DepartmentsMapper.class);
            departmentsMapper.deleteById(id);
            sqlSession.commit();
            return true;
        }catch (Exception e){
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return false;
    }
}

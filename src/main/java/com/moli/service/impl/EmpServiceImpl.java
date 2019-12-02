package com.moli.service.impl;

import com.moli.entity.Emp;
import com.moli.mapper.EmpMapper;
import com.moli.service.EmpService;
import com.moli.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class EmpServiceImpl implements EmpService {

    @Override
    public List<Emp> selectEmpDept() {
        SqlSession sqlSession= MybatisUtil.getSqlsession();
        EmpMapper empMapper=sqlSession.getMapper(EmpMapper.class);
        List<Emp> emps=empMapper.selectEmpDept();
        sqlSession.close();
        return emps;
    }

    @Override
    public List<Emp> empList() {
        SqlSession sqlSession= MybatisUtil.getSqlsession();
        EmpMapper empMapper=sqlSession.getMapper(EmpMapper.class);
        List<Emp> emps=empMapper.selectEmp();
        sqlSession.close();
        return emps;
    }

    @Override
    public Emp selectById(int id) {
        SqlSession sqlSession= MybatisUtil.getSqlsession();
        EmpMapper empMapper=sqlSession.getMapper(EmpMapper.class);
        Emp a=empMapper.selectById(id);
        sqlSession.close();
        return  a;
    }

    @Override
    public int updateEmpById(Emp emp) {
        SqlSession sqlSession= MybatisUtil.getSqlsession();
        EmpMapper empMapper=sqlSession.getMapper(EmpMapper.class);
        int a=empMapper.updateEmpById(emp);
        sqlSession.close();
        return  a;
    }

    @Override
    public Emp selectByName(String name) {
        SqlSession sqlSession= MybatisUtil.getSqlsession();
        EmpMapper empMapper=sqlSession.getMapper(EmpMapper.class);
        Emp a=empMapper.selectByName(name);
        sqlSession.close();
        return  a;
    }

    @Override
    public int addEmp(Emp emp) {
        SqlSession sqlSession= MybatisUtil.getSqlsession();
        EmpMapper empMapper=sqlSession.getMapper(EmpMapper.class);
        int a=empMapper.addEmp(emp);
        sqlSession.close();
        return  a;

    }

    @Override
    public int deleteEmp(int id) {
        SqlSession sqlSession= MybatisUtil.getSqlsession();
        EmpMapper empMapper=sqlSession.getMapper(EmpMapper.class);
        int a=empMapper.deleteEmp(id);
        sqlSession.close();
        return  a;
    }
}

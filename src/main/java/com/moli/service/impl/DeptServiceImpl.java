package com.moli.service.impl;

import com.moli.entity.Dept;
import com.moli.entity.Emp;
import com.moli.mapper.DeptMapper;
import com.moli.mapper.EmpMapper;
import com.moli.service.DeptService;
import com.moli.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class DeptServiceImpl implements DeptService {
    @Override
    public List<Dept> selectDept() {
        SqlSession sqlSession= MybatisUtil.getSqlsession();
        DeptMapper deptMapper=sqlSession.getMapper(DeptMapper.class);
        List<Dept> depts=deptMapper.selectDept();
        sqlSession.close();
        return depts;
    }
}

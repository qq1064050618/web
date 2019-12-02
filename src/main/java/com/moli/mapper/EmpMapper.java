package com.moli.mapper;

import com.moli.entity.Emp;

import java.util.List;

public interface EmpMapper {
    List<Emp> selectEmpDept();

    List<Emp> selectEmp();

    Emp selectById(int id);
    int updateEmpById(Emp emp);
    Emp selectByName(String name);

    int addEmp(Emp emp);

    int deleteEmp(int id);

}

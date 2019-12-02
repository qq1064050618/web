package com.moli.service;

import com.moli.entity.Emp;

import java.util.List;

public interface EmpService {
    List<Emp> selectEmpDept();

    List<Emp> empList();

    Emp selectById(int id);
    int updateEmpById(Emp emp);
    Emp selectByName(String name);

    int addEmp(Emp emp);

    int deleteEmp(int id);
}

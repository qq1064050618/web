package com.moli.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.sql.DriverManager;

public class MybatisUtil {
    private static final SqlSessionFactory s=new SqlSessionFactoryBuilder().build(
            MybatisUtil.class.getClassLoader().getResourceAsStream("mybatis.xml")
    );
    public static SqlSession getSqlsession(boolean b){
        return s.openSession(b);
    }
    public static SqlSession getSqlsession( ){
        return s.openSession(true);
    }
}

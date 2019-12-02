package com.moli.service.impl;

import com.moli.entity.User;
import com.moli.mapper.UserMapper;
import com.moli.service.UserService;
import com.moli.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

public class UserServiceImpl implements UserService {
    @Override
    public User selectUserByUsername(String username) {
        SqlSession sqlSession= MybatisUtil.getSqlsession();
       UserMapper userMapper= sqlSession.getMapper(UserMapper.class);
       User user=userMapper.selectUserByUsername(username);
       sqlSession.close();
       return user;
    }
}

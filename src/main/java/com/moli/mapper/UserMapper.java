package com.moli.mapper;

import com.moli.entity.User;

public interface UserMapper {
    User selectUserByUsername(String username);
}

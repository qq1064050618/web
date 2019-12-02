package com.moli.service;

import com.moli.entity.User;

public interface UserService {
    User selectUserByUsername(String username);
}

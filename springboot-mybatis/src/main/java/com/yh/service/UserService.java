package com.yh.service;

import com.yh.entity.User;

/**
 * Created by HR on 2018/5/13.
 */
public interface UserService {

    User findByUserName(String username);
}

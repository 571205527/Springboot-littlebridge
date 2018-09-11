package com.yh.service.impl;

import com.yh.entity.User;
import com.yh.mapper.UserMapper;
import com.yh.multiDataSource.DataSourceEnum;
import com.yh.multiDataSource.DataSourceTypeAnnotation;
import com.yh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by HR on 2018/5/13.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUserName(String username) {
        return userMapper.findByUserName(username);
    }

}

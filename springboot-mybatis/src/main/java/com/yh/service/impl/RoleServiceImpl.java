package com.yh.service.impl;

import com.yh.mapper.RoleMapper;
import com.yh.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Created by: LHZ
 * @Description:
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Integer getUserClassRole(Long tchId, Long classId) {
        return roleMapper.getUserClassRole(tchId,classId);
    }
}

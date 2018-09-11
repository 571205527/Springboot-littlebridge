package com.yh.mapper;

import com.yh.entity.RolePrivilege;
import org.springframework.stereotype.Repository;

@Repository
public interface RolePrivilegeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RolePrivilege record);

    int insertSelective(RolePrivilege record);

    RolePrivilege selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RolePrivilege record);

    int updateByPrimaryKey(RolePrivilege record);
}
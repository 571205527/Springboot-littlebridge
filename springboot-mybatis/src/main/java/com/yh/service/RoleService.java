package com.yh.service;

import org.apache.ibatis.annotations.Param;

/**
 * @Created by: LHZ
 * @Description:
 */
public interface RoleService {

    Integer getUserClassRole(@Param("tchId") Long tchId, @Param("classId") Long classId);

}

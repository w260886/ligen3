package com.web.service.dao;

import com.web.service.entity.UserRoleR;

public interface UserRoleRMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRoleR record);

    int insertSelective(UserRoleR record);

    UserRoleR selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRoleR record);

    int updateByPrimaryKey(UserRoleR record);
}
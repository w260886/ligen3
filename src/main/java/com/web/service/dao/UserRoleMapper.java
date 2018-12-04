package com.web.service.dao;

import com.web.service.entity.UserRole;

import java.util.List;
import java.util.Map;

public interface UserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
    /**
     * 获取用户角色信息
     * @param paramMap
     * @return List<UserRoleInfo>
     */
    List<UserRole> getUserRoleInfos(Map<String, Object> paramMap);

}
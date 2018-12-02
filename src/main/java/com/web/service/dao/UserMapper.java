package com.web.service.dao;

import com.web.service.entity.User;
import com.web.service.entity.UserRole;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 获取用户信息
     * @param paramMap
     * @return List<UserInfo>
     */
    List<User> getUserInfos(Map<String, Object> paramMap);

    /**
     * 获取用户角色信息
     * @param paramMap
     * @return List<UserRoleInfo>
     */
    List<UserRole> getUserRoleInfos(Map<String, Object> paramMap);
}
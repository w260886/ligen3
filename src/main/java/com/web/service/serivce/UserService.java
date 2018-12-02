package com.web.service.serivce;


import com.web.service.entity.User;
import com.web.service.entity.UserRole;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * 批量获取用户信息
     *
     * @param paramMap
     * @return List<UserInfo>
     */
    public List<User> getUserInfos(Map<String, Object> paramMap);

    /**
     * 获取用户角色信息
     *
     * @param paramMap
     * @return List<UserRoleInfo>
     */
    public List<UserRole> getUserRoleInfos(Map<String, Object> paramMap);

    /**
     * 新增用户信息
     *
     * @param userInfo
     */
    public boolean addUserInfo(User user);

    /**
     * 获取用户信息
     *
     * @param id
     * @return
     */
    public HashMap getUserInfo(long id);

    /**
     * 更新用户信息
     *
     * @param userInfo
     */
    public boolean updateUserInfo(User userInfo);

    /**
     * 删除用户信息
     *
     * @param id
     */
    public boolean deleteUserInfo(long id);

}

package com.web.service.serivce;


import com.web.service.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    public User getUserById(long userId);

    boolean addUser(User record);

    public List<Map> queryUserList();
}

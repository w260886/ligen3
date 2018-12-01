package com.web.service.serivce;

import com.web.service.dao.UserMapper;
import com.web.service.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    public User getUserById(long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    public boolean addUser(User record){
        boolean result = false;
        try {
            userMapper.insertSelective(record);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
    public List<Map> queryUserList(){
        return userMapper.quertUserList();
    }
}
package com.web.service.serivce;

import com.web.service.dao.UserMapper;
import com.web.service.entity.User;
import com.web.service.entity.UserRole;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;


    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public List<User> getUserInfos(Map<String, Object> paramMap) {
        paramMap.put("state", 1);
        return userInfoMapper.getUserInfos(paramMap);
    }

    @Override
    public List<UserRole> getUserRoleInfos(Map<String, Object> paramMap) {
        paramMap.put("state", 1);
        return userInfoMapper.getUserRoleInfos(paramMap);
    }

    @Override
    public boolean addUserInfo(User userInfo) {
        if(1 == baseServiceClient.insert(userInfo)){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public HashMap getUserInfo(long id) {
        return baseServiceClient.query(id, User.class);
    }

    @Override
    public boolean updateUserInfo(User userInfo) {
        if(1 == baseServiceClient.update(userInfo)){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteUserInfo(long id) {
        User user = new User();
        user.setId(Integer.valueOf(id+""));
        if(1 == baseServiceClient.delete(user)) {
            return true;
        } else {
            return false;
        }
    }

}
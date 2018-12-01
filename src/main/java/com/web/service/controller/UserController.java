package com.web.service.controller;

import com.web.service.entity.User;
import com.web.service.serivce.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserController extends BaseController{
    @Autowired
    private UserService userService;

    @RequestMapping("getuser")
    public User getUser() {
        User user = new User();
        user.setUserName("test");
        return user;
    }

    @RequestMapping("/showUser")
    @ResponseBody
    public User toIndex(HttpServletRequest request){
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = this.userService.getUserById(userId);
        return user;
    }

    @RequestMapping("/showUserAll")
    @ResponseBody
    public List<Map> showUserAll(HttpServletRequest request){
        List<Map> userList=userService.queryUserList();
        logger.info("ccccccccccccccccccccccccccccccccccccccc");
        return userList;
    }


}

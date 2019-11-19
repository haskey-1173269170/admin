package com.jk.user.service.impl;


import com.jk.user.mapper.UserMapper;
import com.jk.user.model.WebUser;
import com.jk.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UserServiceImpl
 * @Deacription TODO
 * @Author liushuxin
 * @Date 2019/11/15 13:41
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Map<String, Object> queryWebUser(int page, int rows, WebUser webUser) {
        Integer sum = userMapper.queryWebUserCount(webUser);
        Integer start = (page - 1) * rows;
        List<WebUser> webUserList = userMapper.queryWebUser(start, rows, webUser);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", sum);
        map.put("rows", webUserList);
        return map;
    }

    @Override
    public void deleteWebUserById(String id) {
        userMapper.deleteWebUserById(id);
    }

    @Override
    public Integer queryRoleIdByUserId(Integer userId) {
        return userMapper.queryRoleIdByUserId(userId);
    }

    @Override
    public void updateroleidbyuserid(Integer userId, Integer roleId) {
        userMapper.deleteWebUserRoleByUserId(userId);
        userMapper.addWebUserRole(userId, roleId);
    }

    @Override
    public WebUser queryWebUserByName(String username) {
        WebUser webUser = userMapper.queryWebUserByName(username);
        return webUser;
    }

    @Override
    public List<String> queryidentByUserId(Integer userid) {
        return userMapper.queryidentByUserId(userid);
    }
}

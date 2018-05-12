package com.bs.service.impl;

import com.bs.mapper.UserMapper;
import com.bs.pojo.PageBean;
import com.bs.pojo.User;
import com.bs.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author User
 */
@Service
public class UserServcieImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User login(User u) {
        return userMapper.selUser(u);
    }

    @Override
    public int addUser(User use) {
        return userMapper.add(use);
    }

    @Override
    public PageBean<User> findUsers(User us, PageBean<User> pi) {
        int totalCount = userMapper.findCount();
        pi.setTotalCount(totalCount); // 设置总行数
        int start = pi.getStartRow();//起始行
        int size = pi.getSize();//每页的行数
        List<User> list = userMapper.findUser(us, start, size);
        System.out.println(list);
        pi.setList(list);
        return pi;
    }

    @Override
    public User findUserByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public int updateUser(User use) {
        return userMapper.update(use);
    }

    @Override
    public int delUser(String username) {
        return userMapper.delUser(username);
    }

    @Override
    public List<Map<String, String>> getAllUserList(Map paramMap) {
        return userMapper.getAllUserList(paramMap);
    }


}

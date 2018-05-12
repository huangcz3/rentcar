package com.bs.test;

import com.bs.mapper.UserMapper;
import com.bs.pojo.User;

import javax.annotation.Resource;
import java.io.FileNotFoundException;

/**
 * @author User
 * @date 2018-04-17 11:14
 * @desc
 */
public class AService {

    @Resource
    private UserMapper userMapper;

    public void addUser(User user) throws Exception {
        userMapper.add(user);
        delByUsername(user.getUsername());
    }

    public void delByUsername(String name) throws Exception {
        throw new FileNotFoundException("fjkdl");
    }

}

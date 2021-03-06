package com.bs.service;

import com.bs.pojo.PageBean;
import com.bs.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * 登录 获取用户
     *
     * @param u
     * @return
     */
    public User login(User u);

    /**
     * 添加用户
     *
     * @param use
     * @return
     */
    public int addUser(User use);

    /**
     * 查找用户
     *
     * @param us
     * @param pageNumber
     * @param pageSize
     * @return
     */
    public PageBean<User> findUsers(User us, PageBean<User> pi);

    /**
     * 通过用户名查找
     *
     * @param username
     * @return
     */
    public User findUserByUsername(String username);

    /**
     * 修改用户信息
     *
     * @param use
     * @return
     */
    public int updateUser(User use);

    /**
     * 根据用户名 删除
     *
     * @param username
     * @return
     */
    public int delUser(String username);

    /**
     * 数据下载
     * @param paramMap
     * @return
     */
    List<Map<String,String>> getAllUserList(Map paramMap);
}

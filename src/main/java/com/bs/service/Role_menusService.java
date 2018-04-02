package com.bs.service;

import com.bs.pojo.Role;
import com.bs.pojo.Role_menus;

import java.util.List;

public interface Role_menusService {
    int addRole_menus(String rolename, List<Integer> list);

    /**
     * 获取列表
     *
     * @param roleid
     * @return
     */
    List<Role_menus> selById(int roleid);

    /**
     * 获取角色对象
     *
     * @param roleid
     * @return
     */
    Role selRole(int roleid);

    /**
     * 修改角色
     *
     * @param r
     * @param list
     * @return
     */
    int updateRole_menus(Role r, List<Integer> list);
}

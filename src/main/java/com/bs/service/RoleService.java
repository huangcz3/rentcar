package com.bs.service;


import com.bs.pojo.Role;

import java.util.List;


public interface RoleService {

    int addRole(String rolename);

    int updateRole(Role role);

    List<Role> showAll();

    Role findById(int roleid);

    /**
     * 通过id name 查找
     *
     * @param role
     * @return
     */
    List<Role> showRoles(Role role);

    /**
     * 删除
     *
     * @param roleid
     * @return
     */
    int delById(int roleid);


}

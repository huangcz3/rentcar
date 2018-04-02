package com.bs.service.impl;

import com.bs.mapper.RoleMapper;
import com.bs.mapper.Role_menusMapper;
import com.bs.pojo.Role;
import com.bs.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class RoleServcieImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private Role_menusMapper role_menusMapper;

    @Override
    public int addRole(String rolename) {
        return roleMapper.insRole(rolename);
    }

    @Override
    public int updateRole(Role role) {

        return roleMapper.updateRole(role);
    }

    @Override
    public List<Role> showAll() {
        return roleMapper.selAll();
    }

    @Override
    public Role findById(int roleid) {
        return roleMapper.selById(roleid);
    }

    @Override
    public List<Role> showRoles(Role role) {
        return roleMapper.selRole(role);
    }

    @Override
    public int delById(int roleid) {
        // TODO Auto-generated method stub
        int r2 = role_menusMapper.delByRol(roleid);
        int r1 = roleMapper.delRole(roleid);
        return r1 * r2;
    }


}

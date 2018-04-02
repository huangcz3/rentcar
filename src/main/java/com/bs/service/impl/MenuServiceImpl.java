package com.bs.service.impl;

import com.bs.mapper.MenuMapper;
import com.bs.mapper.RoleMapper;
import com.bs.pojo.Menu;
import com.bs.pojo.Role;
import com.bs.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuMapper menuMapper;
    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<Menu> showMenus(int roleid, int fatherid) {
        // TODO Auto-generated method stub
        List<Menu> list = menuMapper.selMenu(roleid, fatherid);
        for (Menu menu : list) {
            menu.setChildMenu(menuMapper.selMenu(roleid, menu.getMenuid()));
        }
        return list;
    }

    @Override
    public List<Role> showAllRole() {
        // TODO Auto-generated method stub
        return roleMapper.selAll();
    }

    @Override
    public List<Menu> showAllMenu() {
        // TODO Auto-generated method stub
        List<Menu> list = menuMapper.selAll(1);
        for (Menu menu : list) {
            menu.setChildMenu(menuMapper.selAll(menu.getMenuid()));
        }
        return list;
    }


}

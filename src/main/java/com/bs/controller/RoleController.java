package com.bs.controller;

import com.bs.pojo.Role;
import com.bs.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;


@Controller
public class RoleController {
    @Resource
    private RoleService roleService;


    @RequestMapping("selRoles")
    public String selRoles(Role role, Model mo) {
        List<Role> list = roleService.showRoles(role);
        mo.addAttribute("list", list);
        return "/systemManager/showRole";

    }


    @RequestMapping("delRole")
    @ResponseBody
    public int delRole(int roleid) {
        int result = roleService.delById(roleid);
        return result;
    }
}

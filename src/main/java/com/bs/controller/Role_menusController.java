package com.bs.controller;

import com.bs.pojo.Menu;
import com.bs.pojo.Role;
import com.bs.pojo.Role_menus;
import com.bs.service.MenuService;
import com.bs.service.Role_menusService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class Role_menusController {
    @Resource
    private Role_menusService role_meunsService;
    @Resource
    private MenuService menuService;


    @RequestMapping("preAddRole")
    public String preAddRole(Model mo) {

        List<Menu> list = menuService.showAllMenu();
        mo.addAttribute("list", list);
        return "/systemManager/addRole";

    }

    /**
     * 添加角色权限
     *
     * @param req
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("addRoleMenus")
    @ResponseBody
    public String addRoleMenus(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("utf-8");
        String[] menuid = req.getParameterValues("menuid");
        String rolename = req.getParameter("rolename");
        List<Integer> list = new ArrayList<>();
        for (String string : menuid) {
            int i = 0;
            try {
                i = Integer.parseInt(string);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            list.add(i);
        }
        System.out.println(rolename + list);
        int n = role_meunsService.addRole_menus(rolename, list);
        if (n > 0) {
            return "okok";
        } else {
            return "fail";
        }
    }

    @RequestMapping("preUpdateRole")
    public String preUpdateRole(int roleid, Model mo) {
        List<Menu> list = menuService.showAllMenu(); // 获取全部菜单
        List<Role_menus> rmlist = role_meunsService.selById(roleid);
        Role role = role_meunsService.selRole(roleid);
        mo.addAttribute("list", list);
        mo.addAttribute("rmlist", rmlist);
        mo.addAttribute("role", role);
        return "/systemManager/updateRole";
    }


    @RequestMapping("updateRoleMenus")
    @ResponseBody
    public String updateRoleMenus(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("utf-8");
        String[] menuid = req.getParameterValues("menuid");
        int roleid = Integer.parseInt(req.getParameter("roleid").trim());
        String rolename = req.getParameter("rolename");
        Role r = new Role();
        r.setRoleid(roleid);
        r.setRolename(rolename);
        List<Integer> list = new ArrayList<>();
        for (String string : menuid) {
            int i = 0;
            try {
                i = Integer.parseInt(string);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            list.add(i);
        }

        int n = role_meunsService.updateRole_menus(r, list);
        if (n > 0) {
            return "okok";
        } else {
            return "fail";
        }
    }
}

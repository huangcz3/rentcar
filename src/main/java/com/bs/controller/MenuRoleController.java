package com.bs.controller;

import com.bs.annotation.SystemLog;
import com.bs.pojo.Menu;
import com.bs.pojo.Role;
import com.bs.pojo.User;
import com.bs.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 菜单和角色管理
 *
 * @author Administrator
 */

@Controller
public class MenuRoleController {
    @Resource
    private MenuService menuService;

    /**
     * @param session
     * @return
     */
    @RequestMapping("menu")
    @SystemLog(description = "获取菜单")
    public String showMenu(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        List<Menu> menulist = menuService.showMenus(user.getRoleid(), 1);

        model.addAttribute("menulist", menulist);
        return "/WEB-INF/index";

    }

    @RequestMapping("showRole")
    @ResponseBody
    public List<Role> showRole() {

        return menuService.showAllRole();

    }


}

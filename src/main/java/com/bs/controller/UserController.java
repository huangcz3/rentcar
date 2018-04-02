package com.bs.controller;

import com.bs.annotation.SystemLog;
import com.bs.pojo.LoginLogs;
import com.bs.pojo.PageBean;
import com.bs.pojo.User;
import com.bs.service.LoginLogsService;
import com.bs.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;

/**
 * @author User
 */
@Controller
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;
    @Resource
    private LoginLogsService loginLogsService;

    /**
     * 根据用户名密码 登录    获取用户对象
     *
     * @param
     * @param req
     * @return
     */
    @RequestMapping("login")
    @SystemLog(description = "登录")
    public String login(User us, String randNum, HttpServletRequest req) {
        HttpSession session = req.getSession();
        // 获取验证码
        String randStr = (String) session.getAttribute("randStr");
        // 验证码
        if (randNum == null || "".equals(randNum) || (!randStr.equals(randNum))) {
            req.setAttribute("error", "验证码错误，请重新输入");
            return "/login";
        }

        User u = userService.login(us);

        // 将用户对象存入session
        session.setAttribute("user", u);
        logger.info("u----{}", u);
        if (u == null) {
            req.setAttribute("error", "登录名或密码错误");
            // 返回登录页
            return "/login";
        } else {
            LoginLogs log = new LoginLogs();
            // ip
            log.setLoginip(this.getIpAddr(req));
            log.setLoginname(u.getUsername());
            log.setLogintime(new Date(System.currentTimeMillis()).toString());

            loginLogsService.addLoginLogs(log);

            // 获取菜单
            return "redirect:menu";
        }

    }

    /**
     * 退出登录
     *
     * @param session
     * @return
     */
    @RequestMapping("logout")
    @SystemLog(description = "退出登录")
    public String logout(HttpSession session) {
        session.invalidate(); //清空session
        return "redirect:/login";

    }

    /**
     * 添加用户
     *
     * @param use
     * @return
     */
    @RequestMapping("addUser")
    @SystemLog(description = "用户管理-->添加用户")
    public String addUser(User use) {
        int result = userService.addUser(use);
        logger.info(String.valueOf(result) + ",添加用户{}成功", use);
        return "redirect:menu";

    }

    @RequestMapping("selUser")
    @SystemLog(description = "用户管理-->查询用户")
    public String selUser(User us, @RequestParam(defaultValue = "1") int pageNumber,
                          @RequestParam(defaultValue = "5") int pageSize, Model m) {
        System.out.println(us);
        PageBean<User> pi = new PageBean<>();
        pi.setIndex(pageNumber); //设置起始页
        pi.setSize(pageSize);// 设置每页行数
        userService.findUsers(us, pi);
        m.addAttribute("pagebean", pi);
        return "/user/selUser";

    }

    /**
     * 获取用户信息  修改用户
     *
     * @param username
     * @return
     */
    @RequestMapping("findUser")
    @ResponseBody
    @SystemLog(description = "用户管理-->获取用户信息准备修改")
    public User findUser(String username) {

        User user = userService.findUserByUsername(username);

        return user;

    }

    /**
     * 修改管理员
     *
     * @param use
     * @return
     */
    @RequestMapping("updateUser")
    @SystemLog(description = "用户管理-->修改用户信息")
    public String updateUser(User use) {
        int result = userService.updateUser(use);
        System.out.println(result);
        return "user/updateUser";

    }

    /**
     * 删除用户
     *
     * @param username
     * @return
     */
    @RequestMapping("delUser")
    @SystemLog(description = "用户管理-->删除用户")
    @ResponseBody
    public int delUser(String username) {

        int result = userService.delUser(username);

        return result;

    }

    /**
     * 获取ip
     *
     * @param request
     * @return
     */
    public String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
            if (ip.equals("0:0:0:0:0:0:0:1")) {
                return ip;
            }

        }
        return ip;
    }


}

package com.bs.controller;

import com.bs.annotation.SystemLog;
import com.bs.pojo.LoginLogs;
import com.bs.pojo.PageBean;
import com.bs.service.LoginLogsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author User
 */
@Controller
public class LoginLogsController {

    @Resource
    private LoginLogsService loginLogsService;


    @RequestMapping("loginLogs")
    @SystemLog(description = "查询登录信息")
    public String loginLogs(LoginLogs loginLogs, @RequestParam(defaultValue = "1") int pageNumber,
                            @RequestParam(defaultValue = "5") int pageSize, Model m) {
        System.out.println("LoginLogsController.loginLogs()");
        System.out.println(loginLogs);
        PageBean<LoginLogs> pi = new PageBean<>();
        pi.setIndex(pageNumber);//设置起始页
        pi.setIndex(pageSize);//设置每页行数
        loginLogsService.findLoginLogs(loginLogs, pi);
        m.addAttribute("pageLoginLogs", pi);

        return "/systemManager/findLoginInfo";


    }


    /**
     * 删除
     * @param loginlogid
     * @return
     */
    @RequestMapping("delLogin")
    @ResponseBody
    @SystemLog(description = "删除登录信息")
    public int delLogin(int loginlogid) {
        int result = loginLogsService.delloginlog(loginlogid);

        return result;


    }


}

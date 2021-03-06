package com.bs.controller;

import com.bs.annotation.SystemLog;
import com.bs.pojo.*;
import com.bs.service.CarService;
import com.bs.service.CheckService;
import com.bs.service.CustomerService;
import com.bs.service.RentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class CheckController {

    @Resource
    private CarService carService;
    @Resource
    private CustomerService customerService;
    @Resource
    private RentService rentService;
    @Resource
    private CheckService checkService;

    @RequestMapping("findRentById")
    @SystemLog(description = "查找出租单信息")
    @ResponseBody
    public boolean findRentById(String rentid) {
        Renttable rent = rentService.findById(rentid);
        if (rent == null) {
            return false;

        } else {
            return true;
        }

    }


    @RequestMapping("preCheck")
    @SystemLog(description = "汽车管理-->预处理检查单")
    public String preRentCar(String rentid, Model mo, HttpSession session) {
        Checktable ck = new Checktable();
        ck.setRentid(rentid);
        ck.setCheckid(Long.toString(System.currentTimeMillis()));  //检查单号
        User user = (User) session.getAttribute("user");
        ck.setUsername(user.getUsername());
        Renttable renttable = rentService.findById(rentid); //出租单信息
        Car car = carService.findCarByident(renttable.getCarid());  // 汽车信息
        Customer cust = customerService.findCustByident(renttable.getCustid());// 顾客信息
        mo.addAttribute("renttable", renttable);
        mo.addAttribute("carinfo", car);
        mo.addAttribute("cust", cust);
        mo.addAttribute("ck", ck);
        return "operatorManager/addCheck";

    }


    @RequestMapping("addCheckInfo")
    @ResponseBody
    public String addCheckInfo(Checktable checktable) {
        int result = checkService.addCheck(checktable);
        if (result > 0) {
            return "ok";
        } else {

            return "fail";
        }

    }

    /**
     * 查询检查单
     *
     * @param checktable
     * @param pageNumber
     * @param pageSize
     * @param m
     * @return
     */
    @RequestMapping("selCheck")
    public String selCheck(Checktable checktable, @RequestParam(defaultValue = "1") int pageNumber,
                           @RequestParam(defaultValue = "5") int pageSize, Model m) {
        PageBean<Checktable> pi = new PageBean<>();
        pi.setIndex(pageNumber); // 设置起始页
        pi.setSize(pageSize);// 设置每页行数
        checkService.findCheck(checktable, pi);
        m.addAttribute("pageCheck", pi);
        return "/operatorManager/checkManager";
    }

}

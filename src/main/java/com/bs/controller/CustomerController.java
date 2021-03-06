package com.bs.controller;

import com.bs.annotation.SystemLog;
import com.bs.pojo.Customer;
import com.bs.pojo.PageBean;
import com.bs.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class CustomerController {

    private Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Resource
    private CustomerService customerService;

    /**
     * 添加顾客
     *
     * @param customer
     * @return
     */
    @RequestMapping("addCust")
    @SystemLog(description = "客户管理-->添加顾客")
//    @ResponseBody
    public String addcustomer(Customer customer) {
        int result = customerService.addCustomer(customer);
        logger.info(String.valueOf(result) + ",添加用户{}成功", customer);
//        return "result";
        return "redirect:menu";
    }

    /**
     * 查询客户
     *
     * @param customer
     * @param pageNumber
     * @param pageSize
     * @param m
     * @return
     */
    @RequestMapping("selCust")
    public String selCust(Customer customer, @RequestParam(defaultValue = "1") int pageNumber,
                          @RequestParam(defaultValue = "5") int pageSize, Model m) {
//        System.out.println(customer);
        PageBean<Customer> pi = new PageBean<>();
        pi.setIndex(pageNumber); // 设置起始页
        pi.setSize(pageSize);// 设置每页行数
        customerService.findCustomer(customer, pi);
        m.addAttribute("pageCust", pi);
        return "/custManager/findCustomers";
    }

    /**
     * 获取客户信息  修改客户
     *
     * @param identity
     * @return
     */
    @RequestMapping("findCust")
    @ResponseBody
    public Customer findCust(String identity) {

        Customer customer = customerService.findCustByident(identity);
        return customer;
    }

    /**
     * 修改客户信息
     *
     * @param
     * @return
     */
    @RequestMapping("updateCust")
    public String updateCust(Customer cust) {
        int result = customerService.updateCust(cust);
        System.out.println(result);
        return "/custManager/updateCust";

    }

    /**
     * 删除客户
     *
     * @param identity
     * @return
     */
    @RequestMapping("delCust")
    @ResponseBody
    public int delCust(String identity) {

        int result = customerService.delCust(identity);

        return result;

    }

}

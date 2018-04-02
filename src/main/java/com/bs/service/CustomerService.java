package com.bs.service;

import com.bs.pojo.Customer;
import com.bs.pojo.PageBean;

public interface CustomerService {


    /**
     * 添加客户
     *
     * @param
     * @return
     */
    public int addCustomer(Customer cutstomer);

    /**
     * 查找客户
     *
     * @param cutstomer
     * @param pageNumber
     * @param pageSize
     * @return
     */
    public PageBean<Customer> findCustomer(Customer customer, PageBean<Customer> pi);

    /**
     * 通过身份证查询
     *
     * @param identity
     * @return
     */
    public Customer findCustByident(String identity);

    /**
     * 修改客户
     *
     * @param cust
     * @return
     */
    public int updateCust(Customer cust);

    /**
     * 根据sfz 删除客户
     *
     * @param identity
     * @return
     */
    public int delCust(String identity);

}

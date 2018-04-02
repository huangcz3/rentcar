package com.bs.service;

import com.bs.pojo.PageBean;
import com.bs.pojo.Renttable;

import java.util.List;

public interface RentService {
    /**
     * 添加租车
     *
     * @param renttable
     * @return
     */
    public int addRenttable(Renttable renttable);

    /**
     * 查找出租单
     *
     * @param rentid
     * @return
     */
    public Renttable findById(String rentid);

    /**
     * 多条件查询
     *
     * @param renttable
     * @param pi
     */
    public void findRenttable(Renttable renttable, PageBean<Renttable> pi);

    /**
     * 修改租车单
     *
     * @param rent
     * @return
     */
    public int updateRent(Renttable rent);

    /**
     * 当月应还
     *
     * @return
     */
    public List<Renttable> findNowM();

}

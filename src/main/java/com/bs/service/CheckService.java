package com.bs.service;

import com.bs.pojo.Checktable;
import com.bs.pojo.PageBean;

public interface CheckService {

    int addCheck(Checktable checktable);

    /**
     * 查询检查单
     *
     * @param checktable
     * @param pi
     */
    void findCheck(Checktable checktable, PageBean<Checktable> pi);

}

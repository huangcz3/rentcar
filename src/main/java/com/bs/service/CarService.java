package com.bs.service;

import com.bs.pojo.Car;
import com.bs.pojo.PageBean;

public interface CarService {

    /**
     * 新增车辆
     * @param car
     * @return
     */
    int addCar(Car car);

    /**
     * 查找车辆信息
     * @param car
     * @param pi
     * @return
     */
    PageBean<Car> findCar(Car car, PageBean<Car> pi);

    /**
     * 通过车牌查询车辆信息
     *
     * @param identity
     * @return
     */
    Car findCarByident(String identity);

    /**
     * 修改车辆信息
     *
     * @param cust
     * @return
     */
    int updateCar(Car cust);

    /**
     * 根据 删除车辆信息
     *
     * @param identity
     * @return
     */
    int delCar(String identity);

}

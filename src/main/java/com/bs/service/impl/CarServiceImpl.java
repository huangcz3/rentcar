package com.bs.service.impl;

import com.bs.mapper.CarMapper;
import com.bs.pojo.Car;
import com.bs.pojo.PageBean;
import com.bs.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;

    @Override
    public int addCar(Car car) {
        // TODO Auto-generated method stub
        return carMapper.add(car);
    }

    @Override
    public PageBean<Car> findCar(Car car, PageBean<Car> pi) {
        // TODO Auto-generated method stub
        int totalCount = carMapper.findCount();
        pi.setTotalCount(totalCount); // 设置总行数
        int start = pi.getStartRow();//起始行
        int size = pi.getSize();//每页的行数
        List<Car> list = carMapper.findCar(car, start, size);
        System.out.println(list);
        pi.setList(list);
        return pi;
    }

    @Override
    public Car findCarByident(String carnumber) {
        return carMapper.findByNum(carnumber);
    }

    @Override
    public int updateCar(Car cust) {
        // TODO Auto-generated method stub
        return carMapper.updateCar(cust);
    }

    @Override
    public int delCar(String identity) {
        // TODO Auto-generated method stub
        return carMapper.delByIdent(identity);
    }

}

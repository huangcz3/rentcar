package com.bs.service.impl;

import com.bs.mapper.CarMapper;
import com.bs.mapper.RenttableMapper;
import com.bs.pojo.PageBean;
import com.bs.pojo.Renttable;
import com.bs.service.RentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RentServiceImpl implements RentService {
    @Resource
    private RenttableMapper renttableMapper;
    @Resource
    private CarMapper carMapper;

    @Override
    public int addRenttable(Renttable renttable) {
        // TODO Auto-generated method stub
        int r2 = renttableMapper.add(renttable);
        int r1 = carMapper.updateCarRent(renttable.getCarid());  // 更改车状态
        return r1 * r2;
    }

    @Override
    public Renttable findById(String rentid) {
        // TODO Auto-generated method stub
        Renttable rent = renttableMapper.findByNum(rentid);
        if (rent.getRentflage() != 0) { //如果已经归还   那么 返回空
            return null;
        } else {
            return rent;
        }
    }

    @Override
    public void findRenttable(Renttable renttable, PageBean<Renttable> pi) {
        int totalCount = renttableMapper.findCount();
        pi.setTotalCount(totalCount); // 设置总行数
        int start = pi.getStartRow();//起始行
        int size = pi.getSize();//每页的行数
        List<Renttable> list = renttableMapper.findRenttable(renttable);
        System.out.println(list);
        pi.setList(list);

    }

    @Override
    public int updateRent(Renttable rent) {
        // TODO Auto-generated method stub
        int rentflage = rent.getRentflage();
        if (rentflage == 1) {
            int r2 = carMapper.updateReturn(rent.getCarid()); // 更改车状态
        }
        int res = renttableMapper.updateRenttable(rent);
        return res;
    }

    @Override
    public List<Renttable> findNowM() {
        // TODO Auto-generated method stub
        return renttableMapper.selNow();
    }

}

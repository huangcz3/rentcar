package com.bs.service.impl;

import com.bs.mapper.LoginLogsMapper;
import com.bs.pojo.LoginLogs;
import com.bs.pojo.PageBean;
import com.bs.service.LoginLogsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LoginLogsServiceImpl implements LoginLogsService {

    @Resource
    private LoginLogsMapper loginLogsMapper;


    @Override
    public int addLoginLogs(LoginLogs loginLogs) {
        // TODO Auto-generated method stub
        return loginLogsMapper.add(loginLogs);
    }

    @Override
    public PageBean<LoginLogs> findLoginLogs(LoginLogs loginLogs, PageBean<LoginLogs> pi) {

        // TODO Auto-generated method stub
        int totalCount = loginLogsMapper.findCount();
        pi.setTotalCount(totalCount);//设置总行数
        int start = pi.getStartRow();
        int size = pi.getSize();

        List<LoginLogs> list = loginLogsMapper.findLoginLogs(loginLogs, start, size);
        System.out.println(list);
        pi.setList(list);


        return null;
    }

    @Override
    public int delloginlog(int loginlogid) {
        // TODO Auto-generated method stub
        return loginLogsMapper.delByloginlogid(loginlogid);
    }

}

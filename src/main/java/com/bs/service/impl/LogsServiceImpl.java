package com.bs.service.impl;

import com.bs.mapper.LogsMapper;
import com.bs.pojo.Logs;
import com.bs.pojo.PageBean;
import com.bs.service.LogsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LogsServiceImpl implements LogsService {

    @Resource
    private LogsMapper logsMapper;


    @Override
    public int addLogs(Logs logs) {
        return logsMapper.add(logs);
    }

    @Override
    public PageBean<Logs> findLogs(Logs logs, PageBean<Logs> pi) {
        int totalCount = logsMapper.findCount();
        pi.setTotalCount(totalCount);//设置总行数
        int start = pi.getStartRow();
        int size = pi.getSize();
        List<Logs> list = logsMapper.findLogs(logs, start, size);
        System.out.println(list);

        pi.setList(list);

        return null;
    }

    @Override
    public Logs findId(int id) {
        // TODO Auto-generated method stub
        return logsMapper.findByNum(id);
    }

    @Override
    public int updateLogs(Logs l) {
        // TODO Auto-generated method stub
        return logsMapper.updateLogs(l);
    }

    @Override
    public int delLogs(int id) {
        // TODO Auto-generated method stub
        return logsMapper.delById(id);
    }

}

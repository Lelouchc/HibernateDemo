package com.demo.service.impl;

import com.demo.dao.intf.LogDao;
import com.demo.entity.Log;
import com.demo.service.intf.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yy on 2016/3/14.
 */
@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;

    @Transactional(value = "txManager")
    public List<Log> getLogs(){
        return logDao.getLogs();
    }
}

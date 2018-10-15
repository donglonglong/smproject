package com.imooc.smpro.service.impl;

import com.imooc.smpro.bean.Log;
import com.imooc.smpro.dao.LogDao;
import com.imooc.smpro.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service("logService")
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;

    @Override
    public void addSystemLog(Log log) {
        log.setOprTime(new Date());
        log.setType("system");
        logDao.insert(log);
    }

    @Override
    public void addLoginLog(Log log) {
        log.setOprTime(new Date());
        log.setType("login");
        logDao.insert(log);

    }

    @Override
    public void addOperationLog(Log log) {
        log.setOprTime(new Date());
        log.setType("operation");
        logDao.insert(log);

    }

    @Override
    public List<Log> selectBySystem() {

        return logDao.selectByType("system");
    }

    @Override
    public List<Log> selectByLogin() {
        return logDao.selectByType("login");
    }

    @Override
    public List<Log> selectByOperation() {
        return logDao.selectByType("operation");
    }
}

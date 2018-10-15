package com.imooc.smpro.service;

import com.imooc.smpro.bean.Log;

import java.util.List;

public interface LogService {
    void addSystemLog(Log log);
    void addLoginLog(Log log);
    void addOperationLog(Log log);

    List<Log> selectBySystem();
    List<Log> selectByLogin();
    List<Log> selectByOperation();
}

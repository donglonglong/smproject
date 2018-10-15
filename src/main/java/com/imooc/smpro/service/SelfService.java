package com.imooc.smpro.service;


import com.imooc.smpro.bean.Staff;

public interface SelfService {
    Staff login(String username,String password);
    void changePassword(Integer id,String password);
}

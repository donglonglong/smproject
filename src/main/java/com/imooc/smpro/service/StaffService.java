package com.imooc.smpro.service;

import com.imooc.smpro.bean.Staff;

import java.util.List;

public interface StaffService {
    void add(Staff staff);
    void edit(Staff staff);
    void remove(int id);
    Staff get(int id);
    List<Staff> getAll();
}

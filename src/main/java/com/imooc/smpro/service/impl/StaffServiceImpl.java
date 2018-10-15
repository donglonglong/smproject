package com.imooc.smpro.service.impl;

import com.imooc.smpro.bean.Staff;
import com.imooc.smpro.dao.StaffDao;
import com.imooc.smpro.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service("staffService")
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffDao staffDao;
    @Override
    public void add(Staff staff) {
        staff.setPassword("000000");
        staff.setState("正常");
        staff.setWorkTime(new Date());
        staff.setLeaveTime(new Date());
        staffDao.insert(staff);
    }

    @Override
    public void edit(Staff staff) {
        staffDao.update(staff);
    }

    @Override
    public void remove(int id) {
        staffDao.delete(id);
    }

    @Override
    public Staff get(int id) {
        return staffDao.selectById(id);
    }

    @Override
    public List<Staff> getAll() {

        return staffDao.selectAll();
    }
}

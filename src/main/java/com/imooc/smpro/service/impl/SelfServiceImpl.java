package com.imooc.smpro.service.impl;

import com.imooc.smpro.bean.Staff;
import com.imooc.smpro.dao.StaffDao;
import com.imooc.smpro.dao.SelfDao;
import com.imooc.smpro.service.SelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("selfService")
public class SelfServiceImpl implements SelfService {
    @Autowired
    private SelfDao stlfDao;
    @Autowired
    private StaffDao staffDao;

    @Override
    public Staff login(String username, String password) {
       Staff staff = stlfDao.selectByusername(username);
       if(staff==null)return null;
       if(staff!=null)return staff;
        return null;
    }

    @Override
    public void changePassword(Integer id, String password) {
        Staff staff = new Staff();
        staff.setPassword(password);
        staffDao.update(staff);
    }
}

package com.imooc.smpro.dao;

import com.imooc.smpro.bean.Staff;
import org.springframework.stereotype.Repository;

@Repository("selfDao")
public interface SelfDao {
    Staff selectByusername(String username);
}

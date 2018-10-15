package com.imooc.smpro.service;

import com.imooc.smpro.bean.Department;

import java.util.List;

public interface DepartmentService {
    void add(Department department);
    void remove(Integer id);
    void edit(Department department);
    Department get(Integer id);
    List<Department> getAll();
}

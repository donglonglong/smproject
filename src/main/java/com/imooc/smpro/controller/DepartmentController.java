package com.imooc.smpro.controller;

import com.imooc.smpro.bean.Department;
import com.imooc.smpro.service.DepartmentService;
import com.sun.deploy.net.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller("departmentController")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    //  /department/list.do     /department_list.jsp
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> list = departmentService.getAll();
        request.setAttribute("LIST",list);
        request.getRequestDispatcher("../department_list.jsp").forward(request,response);
    }

    public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("../department_add.jsp").forward(request,response);
    }

    public void add(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        Department department = new Department();
        department.setName(name);
        department.setAddress(address);

        departmentService.add(department);
        response.sendRedirect("list.do");
    }

    public void toedit(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        Integer id =Integer.parseInt( request.getParameter("id"));
        Department department = departmentService.get(id);
        request.setAttribute("ojbk",department );
        request.getRequestDispatcher("../department_edit.jsp").forward(request,response );
    }

    public void edit(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        Integer id = Integer.parseInt(request.getParameter("id"));
        Department department = new Department();
        department.setName(name);
        department.setAddress(address);
        department.setId(id);
        departmentService.edit(department);
        response.sendRedirect("list.do");
    }

    public void remove(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Integer id =Integer.parseInt(request.getParameter("id"));
        departmentService.remove(id);
        response.sendRedirect("list.do");
    }


}

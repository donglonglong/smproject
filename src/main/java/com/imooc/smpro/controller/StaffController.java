package com.imooc.smpro.controller;

import com.imooc.smpro.bean.Department;
import com.imooc.smpro.bean.Staff;
import com.imooc.smpro.dao.DepartmentDao;
import com.imooc.smpro.service.DepartmentService;
import com.imooc.smpro.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller("staffController")
public class StaffController {
    @Autowired
    private StaffService staffService;
    @Autowired
    private DepartmentService departmentService;

    public void list(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        List<Staff>  staffList = staffService.getAll();
        request.setAttribute("STAFFLIST",staffList );
        request.getRequestDispatcher("../staff_list.jsp").forward(request,response );

    }

    public void toadd(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        List<Department> departmentList = departmentService.getAll();
        request.setAttribute("DEPARTMENTLIST",departmentList );
        request.getRequestDispatcher("../staff_add.jsp").forward(request,response );
    }

    public void add(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String account = request.getParameter("account");
        Integer departmentno = Integer.parseInt(request.getParameter("departmentNo"));
        String username = request.getParameter("username");
        String sex = request.getParameter("sex");
        String idcard =request.getParameter("idcard");
        Date borntime =null;
        try {
            borntime =new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("borntime") ) ;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String remark = request.getParameter("remark");
        Staff staff = new Staff();
        staff.setUsername(account);
        staff.setDepartmentNo(departmentno);
        staff.setEmployeeName(username);
        staff.setSex(sex);
        staff.setIdCard(idcard);
        staff.setBornTime(borntime);
        staff.setRemark(remark);
        staffService.add(staff);
        response.sendRedirect("list.do");
    }

    public void update(HttpServletRequest request,HttpServletResponse response) throws IOException {
        HttpSession session =request.getSession();
        Staff staff = (Staff) session.getAttribute("USER");
        Integer id =  staff.getId();
        String account = request.getParameter("account");
        String username = request.getParameter("empName");
        String sex = request.getParameter("sex");
        String idcard =request.getParameter("idcard");

        Date borntime =null;
        try {
            borntime =new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("borntime") ) ;
        } catch (ParseException e) {
            e.printStackTrace();
        }
       int departmentno = Integer.parseInt(request.getParameter("departmentNo"));
         staff.setUsername(account);
        staff.setDepartmentNo(departmentno);
        staff.setEmployeeName(username);
        staff.setSex(sex);
        staff.setIdCard(idcard);
        staff.setBornTime(borntime);
        staff.setState("正常");
        staffService.edit(staff);
        response.sendRedirect("list.do");
    }

    public void toupdate(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        Integer id =Integer.parseInt( request.getParameter("id"));
        Staff staff = staffService.get(id);
        request.setAttribute("STAFF",staff );
        List<Department> departmentList  = departmentService.getAll();
        request.setAttribute("DEPARTMENTLIST", departmentList);
        request.getRequestDispatcher("../staff_edit.jsp").forward(request,response );
    }


    public void remove(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        staffService.remove(id);
        response.sendRedirect("list.do");

    }


}

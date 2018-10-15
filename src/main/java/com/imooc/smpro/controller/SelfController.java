package com.imooc.smpro.controller;

import com.imooc.smpro.bean.Staff;
import com.imooc.smpro.service.SelfService;
import com.imooc.smpro.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller("selfController")
public class SelfController {
    @Autowired
    private SelfService selfService;
    @Autowired
    private StaffService staffService;


    public void tologin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.getRequestDispatcher("login.jsp").forward(request,response);
    }

    public void login(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Staff staff = selfService.login(username, password);
        if(staff==null){
            response.sendRedirect("tologin.do");
        }else {
            HttpSession session = request.getSession();
            session.setAttribute("USER",staff );
            response.sendRedirect("main.do");
        }
    }

    public void main(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request,response );
    }

    public void loginout(HttpServletRequest request,HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.setAttribute("USER",null );
        response.sendRedirect("tologin.do");
    }

    public void info(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("info.jsp").forward(request,response);
    }

    public void tochangepassword(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
       request.getRequestDispatcher("changepassword.jsp").forward(request,response );
    }

    public void edit(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        Staff staff = (Staff) session.getAttribute("USER");
        if(!staff.getPassword().equals(password)){
            response.sendRedirect("tochangepassword.do");
        }else {
            String password1 = request.getParameter("password1");
            String password2= request.getParameter("password2");
            if(password1.equals(password2)){
                staff.setPassword(password1);
                staffService.edit(staff);
              response.sendRedirect("loginout.do");
            }else {
                response.sendRedirect("tochangepassword.do");
            }
        }




    }

}

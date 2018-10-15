package com.imooc.smpro.controller;

import com.imooc.smpro.bean.Log;
import com.imooc.smpro.bean.Staff;
import com.imooc.smpro.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller("logController")
public class LogController {

    @Autowired
    private LogService logService;

    public void operationLog(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        List<Log> list = logService.selectByOperation();
        request.setAttribute("LIST",list );
        request.setAttribute("TYPE","操作" );
        request.getRequestDispatcher("../log_list.jsp").forward(request,response );
    }
    public void loginLog(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        List<Log> list = logService.selectByLogin();
        request.setAttribute("LIST",list );
        request.setAttribute("TYPE","登录" );
        request.getRequestDispatcher("../log_list.jsp").forward(request,response );
    }

    public void systemLog(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        List<Log> list = logService.selectBySystem();
        request.setAttribute("LIST",list );
        request.setAttribute("TYPE","系统" );
        request.getRequestDispatcher("../log_list.jsp").forward(request,response );
    }
}

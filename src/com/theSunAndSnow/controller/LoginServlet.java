package com.theSunAndSnow.controller;


import com.theSunAndSnow.entity.Reader;
import com.theSunAndSnow.service.LoginService;
import com.theSunAndSnow.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

//    特意定义一个类来使 controller 与 service 进行数据交互
//    这样，controller 部分就已经与 service 连接起来了
    private LoginService loginService = new LoginServiceImpl();

    /**
     * 处理登陆的逻辑
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username"),
                password = req.getParameter("password");

        Reader reader = loginService.login(username, password);
    }
}

package com.theSunAndSnow.controller;


import com.theSunAndSnow.entity.Admin;
import com.theSunAndSnow.entity.Book;
import com.theSunAndSnow.entity.Reader;
import com.theSunAndSnow.service.BookService;
import com.theSunAndSnow.service.LoginService;
import com.theSunAndSnow.service.impl.BookServiceImpl;
import com.theSunAndSnow.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

//    坚持 MVC，即使可以直接与 Repository 交互也不这样做
//    特意定义一个类来使 controller 与 service 进行数据交互
//    这样，controller 部分就已经与 service 连接起来了
    private LoginService loginService = new LoginServiceImpl();
    private BookService bookService = new BookServiceImpl();

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
        String type = req.getParameter("type");

        Object object = loginService.login(username, password, type);

        if (object == null) {
            resp.sendRedirect("login.jsp");
        } else {
            HttpSession session = req.getSession();
            switch (type) {
                case "reader":
                    Reader reader = (Reader) object;
                    session.setAttribute("reader", reader);

                    // 跳转到读者首页
                    List<Book> list = bookService.findAll(1);
                    req.setAttribute("list", list); // 给用户展示的集合
                    req.setAttribute("dataPrePage", 3); // 表示每页多少条数据
                    req.setAttribute("currentPage", 1); // 提示用户当前在第几页
                    req.setAttribute("pages", bookService.getPages()); // 提示用户一共有多少页
                    req.getRequestDispatcher("index.jsp").forward(req, resp);
                    break;

                case "admin":
                    Admin admin = (Admin) object;
                    session.setAttribute("admin", admin);
//                    跳转到管理员首页
                    break;
            }
        }
    }
}

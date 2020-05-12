package com.theSunAndSnow.controller;


import com.theSunAndSnow.entity.Book;
import com.theSunAndSnow.entity.Reader;
import com.theSunAndSnow.service.BookService;
import com.theSunAndSnow.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/book")
public class BookServlet extends HttpServlet {

    // BookServlet 与 BookService 连接起来
    private BookService bookService = new BookServiceImpl();
    private final int LENGTH = 3;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");


        if (method == null) { // 一般都需要进行非空认证
            method = "findAll";
        }

//        流程控制
        switch(method) {
            case "findAll" :
                String pageStr = req.getParameter("page");
                int page = Integer.parseInt(pageStr);
                List<Book> list = bookService.findAll(page);
                req.setAttribute("list", list);
                req.setAttribute("dataPrePage", 3);
                req.setAttribute("currentPage", page); // 提示用户当前在第几页
                req.setAttribute("pages", bookService.getPages()); // 提示用户一共有多少页
                req.getRequestDispatcher("index.jsp").forward(req, resp);
                break;

            case "addBorrow" :
//                reader 发出借阅请求不需要管理员的参与，所以不用考虑 adminid
//                state默认值为 0，表示未审核，也不用传
                Integer bookid = Integer.parseInt(req.getParameter("bookid"));
                Reader reader = (Reader) req.getSession().getAttribute("reader"); // session中获得的 键值对的值 为 Object 类型
                Integer readid = reader.getId();

//                添加借书请求
                bookService.addBorrow(bookid, readid);

//                展示当前用户的所有借书记录

                break;
        }


    }
}

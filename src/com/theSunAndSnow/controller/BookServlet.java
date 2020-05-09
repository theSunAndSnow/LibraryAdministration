package com.theSunAndSnow.controller;


import com.theSunAndSnow.entity.Book;
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
        String pageStr = req.getParameter("page");
        int page = Integer.parseInt(pageStr);

        List<Book> list = bookService.findAll(page);
        req.setAttribute("list", list);
        req.setAttribute("dataPrePage", 3);
        req.setAttribute("currentPage", page); // 提示用户当前在第几页
        req.setAttribute("pages", bookService.getPages()); // 提示用户一共有多少页
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}

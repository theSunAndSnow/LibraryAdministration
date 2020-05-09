package com.theSunAndSnow.service;

import com.theSunAndSnow.entity.Book;

import java.util.List;

/**
 * 专门用来处理各种图书借阅业务
 */
public interface BookService {
    /**
     * 将所有的图书查询出来
     * @return book 数据库中所有的图书集合
     */
    public List<Book> findAll();
}
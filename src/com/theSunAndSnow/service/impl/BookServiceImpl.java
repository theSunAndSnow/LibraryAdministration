package com.theSunAndSnow.service.impl;

import com.theSunAndSnow.entity.Book;
import com.theSunAndSnow.repository.BookRepository;
import com.theSunAndSnow.repository.impl.BookRepositoryImpl;
import com.theSunAndSnow.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookRepository bookRepository = new BookRepositoryImpl();
    private final int LENGTH = 3;

    @Override
    public List<Book> findAll(int page) {
        return bookRepository.findAll((page - 1) * LENGTH, LENGTH);
    }

    @Override
    public int getCount() {
        return bookRepository.getCount();
    }

    @Override
    public int getPages() {
        int count = bookRepository.getCount();
        int pages = 0;
        return pages = ((count - 1) / LENGTH) + 1; // 向上取整除法
    }
}

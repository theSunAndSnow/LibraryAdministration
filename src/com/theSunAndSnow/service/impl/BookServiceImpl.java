package com.theSunAndSnow.service.impl;

import com.theSunAndSnow.entity.Book;
import com.theSunAndSnow.repository.BookRepository;
import com.theSunAndSnow.repository.impl.BookRepositoryImpl;
import com.theSunAndSnow.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookRepository bookRepository = new BookRepositoryImpl();

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}

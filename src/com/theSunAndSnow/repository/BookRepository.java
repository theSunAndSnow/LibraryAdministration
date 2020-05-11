package com.theSunAndSnow.repository;

import com.theSunAndSnow.entity.Book;

import java.util.List;

public interface BookRepository {
    public List<Book> findAll(int index, int length);

    public int getCount();

}

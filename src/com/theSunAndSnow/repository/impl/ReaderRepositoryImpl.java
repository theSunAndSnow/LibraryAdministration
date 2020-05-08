package com.theSunAndSnow.repository.impl;

import com.theSunAndSnow.entity.Reader;
import com.theSunAndSnow.repository.ReaderRepository;

public class ReaderRepositoryImpl implements ReaderRepository {

//    建立 service 与 repository 之间的连接
    private ReaderRepository readerRepository = new ReaderRepositoryImpl();

    @Override
    public Reader login(String username, String password) {
        return readerRepository.login(username, password);
    }
}

package com.theSunAndSnow.service.impl;

import com.theSunAndSnow.entity.Reader;
import com.theSunAndSnow.repository.ReaderRepository;
import com.theSunAndSnow.repository.impl.ReaderRepositoryImpl;
import com.theSunAndSnow.service.LoginService;

public class LoginServiceImpl implements LoginService {

    //    建立 service 与 repository 之间的连接
    private ReaderRepository readerRepository = new ReaderRepositoryImpl();

    @Override
    public Reader login(String username, String password) {
        return readerRepository.login(username, password);
    }
}

package com.theSunAndSnow.service.impl;

import com.theSunAndSnow.entity.Admin;
import com.theSunAndSnow.entity.Reader;
import com.theSunAndSnow.repository.AdminRepository;
import com.theSunAndSnow.repository.ReaderRepository;
import com.theSunAndSnow.repository.impl.AdminRepositoryImpl;
import com.theSunAndSnow.repository.impl.ReaderRepositoryImpl;
import com.theSunAndSnow.service.LoginService;

public class LoginServiceImpl implements LoginService {

    //    建立 service 与 repository 之间的连接
    private ReaderRepository readerRepository = new ReaderRepositoryImpl();
    private AdminRepository adminRepository = new AdminRepositoryImpl();

    @Override
    public Object login(String username, String password, String type) {
        Object object = null;
        switch (type) {
            case "reader":
                object = readerRepository.login(username, password);
                break;

            case "admin":
                object = adminRepository.login(username, password);
                break;
        }
        return object;
    }
}

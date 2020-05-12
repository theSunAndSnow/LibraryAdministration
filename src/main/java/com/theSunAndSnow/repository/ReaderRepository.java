package com.theSunAndSnow.repository;

import com.theSunAndSnow.entity.Reader;

public interface ReaderRepository {
    public Reader login(String username, String password);
}

package com.theSunAndSnow.repository;

import com.theSunAndSnow.entity.Admin;

public interface AdminRepository {
    public Admin login(String username, String password);
}

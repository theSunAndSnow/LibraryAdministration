package com.theSunAndSnow.service;

import com.theSunAndSnow.entity.Reader;

/**
 * 根据用户名和密码来判断登陆状态：成功 or 失败，+ 成功的结果
 */
public interface LoginService {
    public Reader login (String username, String password);
}

package com.theSunAndSnow.service;

import com.theSunAndSnow.entity.Reader;

/**
 * 处理用户登陆业务
 * 根据用户名和密码来判断登陆状态：成功 or 失败，+ 成功的结果
 * 加一个参数 type 远比多写一个方法强，提升了代码的复用性
 * 返回 Object，利用了多态来提升代码的复用性
 */
public interface LoginService {
    public Object login (String username, String password, String type);
}

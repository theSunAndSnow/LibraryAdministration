package com.theSunAndSnow.repository.impl;

import com.mysql.cj.exceptions.CJOperationNotSupportedException;
import com.theSunAndSnow.entity.Admin;
import com.theSunAndSnow.repository.AdminRepository;
import com.theSunAndSnow.utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminRepositoryImpl implements AdminRepository {

    @Override
    public Admin login(String username, String password) {
        Connection connection = JDBCTools.getConncetion();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from Admin where username = ? and password = ?";

        Admin admin = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                admin = new Admin(resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"));
                System.out.println(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCTools.release(connection, preparedStatement, resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return admin;
    }

    public static void main(String[] args) {
        AdminRepositoryImpl adminRepository = new AdminRepositoryImpl();
        System.out.println(adminRepository);
        System.out.println(adminRepository.login("程勇兵", "cyb"));
    }
}

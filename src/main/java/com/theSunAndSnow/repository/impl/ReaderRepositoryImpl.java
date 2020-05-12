package com.theSunAndSnow.repository.impl;

import com.theSunAndSnow.entity.Reader;
import com.theSunAndSnow.repository.ReaderRepository;
import com.theSunAndSnow.utils.JDBCTools;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.*;

public class ReaderRepositoryImpl implements ReaderRepository {

    @Override
    public Reader login(String username, String password) {
        Connection connection = JDBCTools.getConncetion();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Reader reader = null;

        String sql = "select * from Reader where username = ? and password = ?";

        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                reader = new Reader( resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("name"),
                        resultSet.getString("telephone"),
                        resultSet.getString("cardid"),
                        resultSet.getString("gender") );
                System.out.println(reader.getName() + "登陆成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCTools.release(connection, statement, resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return reader;
//        return readerRepository.login(username, password);
    }

    public static void main(String[] args) {
        ReaderRepositoryImpl readerRepository = new ReaderRepositoryImpl();
        Reader reader = readerRepository.login("theSunAndSnow", "18325379510");
        System.out.println(reader.getName());
    }
}

package com.theSunAndSnow.repository.impl;

import com.theSunAndSnow.repository.BorrowRepository;
import com.theSunAndSnow.utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BorrowRepositoryImpl implements BorrowRepository {
    @Override
    public void insert(Integer readerId, Integer bookId, String borrowTime, String returnTime, Integer adminId, Integer state) {
        Connection connection = JDBCTools.getConncetion();
        String sql = "insert into borrow (bookid, readerid, borrowtime, returntime, state)" +
                "values (" +
                "        ?, ?, ?, ?, 0" +
                "       )";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, bookId);
            preparedStatement.setInt(2, readerId);
            preparedStatement.setString(3, borrowTime);
            preparedStatement.setString(4, returnTime);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCTools.release(connection, preparedStatement, null);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}

package com.theSunAndSnow.repository.impl;

import com.theSunAndSnow.entity.Book;
import com.theSunAndSnow.entity.Borrow;
import com.theSunAndSnow.entity.Reader;
import com.theSunAndSnow.repository.BorrowRepository;
import com.theSunAndSnow.utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Borrow> findAllByReaderId(Integer readerId) {
        ArrayList<Borrow> list = new ArrayList<Borrow>();
        Connection connection = JDBCTools.getConncetion();
        String sql = "select borrow.id, reader.name, book.name as book, book.author,\n" +
                "       book.publish, borrowtime, returntime, borrow.state\n" +
                "from borrow, book, reader\n" +
                "where readerid = ?\n" +
                "and bookid = book.id\n" +
                "and readerid = reader.id;";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, readerId);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
//                优化内存栈
                list.add(new Borrow(
                        resultSet.getInt("id"),
                        new Book(resultSet.getString("book"), resultSet.getString("author"), resultSet.getString("publish")),
                        new Reader(resultSet.getString("name")),
                        resultSet.getString("borrowtime"),
                        resultSet.getString("returntime"),
                        resultSet.getInt("state")
                ));
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

        return list;
    }
}

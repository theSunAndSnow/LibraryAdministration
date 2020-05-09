package com.theSunAndSnow.repository.impl;

import com.theSunAndSnow.entity.Book;
import com.theSunAndSnow.entity.BookSort;
import com.theSunAndSnow.repository.BookRepository;
import com.theSunAndSnow.utils.JDBCTools;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {

    @Override
    public List<Book> findAll() {
        List<Book> list = null;
        Connection connection = JDBCTools.getConncetion();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
//        String sql = "select * from book";不能直接查 book 表的所有数据，因为外键你没办法操作
        String sql = "select * from book, booksort where   book.bookcaseid = booksort.id";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
//                这种写法可以最大限度减少内存开销,减少的是栈内存
                list.add(new Book(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5),
                        resultSet.getDouble(6),
                        new BookSort(
                                resultSet.getInt(9),
                                resultSet.getString(10)
                        )
                    )
                );

            }

            return list;

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
    } // findAll() over

}

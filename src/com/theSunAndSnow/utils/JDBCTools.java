package com.theSunAndSnow.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import jdk.nashorn.internal.scripts.JD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTools {

    private static ComboPooledDataSource dataSource = null;

    static {
        dataSource = new ComboPooledDataSource("library");
    }

    public static Connection getConncetion() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void release (Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    /**
     * 检查 JDBCTools 是否可以正常使用
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(JDBCTools.getConncetion());
        System.out.println("httll");
    }
}

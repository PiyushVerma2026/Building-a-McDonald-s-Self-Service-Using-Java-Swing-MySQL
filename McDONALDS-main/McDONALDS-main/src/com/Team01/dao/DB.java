package com.Team01.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    public Connection createConnection() throws ClassNotFoundException, SQLException {
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookingDB", "root", "1234");
        
        if (connection != null) {
            System.out.println("Connection established");
        }
        return connection;
    }
}
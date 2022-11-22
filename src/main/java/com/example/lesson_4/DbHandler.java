package com.example.lesson_4;

import java.sql.*;

import static com.example.lesson_4.Constants.*;

public class DbHandler {
    private static Connection connection;
    public static Statement statement;
    private static DbHandler instance = null;
    DbService dbService;

    public static synchronized DbHandler getInstance() throws SQLException, ClassNotFoundException {
        if (instance == null)
            instance = new DbHandler();
        return instance;
    }

    private DbHandler() throws SQLException, ClassNotFoundException {
        if (connection == null) {
            Class.forName(CLASS_NAME);
            connection = DriverManager.getConnection(CONNECTION);
            dbService.createDb();
        }
    }

    public void closeConnection() {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Connection closed");
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Connection closed");
            }
        }
    }

}

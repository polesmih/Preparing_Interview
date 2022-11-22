package com.example.lesson_4;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DbHandler dbHandler = DbHandler.getInstance();
        DbService dbService = new DbService();
        dbService.addDataToDb();
        dbService.readDb();
        dbService.findSessionsTableError();
        dbService.showFilmBreaks();
        dbHandler.closeConnection();

    }
}

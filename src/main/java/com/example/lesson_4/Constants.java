package com.example.lesson_4;

public class Constants {

    static final String CONNECTION = "jdbc:sqlite:cinema.s3db";
    static final String CLASS_NAME = "org.sqlite.JDBC";
    static final String DROP = "DROP_TABLE IF EXISTS ";
    static final String SELECT = "SELECT * FROM ";

    static final String CREATE_TABLE_FILMS = "CREATE TABLE if not exists films " +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT," +
            "duration_id INTEGER, FOREIGN KEY (duration_id) REFERENCES duration(id));";
    static final String CREATE_TABLE_DURATION = "CREATE TABLE if not exists duration " +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT, duration INTEGER);";
    static final String CREATE_TABLE_TICKETS = "CREATE TABLE if not exists tickets " +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT, session_id INTEGER" +
            "FOREIGN KEY (session_id) REFERENCES sessions(id));";
    static final String CREATE_TABLE_SESSIONS = "CREATE TABLE if not exists sessions " +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT, film_id INTEGER" +
            "timeStart TEXT, price_id INTEGER, FOREIGN KEY (film_id) REFERENCES films(id));" +
            "FOREIGN KEY (price_id) REFERENCES price(id));";
    static final String CREATE_TABLE_PRICE = "CREATE TABLE if not exists price " +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT, price DECIMAL);";

    static final String CREATE_TABLE_BREAKS = "CREATE TABLE if not exists breaks " +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT, film_name TEXT, " +
            "timeStart TEXT, duration INTEGER, next_film_start TEXT, break_film INTEGER);";

}

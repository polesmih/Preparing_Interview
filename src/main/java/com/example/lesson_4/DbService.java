package com.example.lesson_4;

import java.sql.*;

import static com.example.lesson_4.Constants.*;

public class DbService {

    private static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;

    public static void setConnection(Connection connection) {
        DbService.connection = connection;
    }

    public void createDb() throws SQLException, ClassNotFoundException {
        statement = connection.createStatement();
        statement.execute(DROP + "films");
        statement.execute(DROP + "duration");
        statement.execute(DROP + "tickets");
        statement.execute(DROP + "sessions");
        statement.execute(DROP + "price");

        statement.execute(CREATE_TABLE_DURATION);
        System.out.println("Duration table created");

        statement.execute(CREATE_TABLE_FILMS);
        System.out.println("Films table created");

        statement.execute(CREATE_TABLE_SESSIONS);
        System.out.println("Sessions table created");

        statement.execute(CREATE_TABLE_TICKETS);
        System.out.println("Tickets table created");

        statement.execute(CREATE_TABLE_PRICE);
        System.out.println("Price table created");

        statement.close();
    }

    public void addDataToDb() throws SQLException {
        statement = connection.createStatement();
        statement.execute("INSERT INTO films(name, duration_id) VALUES" +
                "('Move 1, 1')," +
                "('Move 2, 4')," +
                "('Move 3, 2')," +
                "('Move 4, 3');");
        System.out.println("Moves added");

        statement.execute("INSERT INTO duration(duration) VALUES" +
                "(95)," +
                "(124)," +
                "(68)," +
                "(102);");
        System.out.println("Moves duration added");

        statement.execute("INSERT INTO price(price) VALUES" +
                "(15,63)," +
                "(20,00)," +
                "(25,20)," +
                "(18,50);");
        System.out.println("Prices added");

        statement.execute("INSERT INTO sessions(film_id, timeStart, price_id) VALUES" +
                "(1, '12:00', 1)," +
                "(2, '15:00', 4)," +
                "(3, '18:20', 3)," +
                "(1, '18:30', 2)," +
                "(2, '19:00', 3)," +
                "(4, '19:20', 3)," +
                "(3, '22:00', 4);");
        System.out.println("Sessions created");

        statement.execute("INSERT INTO tickets(session_id) VALUES" +
                "(1)," +
                "(2)," +
                "(4)," +
                "(4)," +
                "(3)," +
                "(4)," +
                "(2)," +
                "(2)," +
                "(3)," +
                "(1)," +
                "(1)," +
                "(4)," +
                "(3);");
        System.out.println("Ticket list created");

        statement.close();

    }

    public void readDb() throws SQLException, ClassNotFoundException {
        resultSet = statement.executeQuery(SELECT + "films");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int durationId = resultSet.getInt("duration_id");
            System.out.println("The films table: \n" +
                    "id = " + id + "\n"
                    + "name = " + name + "\n"
                    + "duration_id = " + durationId + "\n");
        }
    }

    public void findSessionsTableError() throws SQLException {
        int timeEnd = 0;
        int count = 0;
        resultSet = statement.executeQuery("SELECT name, duration, timeStart, FROM " +
                "films LEFT JOIN duration ON films.duration_id = duration.id " +
                "LEFT JOIN sessions ON films.id = sessions.film_id ORDER BY startTime");

        System.out.println("Film name    " + "Duration     " + "Start time");

        while (resultSet.next()) {
            count++;
            String name = resultSet.getString("name");
            int duration = resultSet.getInt("duration");
            String timeStart = resultSet.getString("timeStart");

            if (count > 1) {
                if (Integer.parseInt(timeStart) * 60 <= timeEnd) {
                    System.out.println("Error of schedule! Move " + count + " is starting too early");
                }
            }
            timeEnd = Integer.parseInt(timeStart) * 60 + duration;
            System.out.println(name + "           " + duration + "      " + timeStart + "\n");
        }
    }

    public void showFilmBreaks() throws SQLException {
        statement = connection.createStatement();
        statement.execute(DROP + "breaks");
        statement.execute(CREATE_TABLE_BREAKS);

        int timeEnd = 0;
        int count = 0;

        String filmName = null;
        String timeStart = null;
        String next_film_start;
        int break_film;
        int duration = 0;

        resultSet = statement.executeQuery("SELECT name, duration, timeStart FROM " +
                "films LEFT JOIN duration ON films.duration_id = duration.id "+
                "LEFT JOIN sessions On films.id = sessions.film_id ORDER BY timeStart");

        while (resultSet.next()) {
            count++;
            if (count == 1) {
                filmName = resultSet.getString("name");
                duration = resultSet.getInt("duration");
                timeStart = resultSet.getString("timeStart");
                timeEnd = Integer.parseInt(timeStart) * 60 + duration;
            } else {
                next_film_start = resultSet.getString("startTime");
                break_film = (Integer.parseInt(next_film_start) * 60) - timeEnd;

                String prepIns = "INSERT INTO breaks(film_name, timeStart, duration, " +
                        "next_film_start, break_film) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(prepIns);
                preparedStatement.setString(1, filmName);
                preparedStatement.setString(2, timeStart);
                preparedStatement.setInt(3, duration);
                preparedStatement.setString(4, next_film_start);
                preparedStatement.setInt(5, break_film);
                preparedStatement.execute();

                filmName = resultSet.getString("name");
                duration = resultSet.getInt("duration");
                timeStart = resultSet.getString("timeStart");
                timeEnd = Integer.parseInt(timeStart) * 60 + duration;
            }

            resultSet = statement.executeQuery(SELECT + "breaks ORDER BY break");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " +
                        resultSet.getString(3) + " : " + resultSet.getInt(4) + " " +
                        resultSet.getString(5) + " : " + resultSet.getInt(6));
            }

        }

    }



}

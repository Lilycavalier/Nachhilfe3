package org.nachhilfeplattform.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    private static final String URL = "jdbc:sqlite:nachhilfe.db";
    private static Connection conn;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(URL);
                System.out.println("DB Verbindung hergestellt!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
}
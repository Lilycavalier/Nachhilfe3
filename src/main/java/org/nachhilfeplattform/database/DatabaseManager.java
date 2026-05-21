package org.nachhilfeplattform.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseManager {

    public static void connect() {

        try {

            Connection conn =
                    DriverManager.getConnection(
                            "jdbc:sqlite:nachhilfe.db"
                    );

            System.out.println("Verbindung erfolgreich!");

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
    public static void createTable() {

        String sql = "CREATE TABLE IF NOT EXISTS users ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name TEXT NOT NULL,"
                + "email TEXT NOT NULL,"
                + "password TEXT NOT NULL"
                + ");";

        try (

                Connection conn =
                        DriverManager.getConnection(
                                "jdbc:sqlite:nachhilfe.db"
                        );

                Statement stmt = conn.createStatement()

        ) {

            stmt.execute(sql);

            System.out.println("Tabelle erstellt!");

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}
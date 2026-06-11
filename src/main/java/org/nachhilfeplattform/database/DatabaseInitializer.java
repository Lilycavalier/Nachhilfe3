package org.nachhilfeplattform.database;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void createTables() {

        String sqlUsers = """
                CREATE TABLE IF NOT EXISTS users (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL,
                    email TEXT NOT NULL,
                    password TEXT NOT NULL
                );
                """;

        try (
                Connection conn = DatabaseConnection.getConnection();
                Statement stmt = conn.createStatement()
        ) {
            stmt.execute(sqlUsers);
            System.out.println("Tabellen erstellt!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
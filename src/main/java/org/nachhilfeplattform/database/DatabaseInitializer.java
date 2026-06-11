package org.nachhilfeplattform.database;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void createTables() {

        String sqlAnbieter = """
                CREATE TABLE IF NOT EXISTS anbieter (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL UNIQUE,
                    email TEXT NOT NULL UNIQUE,
                    password TEXT NOT NULL
                );
                """;

        String sqlAnzeigen = """
                CREATE TABLE IF NOT EXISTS anzeigen (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL,
                    klassenstufe TEXT NOT NULL,
                    kontaktdaten TEXT NOT NULL,
                    faecher TEXT NOT NULL,
                    zeit TEXT NOT NULL,
                    beschreibung TEXT NOT NULL
                );
                """;

        try (
                Connection conn = DatabaseConnection.getConnection();
                Statement stmt = conn.createStatement()
        ) {
            stmt.execute(sqlAnbieter);
            stmt.execute(sqlAnzeigen);
            System.out.println("Tabellen erstellt!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
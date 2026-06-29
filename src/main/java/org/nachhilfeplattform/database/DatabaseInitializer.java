package org.nachhilfeplattform.database;


import java.sql.Connection;
import java.sql.Statement;


public class DatabaseInitializer {

    public static void createTables() {

        String sqlAnbieter = """
                CREATE TABLE IF NOT EXISTS anbieter (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    benutzername TEXT NOT NULL UNIQUE,
                    email TEXT NOT NULL UNIQUE,
                    passwort TEXT NOT NULL
                );
                """;

        String sqlAnzeigen = """
                CREATE TABLE IF NOT EXISTS anzeigen (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    anbieter_id INTEGER NOT NULL,
                    klassenstufe TEXT NOT NULL,
                    fach TEXT NOT NULL,
                    zeit TEXT NOT NULL,
                    beschreibung TEXT NOT NULL,
                    FOREIGN KEY (anbieter_id) REFERENCES anbieter(id) ON DELETE CASCADE
                );
                """;

        try (
                Connection conn = DatabaseConnection.getConnection();
                Statement stmt = conn.createStatement()
        ) {
            stmt.execute("PRAGMA foreign_keys = ON;");
            stmt.execute(sqlAnbieter);
            stmt.execute(sqlAnzeigen);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
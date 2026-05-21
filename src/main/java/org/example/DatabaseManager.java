package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

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
}
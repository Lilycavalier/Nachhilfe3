package org.nachhilfeplattform.database;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AnzeigeDAO {

    private Connection conn = DatabaseConnection.getConnection();

    public void speichern(Anzeige anzeige){
        String sql = """
                INSERT INTO anzeigen
                ( anbieter_id, klassenstufe, fach, zeit, beschreibung )
                VALUES (?, ?, ?, ?, ?)
                """;
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, anzeige.anbieter_id);
            stmt.setString(2, anzeige.klassenstufe);
            stmt.setString(3, anzeige.fach);
            stmt.setString(4, anzeige.zeit);
            stmt.setString(5, anzeige.beschreibung);

            stmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
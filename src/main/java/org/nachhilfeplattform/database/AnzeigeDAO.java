package org.nachhilfeplattform.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AnzeigeDAO {

    private Connection conn = DatabaseConnection.getConnection();

    public void AnzeigeSpeichern(Anzeige anzeige){
        String sql = """
                INSERT INTO anzeige
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

    public Anzeige AnzeigeAufrufen(int id){
        String sql = "SELECT * FROM anzeige WHERE id = ?";
        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
           stmt.setInt(1, id);

           ResultSet rs = stmt.executeQuery();
           if (rs.next()) {
                Anzeige anzeige = new Anzeige();
                anzeige.id = rs.getInt("id");
                anzeige.anbieter_id = rs.getInt("anbieter_id");
                anzeige.klassenstufe = rs.getString("klassenstufe");
                anzeige.fach = rs.getString("fach");
                anzeige.zeit = rs.getString("zeit");
                anzeige.beschreibung = rs.getString("beschreibung");

                return anzeige;
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
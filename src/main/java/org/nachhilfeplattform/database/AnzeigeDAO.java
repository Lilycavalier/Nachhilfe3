package org.nachhilfeplattform.database;

import org.nachhilfeplattform.model.Anzeige;
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
            stmt.setInt(1, anzeige.getanbieter_id());
            stmt.setString(2, anzeige.getklassenstufe());
            stmt.setString(3, anzeige.getfach());
            stmt.setString(4, anzeige.getzeit());
            stmt.setString(5, anzeige.getbeschreibung());

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
                Anzeige anzeige = new Anzeige(rs.getInt("anbieter_id"), rs.getString("klassenstufe"), rs.getString("fach"), rs.getString("zeit"), rs.getString("beschreibung"));
                return anzeige;
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
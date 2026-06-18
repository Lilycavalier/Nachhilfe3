package org.nachhilfeplattform.database;

import org.nachhilfeplattform.model.Anzeige;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AnzeigeDAO {

    // Anzeige speichern
    public void AnzeigeSpeichern(Anzeige anzeige) {

        String sql = """
                INSERT INTO anzeigen
                (anbieter_id, klassenstufe, fach, zeit, beschreibung)
                VALUES (?, ?, ?, ?, ?)
                """;

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setInt(1, anzeige.getAnbieterId());
            stmt.setString(2, anzeige.getKlassenstufe());
            stmt.setString(3, anzeige.getFach());
            stmt.setString(4, anzeige.getZeit());
            stmt.setString(5, anzeige.getBeschreibung());

            stmt.executeUpdate();

            System.out.println("Anzeige gespeichert!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Anzeige über ID laden
    public Anzeige AnzeigeAufrufen(int id) {

        String sql =
                "SELECT * FROM anzeigen WHERE id = ?";

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement(sql)
        ) {

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                return new Anzeige(
                        rs.getInt("anbieter_id"),
                        rs.getString("klassenstufe"),
                        rs.getString("fach"),
                        rs.getString("zeit"),
                        rs.getString("beschreibung")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // Alle Anzeigen laden
    public List<Anzeige> getAlleAnzeigen() {

        List<Anzeige> anzeigen = new ArrayList<>();

        String sql =
                "SELECT * FROM anzeigen";

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
        ) {

            while (rs.next()) {

                Anzeige anzeige = new Anzeige(
                        rs.getInt("anbieter_id"),
                        rs.getString("klassenstufe"),
                        rs.getString("fach"),
                        rs.getString("zeit"),
                        rs.getString("beschreibung")
                );

                anzeigen.add(anzeige);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return anzeigen;
    }

    public void updateAnzeige(int id, Anzeige anzeige) {
        String sql = """
            UPDATE anzeige
            SET klassenstufe = ?, fach = ?, zeit = ?, beschreibung = ?
            WHERE id = ?
        """;

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, anzeige.getklassenstufe());
            stmt.setString(2, anzeige.getfach());
            stmt.setString(3, anzeige.getzeit());
            stmt.setString(4, anzeige.getbeschreibung());
            stmt.setInt(5, id);

            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAnzeige(int id) {
        String sql = "DELETE FROM anzeige WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
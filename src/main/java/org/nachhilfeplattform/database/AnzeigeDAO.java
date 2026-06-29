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

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Anzeige> getAlleAnzeigen() {

        List<Anzeige> anzeigen = new ArrayList<>();

        String sql = "SELECT * FROM anzeigen";

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                anzeigen.add(new Anzeige(
                        rs.getInt("id"),
                        rs.getInt("anbieter_id"),
                        rs.getString("klassenstufe"),
                        rs.getString("fach"),
                        rs.getString("zeit"),
                        rs.getString("beschreibung")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return anzeigen;
    }

    // Alle Anzeigen laden
    public List<Anzeige> getAlleAnzeigenAnbieter(int anbieterId) {

        List<Anzeige> anzeigen = new ArrayList<>();

        String sql = "SELECT * FROM anzeigen WHERE anbieter_id = ?";

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setInt(1, anbieterId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                anzeigen.add(new Anzeige(
                        rs.getInt("id"),
                        rs.getInt("anbieter_id"),
                        rs.getString("klassenstufe"),
                        rs.getString("fach"),
                        rs.getString("zeit"),
                        rs.getString("beschreibung")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return anzeigen;
    }

    // Update Anzeige (nötig falls wir noch Bearbeitung einführen)
    public void updateAnzeige(int id, Anzeige anzeige) {

        String sql = """
            UPDATE anzeigen
            SET klassenstufe = ?, fach = ?, zeit = ?, beschreibung = ?
            WHERE id = ?
        """;

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setString(1, anzeige.getKlassenstufe());
            stmt.setString(2, anzeige.getFach());
            stmt.setString(3, anzeige.getZeit());
            stmt.setString(4, anzeige.getBeschreibung());
            stmt.setInt(5, id);

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete Anzeige
    public void deleteAnzeige(int id) {

        String sql = "DELETE FROM anzeigen WHERE id = ?";

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Anzeigen filtern nach Akkordeonauswahl
    public List<Anzeige> filterAnzeigen(List<String> faecher, List<String> klassen) {

        List<Anzeige> anzeigen = new ArrayList<>();

        StringBuilder sql = new StringBuilder("SELECT * FROM anzeigen WHERE 1=1");

        if (!faecher.isEmpty()) {

            sql.append(" AND fach IN (");

            for (int i = 0; i < faecher.size(); i++) {
                sql.append("?");
                if (i < faecher.size() - 1) sql.append(",");
            }

            sql.append(")");
        }

        if (!klassen.isEmpty()) {

            sql.append(" AND klassenstufe IN (");

            for (int i = 0; i < klassen.size(); i++) {
                sql.append("?");
                if (i < klassen.size() - 1) sql.append(",");
            }

            sql.append(")");
        }

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql.toString())
        ) {

            int index = 1;

            for (String f : faecher) {
                stmt.setString(index++, f);
            }

            for (String k : klassen) {
                stmt.setString(index++, k);
            }

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                anzeigen.add(new Anzeige(
                        rs.getInt("id"),
                        rs.getInt("anbieter_id"),
                        rs.getString("klassenstufe"),
                        rs.getString("fach"),
                        rs.getString("zeit"),
                        rs.getString("beschreibung")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return anzeigen;
    }
}
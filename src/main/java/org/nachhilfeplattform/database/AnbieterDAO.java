package org.nachhilfeplattform.database;

import org.nachhilfeplattform.model.Anbieter;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class AnbieterDAO {

    public void AnbieterSpeichern(Anbieter anbieter) {

        String sql =
                "INSERT INTO anbieter(benutzername, email, passwort) VALUES (?, ?, ?)";

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setString(1, anbieter.getBenutzername());
            stmt.setString(2, anbieter.getEmail());
            stmt.setString(3, anbieter.getPasswort());

            stmt.executeUpdate();

            System.out.println("Anbieter gespeichert!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Anbieter login(String email, String passwort) {

        String sql =
                "SELECT * FROM anbieter WHERE email = ? AND passwort = ?";

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setString(1, email);
            stmt.setString(2, passwort);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                Anbieter anbieter = new Anbieter(
                        rs.getString("benutzername"),
                        rs.getString("email"),
                        rs.getString("passwort")
                );

                anbieter.setId(rs.getInt("id"));

                return anbieter;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean emailExistiert(String email) {

        String sql = "SELECT 1 FROM anbieter WHERE email = ?";

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();

            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public void deleteAnbieter(int id) {

        String sql = "DELETE FROM anbieter WHERE id = ?";

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
}
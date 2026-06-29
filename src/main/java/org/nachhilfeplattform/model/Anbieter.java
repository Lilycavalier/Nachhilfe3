package org.nachhilfeplattform.model;

import java.util.ArrayList;

public class Anbieter {

    private int id;
    private String benutzername;
    private String email;
    private String passwort;

    private ArrayList<Anzeige> anzeigen;

    public Anbieter(String benutzername, String email, String passwort) {

        this.benutzername = benutzername;
        this.email = email;
        this.passwort = passwort;

        this.anzeigen = new ArrayList<>();
    }

    // Getter

    public int getId() {
        return id;
    }

    public String getBenutzername() {
        return benutzername;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswort() {
        return passwort;
    }

    public ArrayList<Anzeige> getAnzeigen() {
        return anzeigen;
    }

    // Setter

    public void setId(int id) {
        this.id = id;
    }

    public void setBenutzername(String benutzername) {
        this.benutzername = benutzername;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public void setAnzeigen(ArrayList<Anzeige> anzeigen) {
        this.anzeigen = anzeigen;
    }

    @Override
    public String toString() {
        return "Anbieter{" +
                "id=" + id +
                ", benutzername='" + benutzername + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
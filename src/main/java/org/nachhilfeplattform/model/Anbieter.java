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

    public String getName() {
        return benutzername;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswort() {
        return passwort;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}


/*
public class Anbieter{

    private String name;
    private String passwort;
    private ArrayList<Anzeige> anzeigen;


    public Anbieter(String name, String passwort)
    {
        this.name = name;
        this.passwort = passwort;

    }


    public void datenAusgeben(){
        System.out.println("Name: " + name);
        System.out.println("Passwort: " + passwort);
        System.out.println("Anbieter: " + Anbieter);
    }

    public boolean registrieren(String name, String passwort) {
        if(this.name.equals(name)) {
            System.out.println("Name bereits vergeben");
            return false;

        }
        else {
            System.out.println("Registrierung erfolgreich");
            return true;
        }

    }

    public boolean login(String name, String passwort){
        if(this.name.equals(name) && this.passwort.equals(passwort)){
            System.out.println("Login erfolgreich");
            return true;
        }
        else{
            System.out.println("Ungültiger Name oder Passwort");
            return false;
        }
    }

}*/
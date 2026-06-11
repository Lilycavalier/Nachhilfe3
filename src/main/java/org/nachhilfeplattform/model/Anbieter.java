package org.nachhilfeplattform.model;

public class Anbieter {

    private String name;
    private String passwort;

    public Anbieter(String name, String passwort) {
        this.name = name;
        this.passwort = passwort;
    }

    public String getName() {
        return name;
    }

    public String getPasswort() {
        return passwort;
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
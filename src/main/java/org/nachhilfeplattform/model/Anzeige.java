package org.nachhilfeplattform.model;

public class Anzeige {

    private String name;
    private String klassenstufe;
    private String passwort;
    private String kontaktdaten;
    private String faecher;
    private String zeit;

    public Anzeige(String name, String klassenstufe, String passwort, String kontaktdaten, String faecher, String zeit, boolean login)
    {
        this.name = name;
        this.klassenstufe = klassenstufe;
        this.passwort = passwort;
        this.kontaktdaten = kontaktdaten;
        this.faecher = faecher;
        this.zeit = zeit;

    }

    public void datenAusgeben(){
        System.out.println("Name: " + name);
        System.out.println("Klassenstufe: " + klassenstufe);
        System.out.println("Passwort: " + passwort);
        System.out.println("Kontaktdaten:"+kontaktdaten);
        System.out.println("Fächer" + faecher);
        System.out.println("Zeit"+ zeit);
    }

    public void anzeigeErstellen() {

    }

    public void anzeigeLöschen(){

    }


    public void anzeigeBearbeiten(){

    }
}

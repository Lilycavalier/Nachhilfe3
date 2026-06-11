package org.nachhilfeplattform.model;

public class Anzeige {

    private String name;
    private String klassenstufe;
    private String kontaktdaten;
    private String faecher;
    private String zeit;
    private String beschreibung;

    public Anzeige(String name, String klassenstufe, String kontaktdaten, String faecher, String zeit, String beschreibung, boolean login)
    {
        this.name = name;
        this.klassenstufe = klassenstufe;
        this.kontaktdaten = kontaktdaten;
        this.faecher = faecher;
        this.zeit = zeit;
        this.beschreibung = beschreibung;

    }

    public void datenAusgeben(){
        System.out.println("Name: " + name);
        System.out.println("Klassenstufe: " + klassenstufe);
        System.out.println("Kontaktdaten:"+kontaktdaten);
        System.out.println("Fächer" + faecher);
        System.out.println("Zeit"+ zeit);
        System.out.println("Beschreibung"+ beschreibung);

    }

    public void anzeigeErstellen() {
        System.out.println("Anzeige wurde erstellt");
        datenAusgeben();
    }

    public void anzeigeLöschen(){
        name = "";
        klassenstufe = "";
        kontaktdaten = "";
        faecher = "";
        zeit = "";
        beschreibung = "";

        System.out.println("Anzeige wurde gelöscht");


    }


    public void anzeigeBearbeiten(String neueFaecher, String neueZeit, String neueKlassenstufe, String neueBeschreibung, String neueKontaktdaten){

        this.klassenstufe = neueKlassenstufe;
        this.kontaktdaten = neueKontaktdaten;
        this.faecher = neueFaecher;
        this.zeit = neueZeit;
        this.beschreibung = neueBeschreibung;

        System.out.println("Anzeige wurde bearbeitet");

    }
}

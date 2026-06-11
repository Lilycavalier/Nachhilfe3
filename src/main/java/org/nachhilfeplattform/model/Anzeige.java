package org.nachhilfeplattform.model;

public class Anzeige {

    private String benutzername; //über foreign key anbieter_id
    private String klassenstufe;
    private String kontaktdaten; //selbe email wie beim User anbieter -> über db anbieter holen
    private String fach;
    private String zeit;
    private String beschreibung;

    public Anzeige(String benutzername, String klassenstufe, String kontaktdaten, String fach, String zeit, String beschreibung, boolean login)
    {
        this.benutzername = benutzername;
        this.klassenstufe = klassenstufe;
        this.kontaktdaten = kontaktdaten;
        this.fach = fach;
        this.zeit = zeit;
        this.beschreibung = beschreibung;

    }

    public void datenAusgeben(){
        System.out.println("Benutzername: " + benutzername);
        System.out.println("Klassenstufe: " + klassenstufe);
        System.out.println("Kontaktdaten:" + kontaktdaten);
        System.out.println("Fach" + fach);
        System.out.println("Zeit"+ zeit);
        System.out.println("Beschreibung"+ beschreibung);

    }

    public void anzeigeErstellen() {
        System.out.println("Anzeige wurde erstellt");
        datenAusgeben();
    }

    public void anzeigeLöschen(){
        benutzername = "";
        klassenstufe = "";
        kontaktdaten = "";
        fach = "";
        zeit = "";
        beschreibung = "";

        System.out.println("Anzeige wurde gelöscht");


    }


    public void anzeigeBearbeiten(String neuesFach, String neueZeit, String neueKlassenstufe, String neueBeschreibung, String neueKontaktdaten){

        this.klassenstufe = neueKlassenstufe;
        this.kontaktdaten = neueKontaktdaten;
        this.fach = neuesFach;
        this.zeit = neueZeit;
        this.beschreibung = neueBeschreibung;

        System.out.println("Anzeige wurde bearbeitet");

    }
}

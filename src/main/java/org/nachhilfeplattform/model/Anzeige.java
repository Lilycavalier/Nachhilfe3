package org.nachhilfeplattform.model;

public class Anzeige {

    private String anbieter_id; //über foreign key anbieter_id
    private String klassenstufe;
    private String kontaktdaten; //selbe email wie beim User anbieter -> über db anbieter holen
    private String fach;
    private String zeit;
    private String beschreibung;

    public Anzeige(String anbieter_id, String klassenstufe, String fach, String zeit, String beschreibung, boolean login)
    {
        this.anbieter_id = anbieter_id;
        this.klassenstufe = klassenstufe;
        this.fach = fach;
        this.zeit = zeit;
        this.beschreibung = beschreibung;

    }

    public void datenAusgeben(){
        System.out.println("anbieter_id: " + anbieter_id);
        System.out.println("Klassenstufe: " + klassenstufe);
        System.out.println("Fach" + fach);
        System.out.println("Zeit"+ zeit);
        System.out.println("Beschreibung"+ beschreibung);

    }

    public void anzeigeErstellen() {
        System.out.println("Anzeige wurde erstellt");
        datenAusgeben();
    }

    public void anzeigeLöschen(){
        anbieter_id = "";
        klassenstufe = "";
        fach = "";
        zeit = "";
        beschreibung = "";

        System.out.println("Anzeige wurde gelöscht");


    }


    public void anzeigeBearbeiten(String neuesFach, String neueZeit, String neueKlassenstufe, String neueBeschreibung){
        this.klassenstufe = neueKlassenstufe;
        this.fach = neuesFach;
        this.zeit = neueZeit;
        this.beschreibung = neueBeschreibung;

        System.out.println("Anzeige wurde bearbeitet");

    }
}

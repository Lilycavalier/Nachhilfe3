package org.nachhilfeplattform.model;

public class Anzeige {

    private int id;
    private int anbieterId;
    private String klassenstufe;
    private String fach;
    private String zeit;
    private String beschreibung;

    public Anzeige(
            int anbieterId,
            String klassenstufe,
            String fach,
            String zeit,
            String beschreibung) {

        this.anbieterId = anbieterId;
        this.klassenstufe = klassenstufe;
        this.fach = fach;
        this.zeit = zeit;
        this.beschreibung = beschreibung;
    }

    public int getAnbieterId() {
        return anbieterId;
    }

    public String getKlassenstufe() {
        return klassenstufe;
    }

    public String getFach() {
        return fach;
    }

    public String getZeit() {
        return zeit;
    }

    public String getBeschreibung() {
        return beschreibung;
    }
}
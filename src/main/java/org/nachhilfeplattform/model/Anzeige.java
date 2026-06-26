package org.nachhilfeplattform.model;

public class Anzeige {

    private int id;
    private int anbieterId;
    private String klassenstufe;
    private String fach;
    private String zeit;
    private String tag;
    private String beschreibung;

    public Anzeige(int id,
                   int anbieterId,
                   String klassenstufe,
                   String fach,
                   String zeit,
                   String beschreibung) {

        this.id = id;
        this.anbieterId = anbieterId;
        this.klassenstufe = klassenstufe;
        this.fach = fach;
        this.zeit = zeit;
        this.beschreibung = beschreibung;
    }

    // Getter
    public int getId() {
        return id;
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

    // Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setAnbieterId(int anbieterId) {
        this.anbieterId = anbieterId;
    }

    public void setKlassenstufe(String klassenstufe) {
        this.klassenstufe = klassenstufe;
    }

    public void setFach(String fach) {
        this.fach = fach;
    }

    public void setZeit(String zeit) {
        this.zeit = zeit;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
}
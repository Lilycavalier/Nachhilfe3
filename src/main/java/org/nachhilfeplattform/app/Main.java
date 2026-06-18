package org.nachhilfeplattform.app;

import org.nachhilfeplattform.database.AnbieterDAO;
import org.nachhilfeplattform.database.AnzeigeDAO;
import org.nachhilfeplattform.database.DatabaseInitializer;
import org.nachhilfeplattform.model.Anbieter;
import org.nachhilfeplattform.model.Anzeige;
import org.nachhilfeplattform.view.LoginFrame;
import org.nachhilfeplattform.view.HomeFrame;

public class Main {

    public static void main(String[] args) {

        DatabaseInitializer.createTables();
        new LoginFrame();
        AnbieterDAO anbieterDAO = new AnbieterDAO();

        Anbieter jessy =
                new Anbieter("Jessy", "jessy@mail.de", "1234");

        anbieterDAO.AnbieterSpeichern(jessy);
        AnzeigeDAO anzeigeDAO = new AnzeigeDAO();

        for (Anzeige a : anzeigeDAO.getAlleAnzeigen()) {

            System.out.println("Fach: " + a.getFach());
            System.out.println("Klassenstufe: " + a.getKlassenstufe());
            System.out.println("Zeit: " + a.getZeit());
            System.out.println("Beschreibung: " + a.getBeschreibung());

        }

    }
}

//java org.nachhilfeplattform.app.Main
/*
C:\Users\jessy\OneDrive\Desktop\Informatik\Nachhilfe3>javac org\nachhilfeplattform\app\Main.java      
Fehler: Datei nicht gefunden: org\nachhilfeplattform\app\Main.java
Verwendung: javac <Optionen> <Quelldateien>
Mit --help können Sie eine Liste der möglichen Optionen aufrufen

C:\Users\jessy\OneDrive\Desktop\Informatik\Nachhilfe3>cd src/main/java

C:\Users\jessy\OneDrive\Desktop\Informatik\Nachhilfe3\src\main\java>javac org\nachhilfeplattform\app\Main.java

C:\Users\jessy\OneDrive\Desktop\Informatik\Nachhilfe3\src\main\java>java org.nachhilfeplattform.app.Main

C:\Users\jessy\OneDrive\Desktop\Informatik\Nachhilfe3\src\main\java>
*/
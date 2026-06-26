package org.nachhilfeplattform.app;

import org.nachhilfeplattform.database.AnbieterDAO;
import org.nachhilfeplattform.database.AnzeigeDAO;
import org.nachhilfeplattform.database.DatabaseInitializer;
import org.nachhilfeplattform.model.Anbieter;
import org.nachhilfeplattform.model.Anzeige;
import org.nachhilfeplattform.view.LoginFrame;
import org.nachhilfeplattform.view.HomeFrame;
import org.nachhilfeplattform.view.AnbieterFrame;

public class Main {

    public static void main(String[] args) {

        DatabaseInitializer.createTables();

        javax.swing.SwingUtilities.invokeLater(() -> {
            new HomeFrame();
        });
    }
}

//registrieren fehlt noch!!

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

/*
        AnbieterDAO anbieterDAO = new AnbieterDAO();
        AnzeigeDAO anzeigeDAO = new AnzeigeDAO();

        Anbieter lily =
                new Anbieter("Lily", "lily@mail.de", "1234");

        if (!anbieterDAO.emailExistiert("lily@mail.de")) {
            anbieterDAO.AnbieterSpeichern(lily);
        };

        Anbieter jessy =
                new Anbieter("Jessy", "jessy@mail.de", "1234");

        if (!anbieterDAO.emailExistiert("jessy@mail.de")) {
            anbieterDAO.AnbieterSpeichern(jessy);
        };

        Anzeige anzeige = new Anzeige(
                1,
                1,
                "Q12",
                "Mathematik",
                "Dienstag 16-18 Uhr",
                "Ich gebe Mathe-Nachhilfe"
        );


        wichtig immer zu prüfen ob Konto schon existiert!!
        if (!dao.emailExistiert(email)) {
            dao.AnbieterSpeichern(anbieter);
}
 */
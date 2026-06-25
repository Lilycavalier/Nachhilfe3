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

        System.out.println("Start GUI");

        //hihi
        AnbieterDAO anbieterDAO = new AnbieterDAO();
        Anbieter lily =
                new Anbieter("Lily", "lily@mail.de", "1234");

        if (!anbieterDAO.emailExistiert("lily@mail.de")) {
            anbieterDAO.AnbieterSpeichern(lily);
        };

        javax.swing.SwingUtilities.invokeLater(() -> {
            new HomeFrame();
        });
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

/*
Anbieter jessy =
                new Anbieter("Jessy", "jessy@mail.de", "1234");

        anbieterDAO.AnbieterSpeichern(jessy);
        Anzeige anzeige = new Anzeige(
                1,
                1,
                "Q12",
                "Mathematik",
                "Dienstag 16-18 Uhr",
                "Ich gebe Mathe-Nachhilfe"
        );

        anzeigeDAO.AnzeigeSpeichern(anzeige);


if (!dao.emailExistiert(email)) {
    dao.AnbieterSpeichern(anbieter);
}
 */
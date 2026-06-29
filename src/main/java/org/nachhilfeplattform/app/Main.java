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

/* um neue Anbieter zu erzeugen: aktuell nur direkt in der Main möglich auf folgende Weise:

        AnbieterDAO anbieterDAO = new AnbieterDAO();

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

        wichtig immer zu prüfen ob Konto schon existiert!!
        if (!dao.emailExistiert(email)) {
            dao.AnbieterSpeichern(anbieter);
}
 */
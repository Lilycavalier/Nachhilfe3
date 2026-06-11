package org.nachhilfeplattform.app;

import org.nachhilfeplattform.database.DatabaseInitializer;
import org.nachhilfeplattform.view.LoginFrame;
import org.nachhilfeplattform.view.HomeFrame;

public class Main {

    public static void main(String[] args) {

        DatabaseInitializer.createTables();
        new LoginFrame();

    }
}

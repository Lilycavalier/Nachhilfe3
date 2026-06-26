package org.nachhilfeplattform.util;

import javax.swing.*;

public class AkkordeonStunde extends AkkordeonPanel {

    public AkkordeonStunde() {

        super("Uhrzeit");

        String[] zeiten = {
                "1. Stunde",
                "2. Stunde",
                "3. Stunde",
                "4. Stunde",
                "5. Stunde",
                "6. Stunde",
                "7. Stunde",
                "8. Stunde",
                "9. Stunde"
        };

        for (String zeit : zeiten) {

            JCheckBox box = new JCheckBox();

            getContentPanel().add(
                    createRow(zeit, box)
            );

        }

    }

}
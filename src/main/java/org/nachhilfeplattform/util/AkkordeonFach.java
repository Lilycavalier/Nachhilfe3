package org.nachhilfeplattform.util;

import javax.swing.*;

public class AkkordeonFach extends AkkordeonPanel {

    public AkkordeonFach() {

        super("Fach");

        String[] faecher = {
                "Mathematik",
                "Informatik",
                "Deutsch",
                "Englisch",
                "Französisch",
                "Latein",
                "Physik",
                "Chemie",
                "Biologie"
        };

        for (String fach : faecher) {

            JCheckBox box = new JCheckBox();

            getContentPanel().add(
                    createRow(fach, box)
            );

        }

    }

}
package org.nachhilfeplattform.util;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class AkkordeonFach extends AkkordeonPanel {

    private String[] faecher = {
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

    private ArrayList<JCheckBox> boxen = new ArrayList<>();

    public AkkordeonFach() {

        super("Fach");

        for (String fach : faecher) {

            JCheckBox box = new JCheckBox();

            boxen.add(box);

            getContentPanel().add(
                    createRow(fach, box)
            );
        }

    }

    public List<String> getAusgewaehlteFaecher() {

        List<String> auswahl = new ArrayList<>();

        for (int i = 0; i < boxen.size(); i++) {

            if (boxen.get(i).isSelected()) {
                auswahl.add(faecher[i]);
            }

        }

        return auswahl;
    }

}
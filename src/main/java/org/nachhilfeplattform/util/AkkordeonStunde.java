package org.nachhilfeplattform.util;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class AkkordeonStunde extends AkkordeonPanel {

    private String[] zeiten = {
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

    private ArrayList<JCheckBox> boxen = new ArrayList<>();

    public AkkordeonStunde() {

        super("Uhrzeit");

        for (String zeit : zeiten) {

            JCheckBox box = new JCheckBox();

            boxen.add(box);

            getContentPanel().add(
                    createRow(zeit, box)
            );

        }

    }

    public List<String> getAusgewaehlteZeiten() {

        List<String> auswahl = new ArrayList<>();

        for (int i = 0; i < boxen.size(); i++) {

            if (boxen.get(i).isSelected()) {
                auswahl.add(zeiten[i]);
            }

        }

        return auswahl;
    }

}
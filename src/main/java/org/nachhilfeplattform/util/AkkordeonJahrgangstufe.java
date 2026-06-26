package org.nachhilfeplattform.util;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class AkkordeonJahrgangstufe extends AkkordeonPanel {

    private String[] stufen = {
           "5. Klasse",
           "6. Klasse",
           "7. Klasse",
           "8. Klasse",
           "9. Klasse",
           "10. Klasse",
           "11. Klasse",
           "12. Klasse",
           "13. Klasse"
    };

    private ArrayList<JCheckBox> boxen = new ArrayList<>();

    public AkkordeonJahrgangstufe() {

        super("Jahrgangsstufe");

        ButtonGroup group = new ButtonGroup();

        for (String stufe : stufen) {

            JCheckBox box = new JCheckBox();

            boxen.add(box);

            getContentPanel().add(
                    createRow(stufe, box)
            );
        }

    }

    public List<String> getAusgewaehlteKlassen() {

        List<String> auswahl = new ArrayList<>();

        for (int i = 0; i < boxen.size(); i++) {

            if (boxen.get(i).isSelected()) {
                auswahl.add(stufen[i]);
            }

        }

        return auswahl;
    }

}
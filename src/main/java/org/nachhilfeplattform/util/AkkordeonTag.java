package org.nachhilfeplattform.util;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class AkkordeonTag extends AkkordeonPanel {

    private String[] tage = {
            "Montag",
            "Dienstag",
            "Mittwoch",
            "Donnerstag",
            "Freitag"
    };

    private ArrayList<JCheckBox> boxen = new ArrayList<>();

    public AkkordeonTag() {

        super("Tag");

        for (String tag : tage) {

            JCheckBox box = new JCheckBox();

            boxen.add(box);

            getContentPanel().add(
                    createRow(tag, box)
            );

        }

    }

    public List<String> getAusgewaehlteTage() {

        List<String> auswahl = new ArrayList<>();

        for (int i = 0; i < boxen.size(); i++) {

            if (boxen.get(i).isSelected()) {
                auswahl.add(tage[i]);
            }

        }

        return auswahl;
    }

}
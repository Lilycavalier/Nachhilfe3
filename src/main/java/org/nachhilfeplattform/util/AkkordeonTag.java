package org.nachhilfeplattform.util;

import javax.swing.*;

public class AkkordeonTag extends AkkordeonPanel {

    public AkkordeonTag() {

        super("Tag");

        String[] tage = {
                "Montag",
                "Dienstag",
                "Mittwoch",
                "Donnerstag",
                "Freitag"
        };

        for (String tag : tage) {

            JCheckBox box = new JCheckBox();

            getContentPanel().add(
                    createRow(tag, box)
            );

        }

    }

}
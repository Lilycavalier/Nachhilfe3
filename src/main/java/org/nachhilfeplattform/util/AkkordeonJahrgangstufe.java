package org.nachhilfeplattform.util;

import javax.swing.*;

public class AkkordeonJahrgangstufe extends AkkordeonPanel {

    public AkkordeonJahrgangstufe() {

        super("Jahrgangsstufe");

        ButtonGroup group = new ButtonGroup();

        for (int i = 5; i <= 13; i++) {

            JRadioButton radio = new JRadioButton();

            group.add(radio);

            getContentPanel().add(
                    createRow(i + ". Klasse", radio)
            );

        }

    }

}
package org.nachhilfeplattform.view;

import org.nachhilfeplattform.model.Anbieter;
import org.nachhilfeplattform.util.CurrentUser;

import javax.swing.*;

public class AnbieterFrame extends JFrame {

    public AnbieterFrame() {

        Anbieter aktueller = CurrentUser.getAnbieter();

        setTitle("Anbieterbereich");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Willkommen " + aktueller.getBenutzername() + "!");
        add(label);

        setVisible(true);
    }
}
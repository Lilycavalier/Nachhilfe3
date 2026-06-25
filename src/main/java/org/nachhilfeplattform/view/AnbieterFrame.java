package org.nachhilfeplattform.view;

import javax.swing.*;

public class AnbieterFrame extends JFrame {

    public AnbieterFrame() {

        setTitle("Anbieterbereich");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Willkommen im Anbieterbereich!");
        add(label);

        setVisible(true);
    }
}
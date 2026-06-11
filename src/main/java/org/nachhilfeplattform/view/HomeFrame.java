package org.nachhilfeplattform.view;

import javax.swing.*;

public class HomeFrame extends JFrame {

    public HomeFrame() {

        setTitle("Nachhilfe SMÜ");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel sucheLabel = new JLabel("Suche:");
        sucheLabel.setBounds(30, 40, 50, 30);
        add(sucheLabel);

        JTextField sucheField = new JTextField();
        sucheField.setBounds(80, 40, 250, 30);
        add(sucheField);

        JButton suchenButton = new JButton("Suchen");
        suchenButton.setBounds(350, 40, 100, 30);
        add(suchenButton);

        setVisible(true);
    }
}
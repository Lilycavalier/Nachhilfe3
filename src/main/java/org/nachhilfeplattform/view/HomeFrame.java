package org.nachhilfeplattform.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeFrame extends JFrame {


    public HomeFrame() {

        setTitle("Nachhilfe SMÜ");
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        //JLabel sucheLabel = new JLabel("Suche:");
        //sucheLabel.setBounds(30, 40, 50, 30);
        //add(sucheLabel);

        //JTextField sucheField = new JTextField();
        //sucheField.setBounds(80, 40, 250, 30);
        //add(sucheField);

        //JButton suchenButton = new JButton("OK");
        //suchenButton.setBounds(350, 40, 100, 30);
        //add(suchenButton);

        JLabel filter = new JLabel("Filter:");
        filter.setBounds(10, 40, 200, 30);
        filter.setFont(new Font("Arial", Font.PLAIN, 22));
        add(filter);

        ArrowToggleExample togglePanel = new ArrowToggleExample();
        togglePanel.setBounds(10, 60, 300, 250);
        add(togglePanel);

        AkkordionFach togglePanelFach = new AkkordionFach();
        togglePanelFach.setBounds(100, 60, 300, 250);
        add(togglePanelFach);

        setVisible(true);
    }
}


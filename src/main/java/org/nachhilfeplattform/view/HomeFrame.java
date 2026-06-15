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
        filter.setBounds(30, 40, 200, 30);
        filter.setFont(new Font("Arial", Font.PLAIN, 22));
        add(filter);

        JLabel filterStufe = new JLabel("Jahrgangsstufe:");
        filterStufe.setBounds(30, 80, 200, 30);
        filterStufe.setFont(new Font("Arial", Font.PLAIN, 12));
        add(filterStufe);

        JLabel filterFach = new JLabel("Fach:");
        filterFach.setBounds(30, 100, 200, 30);
        filterFach.setFont(new Font("Arial", Font.PLAIN, 12));
        add(filterFach);

        JLabel filterStunde = new JLabel("Schulstunde:");
        filterStunde.setBounds(30, 120, 200, 30);
        filterStunde.setFont(new Font("Arial", Font.PLAIN, 12));
        add(filterStunde);

        setVisible(true);
    }
}


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
        togglePanel.setBounds(10, 60, 200, 250);
        add(togglePanel);

        AkkordionFach togglePanelFach = new AkkordionFach();
        togglePanelFach.setBounds(210, 60, 200, 250);
        add(togglePanelFach);

        AkkordionTag togglePanelTag = new AkkordionTag();
        togglePanelTag.setBounds(410, 60, 200, 250);
        add(togglePanelTag);

        AkkordionStunde togglePanelStunde = new AkkordionStunde();
        togglePanelStunde.setBounds(610, 60, 200, 250);
        add(togglePanelStunde);

        JButton closeButton = new JButton("OK");
        closeButton.setBounds(850, 65, 60, 30);
        add(closeButton);

        JLabel anzeige = new JLabel("6.Klasse; Latein; Montag; 8.Stunde; Hannah");
        anzeige.setBounds(10, 350, 600, 30);
        anzeige.setFont(new Font("Arial", Font.PLAIN, 15));
        add(anzeige);

        JButton Buchen = new JButton("Details");
        Buchen.setBounds(350, 350, 80, 30);
        add(Buchen);

        JLabel anzeige = new JLabel("Anzeigen:");
        anzeige.setBounds(10, 330, 200, 30);
        anzeige.setFont(new Font("Arial", Font.PLAIN, 22));
        add(anzeige);


        setVisible(true);
    }
}


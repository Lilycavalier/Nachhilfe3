package org.nachhilfeplattform.util;

import javax.swing.*;
import java.awt.*;

public class AkkordeonStunde extends JPanel{

    private boolean expanded = false;
    private JButton arrowButton;
    private JPanel contentPanel;

    public AkkordeonStunde(){
        setLayout(new BorderLayout());

        arrowButton = new JButton("+");
        arrowButton.setFocusPainted(false);
        arrowButton.setBorderPainted(false);
        arrowButton.setContentAreaFilled(false);

        contentPanel = new JPanel();
        contentPanel.setBackground(Color.WHITE);

        contentPanel.setLayout(new GridLayout(0, 2)); // beliebig viele Zeilen, 2 Spalten

        ButtonGroup group = new ButtonGroup();

        JRadioButton rb5 = new JRadioButton();
        JRadioButton rb6 = new JRadioButton();
        JRadioButton rb7 = new JRadioButton();
        JRadioButton rb8 = new JRadioButton();
        JRadioButton rb9 = new JRadioButton();
        JRadioButton rb10 = new JRadioButton();
        JRadioButton rb11 = new JRadioButton();
        JRadioButton rb12 = new JRadioButton();
        JRadioButton rb13 = new JRadioButton();

        group.add(rb5);
        group.add(rb6);
        group.add(rb7);
        group.add(rb8);
        group.add(rb9);
        group.add(rb10);
        group.add(rb11);
        group.add(rb12);
        group.add(rb13);

        contentPanel.add(new JLabel("1.Stunde"));
        contentPanel.add(rb5);

        contentPanel.add(new JLabel("2.Stunde"));
        contentPanel.add(rb6);

        contentPanel.add(new JLabel("3.Stunde"));
        contentPanel.add(rb7);

        contentPanel.add(new JLabel("4.Stunde"));
        contentPanel.add(rb8);
        
        contentPanel.add(new JLabel("5.Stunde"));
        contentPanel.add(rb9);

        contentPanel.add(new JLabel("6.Stunde"));
        contentPanel.add(rb10);

        contentPanel.add(new JLabel("7.Stunde"));
        contentPanel.add(rb11);

        contentPanel.add(new JLabel("8.Stunde"));
        contentPanel.add(rb12);

        contentPanel.add(new JLabel("9.Stunde"));
        contentPanel.add(rb13);
       
        contentPanel.setVisible(false);

        arrowButton.addActionListener(e -> {
            expanded = !expanded;
            contentPanel.setVisible(expanded);
            arrowButton.setText(expanded ? "-" : "+");
            revalidate();
        });

        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        headerPanel.add(arrowButton);
        headerPanel.add(new JLabel("Stunde"));

        add(headerPanel, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AkkordeonJahrgangstufe::new);
    }

        
    }
package org.nachhilfeplattform.util;

import javax.swing.*;
import java.awt.*;

public class AkkordeonJahrgangstufe extends JPanel{

    private boolean expanded = false;
    private JButton arrowButton;
    private JPanel contentPanel;
    private JButton closeButton;

    public AkkordeonJahrgangstufe(){
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

        contentPanel.add(new JLabel("5. Klasse"));
        contentPanel.add(rb5);

        contentPanel.add(new JLabel("6. Klasse"));
        contentPanel.add(rb6);

        contentPanel.add(new JLabel("7. Klasse"));
        contentPanel.add(rb7);

        contentPanel.add(new JLabel("8. Klasse"));
        contentPanel.add(rb8);
        
        contentPanel.add(new JLabel("9. Klasse"));
        contentPanel.add(rb9);

        contentPanel.add(new JLabel("10. Klasse"));
        contentPanel.add(rb10);

        contentPanel.add(new JLabel("11. Klasse"));
        contentPanel.add(rb11);

        contentPanel.add(new JLabel("12. Klasse"));
        contentPanel.add(rb12);

        contentPanel.add(new JLabel("13. Klasse"));
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
        headerPanel.add(new JLabel("Jahrgangsstufe"));

        add(headerPanel, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);

       
    

        arrowButton.setSelected(false);
        arrowButton.setText("+");
        contentPanel.setVisible(false);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AkkordeonJahrgangstufe::new);
    } 
}



        
    

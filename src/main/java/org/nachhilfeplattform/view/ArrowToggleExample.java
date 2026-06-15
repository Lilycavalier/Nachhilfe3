package org.nachhilfeplattform.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArrowToggleExample extends JFrame{

    private boolean expanded = false;
    private JButton arrowButton;
    private JPanel contentPanel;

    public ArrowToggleExample(){

       setTitle("Pfeil zum Ausklappen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        arrowButton = new JButton(">");
        arrowButton.setFocusPainted(false);
        arrowButton.setBorderPainted(false);
        arrowButton.setContentAreaFilled(false);

        contentPanel = new JPanel();
        contentPanel.setBackground(Color.LIGHT_GRAY);
        contentPanel.add(new JLabel("jdghes"));
        contentPanel.setVisible(false);

        arrowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            expanded = !expanded;
            contentPanel.setVisible(expanded);
            arrowButton.setText(expanded ? ">" : "<");
            pack();
            }
        });

        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        headerPanel.add(arrowButton);
        headerPanel.add(new JLabel("Überschrift"));

        add(headerPanel, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(ArrowToggleExample::new);
        }

        
    }

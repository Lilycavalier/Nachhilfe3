package org.nachhilfeplattform.view;

import javax.swing.*;
import java.awt.*;

public class HomeFrame extends JFrame {

    private JPanel anzeigenPanel;

    public HomeFrame() {

        setTitle("Nachhilfe SMÜ");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout(10, 10));

        // =========================
        // TITEL
        // =========================

        JLabel titel = new JLabel("Nachhilfe SMÜ");
        titel.setFont(new Font("Arial", Font.BOLD, 30));
        titel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel titelPanel = new JPanel();
        titelPanel.add(titel);

        add(titelPanel, BorderLayout.NORTH);

        // =========================
        // FILTER
        // =========================

        JPanel filterPanel = new JPanel();
        filterPanel.setPreferredSize(new Dimension(250, 0));
        filterPanel.setBorder(
                BorderFactory.createTitledBorder("Filter")
        );

        filterPanel.setLayout(
                new BoxLayout(
                        filterPanel,
                        BoxLayout.Y_AXIS
                )
        );

        filterPanel.add(Box.createVerticalStrut(10));

        ArrowToggleExample klassenPanel =
                new ArrowToggleExample();

        AkkordionFach fachPanel =
                new AkkordionFach();

        filterPanel.add(klassenPanel);
        filterPanel.add(Box.createVerticalStrut(15));
        filterPanel.add(fachPanel);

        add(filterPanel, BorderLayout.WEST);

        // =========================
        // ANZEIGENLISTE
        // =========================

        anzeigenPanel = new JPanel();

        anzeigenPanel.setLayout(
                new BoxLayout(
                        anzeigenPanel,
                        BoxLayout.Y_AXIS
                )
        );

        anzeigenPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        10, 10, 10, 10
                )
        );

        // Testdaten
        addAnzeige(
                "Mathematik",
                "Q12",
                "Dienstag 16-18 Uhr",
                "Ich gebe Mathe-Nachhilfe."
        );

        addAnzeige(
                "Informatik",
                "Q11",
                "Montag 15-17 Uhr",
                "Hilfe bei Java und Programmierung."
        );

        JScrollPane scrollPane =
                new JScrollPane(anzeigenPanel);

        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    /**
     * Fügt eine Anzeige zur Liste hinzu
     */
    private void addAnzeige(
            String fach,
            String klassenstufe,
            String zeit,
            String beschreibung) {

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        panel.setBorder(
                BorderFactory.createTitledBorder(fach)
        );

        JTextArea info = new JTextArea(
                "Klassenstufe: " + klassenstufe +
                        "\nZeit: " + zeit +
                        "\nBeschreibung: " + beschreibung
        );

        info.setEditable(false);
        info.setLineWrap(true);
        info.setWrapStyleWord(true);

        panel.add(info, BorderLayout.CENTER);

        panel.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        120
                )
        );

        anzeigenPanel.add(panel);
        anzeigenPanel.add(Box.createVerticalStrut(10));
    }
}


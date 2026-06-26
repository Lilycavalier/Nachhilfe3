package org.nachhilfeplattform.view;

import org.nachhilfeplattform.util.AkkordeonFach;
import org.nachhilfeplattform.util.AkkordeonJahrgangstufe;
import org.nachhilfeplattform.util.AkkordeonStunde;
import org.nachhilfeplattform.util.AkkordeonTag;

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

        // =========================
// TITEL + LOGIN BUTTON
// =========================

        JPanel topPanel = new JPanel(new BorderLayout());

        JLabel titel = new JLabel("Nachhilfe SMÜ");
        titel.setFont(new Font("Arial", Font.BOLD, 30));
        titel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton loginButton = new JButton("Anbieter Login");

        loginButton.addActionListener(e -> {
            dispose();
            new LoginFrame();
        });

        topPanel.add(titel, BorderLayout.CENTER);
        topPanel.add(loginButton, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);

        // =========================
        // FILTER
        // =========================

        JPanel filterPanel = new JPanel();
        filterPanel.setLayout(new BoxLayout(filterPanel, BoxLayout.Y_AXIS));
        filterPanel.setBorder(
                BorderFactory.createTitledBorder("Filter")
        );

        AkkordeonJahrgangstufe klassenPanel = new AkkordeonJahrgangstufe();
        AkkordeonFach fachPanel = new AkkordeonFach();
        AkkordeonStunde stundePanel = new AkkordeonStunde();
        AkkordeonTag tagPanel = new AkkordeonTag();

        filterPanel.add(klassenPanel);
        filterPanel.add(Box.createVerticalStrut(10));

        filterPanel.add(fachPanel);
        filterPanel.add(Box.createVerticalStrut(10));

        filterPanel.add(stundePanel);
        filterPanel.add(Box.createVerticalStrut(10));

        filterPanel.add(tagPanel);
        filterPanel.add(Box.createVerticalStrut(20));

        JButton filterButton = new JButton("Filter anwenden");
        filterPanel.add(filterButton);

        // Alles nach oben schieben
        filterPanel.add(Box.createVerticalGlue());

        JScrollPane filterScroll = new JScrollPane(filterPanel);
        filterScroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        filterScroll.getVerticalScrollBar().setUnitIncrement(16);

        add(filterScroll, BorderLayout.WEST);

        // =========================
        // ANZEIGENLISTE
        // =========================

        anzeigenPanel = new JPanel();
        anzeigenPanel.setBorder(
                BorderFactory.createTitledBorder("Anzeigen")
        );

        anzeigenPanel.setLayout(
                new BoxLayout(
                        anzeigenPanel,
                        BoxLayout.Y_AXIS
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

        JScrollPane scrollPane = new JScrollPane(anzeigenPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

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


package org.nachhilfeplattform.view;

import org.nachhilfeplattform.database.AnzeigeDAO;
import org.nachhilfeplattform.model.Anzeige;
import org.nachhilfeplattform.util.AkkordeonFach;
import org.nachhilfeplattform.util.AkkordeonJahrgangstufe;
import java.util.List;

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

        JPanel filterPanel = new JPanel(new BorderLayout());

        filterPanel.setPreferredSize(new Dimension(230, 0));
        filterPanel.setBorder(BorderFactory.createTitledBorder("Filter"));

        JPanel filterContent = new JPanel();
        filterContent.setLayout(new BoxLayout(filterContent, BoxLayout.Y_AXIS));

        AkkordeonJahrgangstufe klassenPanel = new AkkordeonJahrgangstufe();
        AkkordeonFach fachPanel = new AkkordeonFach();

        filterContent.add(klassenPanel);
        filterContent.add(Box.createVerticalStrut(10));

        filterContent.add(fachPanel);
        filterContent.add(Box.createVerticalStrut(10));

        JScrollPane filterScroll = new JScrollPane(filterContent);
        filterScroll.setBorder(BorderFactory.createEmptyBorder());
        filterScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        filterScroll.getVerticalScrollBar().setUnitIncrement(16);

        filterPanel.add(filterScroll, BorderLayout.CENTER);

        JPanel buttonPanel = getJPanel(fachPanel, klassenPanel);
        filterPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(filterPanel, BorderLayout.WEST);

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

        ladeAlleAnzeigen();

        JScrollPane scrollPane = new JScrollPane(anzeigenPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel getJPanel(AkkordeonFach fachPanel, AkkordeonJahrgangstufe klassenPanel) {
        JButton filterButton = new JButton("Filter anwenden");

        // filter anwenden
        filterButton.addActionListener(e -> {

            List<String> faecher = fachPanel.getAusgewaehlteFaecher();
            List<String> klassen = klassenPanel.getAusgewaehlteKlassen();

            AnzeigeDAO dao = new AnzeigeDAO();

            List<Anzeige> ergebnis = dao.filterAnzeigen(
                    faecher,
                    klassen
            );

            anzeigenPanel.removeAll();

            for (Anzeige a : ergebnis) {
                addAnzeige(
                        a.getFach(),
                        a.getKlassenstufe(),
                        a.getZeit(),
                        a.getBeschreibung()
                );
            }

            anzeigenPanel.revalidate();
            anzeigenPanel.repaint();
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(filterButton);
        return buttonPanel;
    }

    private void ladeAlleAnzeigen() {

        anzeigenPanel.removeAll();

        AnzeigeDAO dao = new AnzeigeDAO();

        for (Anzeige a : dao.getAlleAnzeigen()) {

            addAnzeige(
                    a.getFach(),
                    a.getKlassenstufe(),
                    a.getZeit(),
                    a.getBeschreibung()
            );
        }

        anzeigenPanel.revalidate();
        anzeigenPanel.repaint();
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


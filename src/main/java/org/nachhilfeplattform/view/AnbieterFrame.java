package org.nachhilfeplattform.view;

import javax.swing.*;

import org.nachhilfeplattform.database.AnzeigeDAO;
import org.nachhilfeplattform.model.Anbieter;
import org.nachhilfeplattform.model.Anzeige;
import org.nachhilfeplattform.util.CurrentUser;

import java.util.List;

import java.awt.*;

public class AnbieterFrame extends JFrame {

    public AnbieterFrame() {
        Anbieter aktueller = CurrentUser.getAnbieter();

        setTitle("Anbieterbereich");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout(10, 10));

        // TITEL OBEN
        JLabel titel = new JLabel("Willkommen " + aktueller.getBenutzername() + "!");
        titel.setFont(new Font("Arial", Font.BOLD, 30));
        titel.setHorizontalAlignment(SwingConstants.CENTER);

        add(titel, BorderLayout.NORTH);

        // NAVBAR LINKS
        JPanel navPanel = new JPanel();

        navPanel.setPreferredSize(new Dimension(220, 0));

        navPanel.setBorder(
                BorderFactory.createTitledBorder("Navigation")
        );

        navPanel.setLayout(
                new BoxLayout(
                        navPanel,
                        BoxLayout.Y_AXIS
                )
        );

        // INHALT
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(
            new BoxLayout(
                contentPanel,
                BoxLayout.Y_AXIS
            )
        );
        contentPanel.setBorder(
                BorderFactory.createTitledBorder("Inhalt")
        );
        JLabel contentLabel = new JLabel("");

        contentLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        contentLabel.setMaximumSize(
            new Dimension(Integer.MAX_VALUE, contentLabel.getPreferredSize().height)
        );

        contentPanel.add(contentLabel);
        contentPanel.add(contentLabel);
        contentPanel.add(Box.createVerticalStrut(10));
        
        //"buttons"
        JButton anzeigenButton = new JButton("Meine Anzeigen");
        JButton erstellenButton = new JButton("Anzeige erstellen");
        //styling
        erstellenButton.setFocusPainted(false);
        erstellenButton.setContentAreaFilled(false);
        erstellenButton.setOpaque(true);
        erstellenButton.setBorderPainted(false);
        anzeigenButton.setFocusPainted(false);
        anzeigenButton.setContentAreaFilled(false);
        anzeigenButton.setOpaque(true);
        anzeigenButton.setBorderPainted(false);

        //ausgewählt effekte
        setActiveButton(anzeigenButton, erstellenButton);
        anzeigenButton.addActionListener(e -> {
            contentPanel.removeAll();

            contentPanel.add(Box.createVerticalStrut(10));
            AnzeigeDAO dao = new AnzeigeDAO();

            List<Anzeige> anzeigen =
                    dao.getAlleAnzeigenAnbieter(aktueller.getId());
            renderAnzeigen(anzeigen, contentPanel);

            contentPanel.revalidate();
            contentPanel.repaint();

            setActiveButton(anzeigenButton, erstellenButton);
        });
        
        erstellenButton.addActionListener(e -> {
            contentPanel.removeAll();

            contentLabel.setText("Neue Anzeige erstellen");
            contentPanel.add(contentLabel);

            contentPanel.revalidate();
            contentPanel.repaint();
            setActiveButton(erstellenButton, anzeigenButton);
        });

        navPanel.add(Box.createVerticalStrut(10));
        navPanel.add(anzeigenButton);
        navPanel.add(Box.createVerticalStrut(5));
        navPanel.add(erstellenButton);

        add(navPanel, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void setActiveButton(JButton active, JButton other) {
        active.setText("<html><u>" + active.getText().replaceAll("<.*?>", "") + "</u></html>");
        other.setText(other.getText().replaceAll("<.*?>", ""));
    }

    private String meineAnzeigen(){
        return "";
    }

    public void renderAnzeigen(List<Anzeige> anzeigen, JPanel contentPanel){
        for(int i=0; i<anzeigen.size(); i++){
            displayAnzeige(anzeigen.get(i), contentPanel);
        }
    }

    public void displayAnzeige(Anzeige anzeige, JPanel contentPanel ){
        String fach = anzeige.getFach();
        String klassenstufe = anzeige.getKlassenstufe();
        String zeit = anzeige.getZeit();
        String beschreibung = anzeige.getBeschreibung();

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

        contentPanel.add(panel);
        contentPanel.add(Box.createVerticalStrut(10));
    }
}
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
        contentPanel.setBorder(
                BorderFactory.createTitledBorder("Inhalt")
        );
        JLabel contentLabel = new JLabel("Helluuu");
        contentPanel.add(contentLabel);
        
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
        //hover effekte
        anzeigenButton.addActionListener(e -> {
            AnzeigeDAO dao = new AnzeigeDAO();

            List<Anzeige> anzeigen =
                    dao.getAlleAnzeigen(aktueller.getId());

            contentLabel.setText("Anzahl Anzeigen: " + anzeigen.size());

            setActiveButton(anzeigenButton, erstellenButton);
        });
        
        erstellenButton.addActionListener(e -> {
            contentLabel.setText("Neue Anzeige erstellen");
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
}
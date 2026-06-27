package org.nachhilfeplattform.view;

import javax.swing.*;

import org.nachhilfeplattform.database.AnzeigeDAO;
import org.nachhilfeplattform.model.Anbieter;
import org.nachhilfeplattform.model.Anzeige;
import org.nachhilfeplattform.util.AkkordeonFach;
import org.nachhilfeplattform.util.AkkordeonJahrgangstufe;
import org.nachhilfeplattform.util.CurrentUser;

import java.util.List;

import java.awt.*;

public class AnbieterFrame extends JFrame {

    public AnbieterFrame() {
        Anbieter aktuellerAnbieter = CurrentUser.getAnbieter();

        setTitle("Anbieterbereich");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout(10, 10));

        // TITEL OBEN
        JPanel topPanel = new JPanel(new BorderLayout());

        JLabel titel = new JLabel("Willkommen " + aktuellerAnbieter.getBenutzername() + "!");
        titel.setFont(new Font("Arial", Font.BOLD, 30));
        titel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton logoutButton = new JButton("Ausloggen");

        logoutButton.addActionListener(e -> {
            CurrentUser.logout();
            dispose();
            new HomeFrame();
        });

        topPanel.add(titel, BorderLayout.CENTER);
        topPanel.add(logoutButton, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);

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
        showAnzeigen(contentPanel, anzeigenButton, erstellenButton, aktuellerAnbieter);
        anzeigenButton.addActionListener(e -> {
            showAnzeigen(contentPanel, anzeigenButton, erstellenButton, aktuellerAnbieter);
        });
        
        erstellenButton.addActionListener(e -> {
            showErstellen(contentPanel, contentLabel, erstellenButton, anzeigenButton);
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

        JButton loeschenButton = new JButton("Löschen");

        loeschenButton.addActionListener(e -> {
            AnzeigeDAO dao = new AnzeigeDAO();
            dao.deleteAnzeige(anzeige.getId());

            contentPanel.remove(panel);
            contentPanel.revalidate();
            contentPanel.repaint();
        });

        panel.add(loeschenButton, BorderLayout.SOUTH);

        contentPanel.add(panel);
        contentPanel.add(Box.createVerticalStrut(10));
    }

    private void showAnzeigen(JPanel contentPanel, JButton anzeigenButton, JButton erstellenButton, Anbieter aktuellerAnbieter){
        contentPanel.removeAll();

        contentPanel.add(Box.createVerticalStrut(10));
        AnzeigeDAO dao = new AnzeigeDAO();

        List<Anzeige> anzeigen =
                dao.getAlleAnzeigenAnbieter(aktuellerAnbieter.getId());
        renderAnzeigen(anzeigen, contentPanel);

        contentPanel.revalidate();
        contentPanel.repaint();

        setActiveButton(anzeigenButton, erstellenButton);
    }

    
    private void showErstellen(JPanel contentPanel, JLabel contentLabel, JButton erstellenButton, JButton anzeigenButton) {
        contentPanel.removeAll();
    
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    
        panel.setBorder(
                BorderFactory.createTitledBorder("Neue Anzeige erstellen")
        );
    
        JPanel newContent = new JPanel();
        newContent.setLayout(new BoxLayout(newContent, BoxLayout.Y_AXIS));
        newContent.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        //klasse dp
        JPanel klassePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel klasseLabel = new JLabel("Wähle eine Klassenstufe aus");
        klasseLabel.setVisible(true);
        klassePanel.add(klasseLabel);
        String[] klassen = { 
            "5. Klasse",
           "6. Klasse",
           "7. Klasse",
           "8. Klasse",
           "9. Klasse",
           "10. Klasse",
           "11. Klasse",
           "12. Klasse",
           "13. Klasse"
        };
        final JComboBox<String> klasseDP = new JComboBox<String>(klassen);
        klasseDP.setVisible(true);
        klassePanel.add(klasseDP);
        
        //fach dp
        JPanel fachPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lbl = new JLabel("Wähle ein Fach aus");
        lbl.setVisible(true);
        fachPanel.add(lbl);
        String[] choices = { 
            "Mathematik",
            "Informatik",
            "Deutsch",
            "Englisch",
            "Französisch",
            "Latein",
            "Physik",
            "Chemie",
            "Biologie"
        };
        final JComboBox<String> cb = new JComboBox<String>(choices);
        cb.setVisible(true);
        fachPanel.add(cb);

        fachPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        klassePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        //zeit
        JPanel zeitPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel zeitLabel = new JLabel("Zeit:");
        JTextField zeit = new JTextField(20);
    
        zeitPanel.add(zeitLabel);
        zeitPanel.add(zeit);
    
        zeitPanel.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, zeitPanel.getPreferredSize().height)
        );

        zeitPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        //beschreibung
        JPanel beschreibungPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel beschreibungJLabel = new JLabel("Beschreibung:");
        JTextField beschreibung = new JTextField(20);
    
        beschreibungPanel.add(beschreibungJLabel);
        beschreibungPanel.add(beschreibung);
    
        beschreibungPanel.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, beschreibungPanel.getPreferredSize().height)
        );

        beschreibungPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
    
        newContent.add(klassePanel);
        newContent.add(Box.createVerticalStrut(10));
        newContent.add(fachPanel);
        newContent.add(Box.createVerticalStrut(10));
        newContent.add(zeitPanel);
        newContent.add(Box.createVerticalStrut(10));
        newContent.add(beschreibungPanel);

        newContent.setAlignmentX(Component.LEFT_ALIGNMENT);
        newContent.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, newContent.getPreferredSize().height)
        );
    
        panel.add(newContent);
        panel.add(Box.createVerticalGlue());
        JButton speichernButton  = new JButton("Speichern");
        newContent.add(speichernButton );

        speichernButton.addActionListener(e -> {
            String klassenstufe = (String) klasseDP.getSelectedItem();
            String fach = (String) cb.getSelectedItem();
            String zeitText = zeit.getText();
            String beschreibungText = beschreibung.getText();
        
            Anzeige neueAnzeige = new Anzeige(
                    0,
                    CurrentUser.getAnbieter().getId(),
                    klassenstufe,
                    fach,
                    zeitText,
                    beschreibungText
            );
        
            AnzeigeDAO dao = new AnzeigeDAO();
            dao.AnzeigeSpeichern(neueAnzeige);
        
            JOptionPane.showMessageDialog(this, "Anzeige wurde gespeichert!");
        });
    
        contentPanel.add(panel);
    
        contentPanel.revalidate();
        contentPanel.repaint();
    
        setActiveButton(erstellenButton, anzeigenButton);
    }
}
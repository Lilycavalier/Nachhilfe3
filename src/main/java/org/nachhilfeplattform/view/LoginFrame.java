package org.nachhilfeplattform.view;

import org.nachhilfeplattform.database.AnbieterDAO;
import org.nachhilfeplattform.model.Anbieter;
import org.nachhilfeplattform.util.CurrentUser;

import javax.swing.*;
import java.awt.Font;
import java.awt.*;

public class LoginFrame extends JFrame {

    public LoginFrame() {

        setTitle("Nachhilfe SMÜ");
        setSize(400,400);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Login");
        label.setBounds(155, 70, 200, 50);
        label.setFont(new Font("Arial", Font.PLAIN, 30));
        add(label);

        JLabel emailLabel = new JLabel("E-Mail:");
        emailLabel.setBounds(20, 120, 60, 30);
        add(emailLabel);

        JTextField email = new JTextField();
        email.setBounds(90, 120, 200, 30);
        add(email);

        JLabel passwortLabel = new JLabel("Passwort:");
        passwortLabel.setBounds(20, 160, 70, 30);
        add(passwortLabel);

        JPasswordField passwort = new JPasswordField();
        passwort.setBounds(90, 160, 200, 30);
        add(passwort);

        JLabel fehler = new JLabel("Das Passwort oder die E-Mail ist falsch!");
        fehler.setBounds(80, 200, 300, 30);
        fehler.setForeground(Color.RED);
        fehler.setVisible(false);
        add(fehler);

        JButton ok = new JButton("OK");
        ok.setBounds(155, 230, 70, 30);
        add(ok);

        ok.addActionListener(e -> {

            fehler.setVisible(false); // immer zuerst ausblenden

            String eingegebeneEmail = email.getText();
            String eingegebenesPasswort = new String(passwort.getPassword());

            AnbieterDAO dao = new AnbieterDAO();

            Anbieter anbieter = dao.login(eingegebeneEmail, eingegebenesPasswort);

            if (anbieter != null) {

                CurrentUser.setAnbieter(anbieter);

                dispose();
                new AnbieterFrame();

            } else {
                fehler.setVisible(true);
            }
        });
    }
}
//test neu
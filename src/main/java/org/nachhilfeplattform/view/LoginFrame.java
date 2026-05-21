package org.nachhilfeplattform.view;

import javax.swing.*;
import java.awt.Font;

public class LoginFrame extends JFrame {

    public LoginFrame() {

        setTitle("Nachhilfe SMÜ");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Login");
        label.setBounds(155, 70, 200, 50);
        label.setFont(new Font("Arial", Font.PLAIN, 30));
        add(label);

        JTextField email = new JTextField("Email: ");
        email.setBounds(90, 120, 200, 30);
        add(email);

        JTextField passwort = new JTextField("Passwort: ");
        passwort.setBounds(90, 160, 200, 30);
        add(passwort);

        JButton ok = new JButton("OK");
        ok.setBounds(155, 200, 70, 30);
        add(ok);

        setVisible(true);
    }
}
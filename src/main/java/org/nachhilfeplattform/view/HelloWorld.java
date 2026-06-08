package org.nachhilfeplattform.view;
import javax.swing.*;
import java.awt.Font;

public class HelloWorld {
   
    // Your program begins with a call to main()
    public static void main(String[] args)
    {
        Runnable guiCreator = new Runnable(){
            public void run() {
                JFrame fenster = new JFrame("Nachhilfe SMÜ Login");
                fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                fenster.setLayout(null);
                fenster.setSize(400,400);
                fenster.setVisible(true);
                fenster.setLocationRelativeTo(null);
                JLabel label = new JLabel("Login");
                label.setBounds(155, 70, 200, 50);
                label.setFont(new Font ("Arial", Font.PLAIN, 30));
                fenster.add(label);
                JTextField email = new JTextField("E-Mail:");
                email.setBounds(90,120,200,30);
                fenster.add(email);
                JTextField passwort = new JTextField("Passwort:");
                passwort.setBounds(90,160,200,30);
                fenster.add(passwort);
                JButton ok = new JButton("OK");
                ok.setBounds(155,200,70,30);
                fenster.add(ok);

                JFrame fenster1 = new JFrame("Nachhilfe SMÜ");
                fenster1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                fenster1.setLayout(null);
                fenster1.setSize(500,500);
                fenster1.setVisible(true);
                fenster1.setLocationRelativeTo(null);
                JTextField suche = new JTextField("Suche:");
                suche.setBounds(80,40,250,30);
                fenster1.add(suche);
                JButton suche1 = new JButton("Ok");
                suche1.setBounds(360,40,80,30);
                fenster1.add(suche1);
            }
        };
        SwingUtilities.invokeLater(guiCreator);
    }
}
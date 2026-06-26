package org.nachhilfeplattform.util;

import javax.swing.*;
import java.awt.*;

public class AkkordeonPanel extends JPanel {

    private boolean expanded = false;

    private final JButton arrowButton;
    private final JPanel contentPanel;

    public AkkordeonPanel(String titel) {

        setLayout(new BorderLayout());
        setAlignmentX(Component.LEFT_ALIGNMENT);

        // =====================
        // Kopf
        // =====================

        arrowButton = new JButton("+");
        arrowButton.setFont(new Font("Arial", Font.BOLD, 14));
        arrowButton.setBorderPainted(false);
        arrowButton.setFocusPainted(false);
        arrowButton.setContentAreaFilled(false);

        JLabel titelLabel = new JLabel(titel);
        titelLabel.setFont(new Font("Arial", Font.BOLD, 10));

        JPanel header = new JPanel(new BorderLayout());
        header.add(arrowButton, BorderLayout.WEST);
        header.add(titelLabel, BorderLayout.CENTER);

        // =====================
        // Inhalt
        // =====================

        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setVisible(false);

        add(header, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);

        // =====================
        // Auf-/Zuklappen
        // =====================

        arrowButton.addActionListener(e -> {

            expanded = !expanded;

            contentPanel.setVisible(expanded);

            arrowButton.setText(expanded ? "-" : "+");

            Window window = SwingUtilities.getWindowAncestor(this);

            if (window != null) {
                window.revalidate();
                window.repaint();
            }

        });
    }

    protected JPanel createRow(String text, AbstractButton button) {

        JPanel row = new JPanel(new BorderLayout());

        row.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        row.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 15));

        row.add(new JLabel(text), BorderLayout.WEST);
        row.add(button, BorderLayout.EAST);

        return row;
    }

    protected JPanel getContentPanel() {
        return contentPanel;
    }

}
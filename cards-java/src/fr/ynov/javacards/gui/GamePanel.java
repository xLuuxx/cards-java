package fr.ynov.javacards.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GamePanel {
    private JPanel panel;

    public GamePanel(ActionListener listener) {
        panel = new JPanel();
        panel.setLayout(new GridLayout(1, 6));

        CardButton cardButton = new CardButton();}

    public JPanel getPanel() {
        return panel;
    }

}

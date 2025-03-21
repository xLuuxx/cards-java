package fr.ynov.javacards.gui;

import fr.ynov.javacards.cards.Card;
import fr.ynov.javacards.cards.CardType;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;


public class CardButton {
    private final Map<String, JButton> buttonMap = new HashMap<>();



    public void removeButton(String cardName, JPanel buttonPanel) {
        JButton button = buttonMap.remove(cardName);
        if (button != null) {
            buttonPanel.remove(button);
            buttonPanel.revalidate();
            buttonPanel.repaint();
        }
    }

    // Add the buttons to the panel
    public void addButton(JPanel buttonPanel, ActionListener cardListener, Card card) {
        JButton button = new JButton(card.getCardName());
        button.addActionListener(cardListener);
        button.setActionCommand(card.getCardName());
        buttonPanel.add(button);
        buttonMap.put(card.getCardName(), button);
        buttonPanel.revalidate();
        buttonPanel.repaint();
    }
}


package fr.ynov.javacards.gui;

import fr.ynov.javacards.cards.Card;
import fr.ynov.javacards.game.TurnLogic;
import fr.ynov.javacards.players.Computer;
import fr.ynov.javacards.players.Student;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameFrame {
    private final TurnLogic gameLogic;
    private final JLabel computerPlayedLabel;
    private final JPanel buttonPanel;


    // Contains most of the logic for the game and the GUI
    public GameFrame() {
        JFrame frame = new JFrame("Card Game");
        frame.setResizable(true);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Shut down the program when window closes


        buttonPanel = new JPanel();
        CardButton cardButton = new CardButton();


        // Init cards to the player and add a studentPlayer and a computerPlayer
        Student studentPlayer = new Student("PlayerName", 6, new ArrayList<>());
        studentPlayer.initiateCards();
        Computer computerPlayer = new Computer("Computer", 6, new ArrayList<>());
        computerPlayer.initiateCards();
        gameLogic = new TurnLogic(studentPlayer, computerPlayer);
        gameLogic.setStudentPlayer(studentPlayer);
        gameLogic.setComputerPlayer(computerPlayer);


        // Visual text on the GUI window
        computerPlayedLabel = new JLabel("The computer played: ");
        frame.add(computerPlayedLabel, BorderLayout.SOUTH);

        JLabel studentPlayedLabel = new JLabel("You can play: ");
        frame.add(studentPlayedLabel, BorderLayout.NORTH);


        // Add the buttons to the GUI

        ActionListener cardListener = e -> {
            String cardName = e.getActionCommand();
            int cardIndex = -1;
            for (int i = 0; i < studentPlayer.getCardsInHands().size(); i++) {
                if (studentPlayer.getCardsInHands().get(i).getCardName().equals(cardName)) {
                    cardIndex = i;
                    break;
                }
            }
            cardButton.removeButton(cardName, buttonPanel);

            Card computerCard = gameLogic.computeTurn(cardIndex);
            computerPlayedLabel.setText("Computer played: " + computerCard.getCardName()); // Show what the computer plays

            // Check if anyone won.
            if (gameLogic.isItLoose(studentPlayer)) {
                JOptionPane.showMessageDialog(frame, "You lost!.");
            } else if (gameLogic.isItLoose(computerPlayer)) {
                JOptionPane.showMessageDialog(frame, "You won!.");
            }
        };
        // Add buttons for each card
        for (Card card : studentPlayer.getCardsInHands()) {
            cardButton.addButton(buttonPanel, cardListener, card);
        }

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}

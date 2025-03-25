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
    private TurnLogic gameLogic;
    private JLabel computerPlayedLabel;
    private JPanel buttonPanel;
    private JLabel studentScoreLabel;
    private JLabel computerScoreLabel;


    public GameFrame() {
        initializeGame();
    }
    // Contains most of the logic for the game and the GUI
    public void initializeGame() {
        JFrame frame = new JFrame("Card Game");
        frame.setResizable(false);
        frame.setSize(500, 400);
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

        studentScoreLabel = new JLabel("Student Score : " + studentPlayer.getScore());
        computerScoreLabel = new JLabel("Computer Score : " + computerPlayer.getScore());
        JPanel scorePanel = new JPanel();
        scorePanel.add(studentScoreLabel);
        scorePanel.add(computerScoreLabel);
        frame.add(studentScoreLabel, BorderLayout.WEST);
        frame.add(computerScoreLabel, BorderLayout.EAST);


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

            // Shows what are the scores of the players
            studentScoreLabel.setText("Student Score: " + studentPlayer.getScore());
            computerScoreLabel.setText("Computer Score: " + computerPlayer.getScore());

            // Check if anyone won.
            if (gameLogic.isItLoose(studentPlayer)) {
                JOptionPane.showMessageDialog(frame, "You won!.");
                frame.dispose();
                initializeGame();
            } else if (gameLogic.isItLoose(computerPlayer)) {
                JOptionPane.showMessageDialog(frame, "You lost!.");
                frame.dispose();
                initializeGame();
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

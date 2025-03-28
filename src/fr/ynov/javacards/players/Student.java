package fr.ynov.javacards.players;

import fr.ynov.javacards.cards.Card;
import fr.ynov.javacards.gui.CardButton;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Student extends Player {
    public Student(String playersName, int numberOfCards, List<Card> cardsInHands) {
        //SUPER constructor since it extends to the mother class.
        super(playersName, numberOfCards, cardsInHands);
    }


    // Allow the student to play a card.
    public Card studentPlays(int index) {
        if (index < 0 || index >= cardsInHands.size()) {
            System.err.println("Invalid card choice: " + index);
            return null;
        }
        Card playedCard = bePlayed(index);
        System.out.println("Student decided to play: " + playedCard.getCardName());
        return playedCard;
    }
}
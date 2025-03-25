package fr.ynov.javacards.players;

import fr.ynov.javacards.cards.Card;
import fr.ynov.javacards.cards.CardType;
import fr.ynov.javacards.gui.CardButton;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;

public class Player {
    String playersName; // what is the player's name ?
    List<Card> cardsInHands;
    int numberOfCards; // how many cards does the players has : useful for the winning condition.
    private int score; // the player's score



    //CONSTRUCTOR
        public Player(String playersName, int numberOfCards, List<Card> cardsInHands) {
            this.playersName = playersName;
            this.cardsInHands = cardsInHands;
            this.numberOfCards = numberOfCards;
        }

    //Allow to play the card and to remove it
    public Card bePlayed(int index) {
        try {
            if (index >= 0 && index < cardsInHands.size()) {
                Card playedCard = cardsInHands.remove(index);
                numberOfCards--;
                return playedCard;
            } else {
                throw new IndexOutOfBoundsException("Card index out of bounds: " + index); // Exception to deal with the out of bounds error.
            }
        } catch (IndexOutOfBoundsException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }


    // Give the players 6 basic cards
    public void initiateCards() {
        cardsInHands.add(new Card(CardType.KING, "KING"));
        cardsInHands.add(new Card(CardType.QUEEN, "QUEEN"));
        cardsInHands.add(new Card(CardType.VALET, "VALET"));
        cardsInHands.add(new Card(CardType.TEN, "TEN"));
        cardsInHands.add(new Card(CardType.NINE, "NINE"));
        cardsInHands.add(new Card(CardType.EIGHT, "EIGHT"));
        cardsInHands.add(new Card(CardType.SEVEN, "SEVEN"));
        cardsInHands.add(new Card(CardType.SIX, "SIX"));
        cardsInHands.add(new Card(CardType.FIVE, "FIVE"));
        cardsInHands.add(new Card(CardType.FOUR, "FOUR"));
        cardsInHands.add(new Card(CardType.THREE, "THREE"));
        cardsInHands.add(new Card(CardType.TWO, "TWO"));
        cardsInHands.add(new Card(CardType.ACE, "ACE"));
        numberOfCards += 14;
    }

    public void addScore(int score) {
        this.score ++;
    }

    // GETTER AND SETTER
    public List<Card> getCardsInHands() {
        return cardsInHands;
    }

    public int getScore() {
        return score;
    }
}



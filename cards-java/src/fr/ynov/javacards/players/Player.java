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
        numberOfCards += 6;
    }


    // Allow to add two cards once the player round is won
public void addTwoCards(Card card, Card card2) {
    cardsInHands.add(card);
    cardsInHands.add(card2);
    numberOfCards += 2;
}

    // GETTER AND SETTER
    public String getPlayersName() {
        return playersName;
    }

    public void setPlayersName(String playersName) {
        this.playersName = playersName;
    }

    public List<Card> getCardsInHands() {
        return cardsInHands;
    }

    public int getNumberOfCards() {
        return numberOfCards;
    }

    public void setNumberOfCards(int numberOfCards) {
        this.numberOfCards = numberOfCards;
    }
}

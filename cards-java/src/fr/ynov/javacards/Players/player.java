package fr.ynov.javacards.Players;

import java.util.List;

public class player {
    String playersName; // what is the player's name ?
    List<String> cardsInHands;
    int numberOfCards; // how many cards does the players has : useful for the winning condition.



    //CONSTRUCTOR
     public player(String playersName, int numberOfCards, List<String> cardsInHands) {
        this.playersName = playersName;
        this.cardsInHands = cardsInHands;
        this.numberOfCards = numberOfCards;
    }

    //Allow to play the card and to remove it
    public String bePlayed(int index) {
        if (index >= 0 && index < 6) {
            String playedCard = cardsInHands.remove(index);
            numberOfCards--;
            return playedCard;
        }
        return null; // OR EXCEPTION???!!!
    }

    // Allow to add two cards once the round is won
    public void beAdded(String card1, String card2) {
        cardsInHands.add(card1);
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

    public List<String> getCardsInHands() {
        return cardsInHands;
    }

    public void setCardsInHands(List<String> cardsInHands) {
        this.cardsInHands = cardsInHands;
    }

    public int getNumberOfCards() {
        return numberOfCards;
    }

    public void setNumberOfCards(int numberOfCards) {
        this.numberOfCards = numberOfCards;
    }
}

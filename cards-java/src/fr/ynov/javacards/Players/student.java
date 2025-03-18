package fr.ynov.javacards.Players;

import java.util.List;

public class student extends player {
    public student(String playersName, int numberOfCards, List<String> cardsInHands) {
        //SUPER constructor since it extends to the mother class.
        super(playersName, numberOfCards, cardsInHands);
    }

    // Allow the student to play a card.
    public String studentPlays(int index) {
        return bePlayed(index);
    }
}

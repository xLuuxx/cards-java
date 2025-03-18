package fr.ynov.javacards.Players;

import java.util.List;
import java.util.Random;

public class computer extends player {
    public computer(String playersName, int numberOfCards, List<String> cardsInHands) {
        // SUPER constructor since it extends to the mother class.
        super(playersName, numberOfCards, cardsInHands);
    }

    // The computer takes a random card from which he has and plays it.
    private void computerPlays() {
        Random random = new Random();
        int index = random.nextInt(cardsInHands.size());
        String playedCard = bePlayed(index);
        System.out.println("Computer played : " + playedCard);

    }
}
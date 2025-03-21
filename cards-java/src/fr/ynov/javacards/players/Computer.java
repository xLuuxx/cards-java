package fr.ynov.javacards.players;

import fr.ynov.javacards.cards.Card;
import fr.ynov.javacards.cards.CardType;

import java.util.List;
import java.util.Random;

public class Computer extends Player {
    CardType lastPlayedCard = null;

    public Computer(String playersName, int numberOfCards, List<Card> cardsInHands) {
        // SUPER constructor since it extends to the mother class.
        super(playersName, numberOfCards, cardsInHands);
    }

    // The computer takes a random card from which he has and plays it.
    public Card computerPlays() {
        if (cardsInHands.isEmpty()) {
            throw new IllegalStateException("No cards to play dumbass.");
        }


        Random random = new Random();
        int randomIndex = random.nextInt(cardsInHands.size());
        Card computerCard = cardsInHands.get(randomIndex);
        cardsInHands.remove(computerCard);

        return computerCard;
    }
}

package fr.ynov.javacards.game;

import fr.ynov.javacards.cards.Card;


public class CardLogic {
    public static int isItStronger(Card Card1, Card Card2) {
        // Methods who check which card is stronger to determine who win.
        int strength1 = (Card1).getStrength();
        int strength2 = (Card2).getStrength();

        if (strength1 > strength2) {
            return 1;
        } else if (strength1 < strength2) {
            return 2;
        } else {
            return 3;
        }
    }
}

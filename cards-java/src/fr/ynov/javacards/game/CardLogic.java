package fr.ynov.javacards.game;

import fr.ynov.javacards.cards.Card;


public class CardLogic {
    // Methods who check which card is stronger to determine who win.
    public static boolean isItStronger(Card Card1, Card Card2) {
    int strength1 = (Card1).getStrength();
    int strength2 = (Card2).getStrength();

    if (strength1 > strength2) {
        return true;
    }
    return false;
    }
}

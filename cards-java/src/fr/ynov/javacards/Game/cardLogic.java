package fr.ynov.javacards.Game;

import fr.ynov.javacards.Cards.card;


public class cardLogic {
    public boolean isItStronger(card card1, card card2) {
    int strength1 = (card1).getStrength();
    int strength2 = (card2).getStrength();

    if (strength1 > strength2) {
        return true;
    }
    return false;
    }
}

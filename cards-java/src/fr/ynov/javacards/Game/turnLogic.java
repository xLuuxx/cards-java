package fr.ynov.javacards.Game;

import fr.ynov.javacards.Players.player;

public class turnLogic {
    public boolean loose(player player) {
        if (player.getNumberOfCards() == 0) {
            return true;
        }
        return false;
    }
}

package fr.ynov.javacards.Cards;


public enum cardType {
    // Give each card a number value and compares it in the isItStronger methods to determine which one beats the other.
    KING(13),
    QUEEN(12),
    VALET(11),
    TEN(10),
    NINE(9),
    EIGHT(8);

    final int value;

    cardType(int value) {
        this.value = value;
    }
}

package fr.ynov.javacards.cards;


public enum CardType {
    // Give each card a number value and compares it in the isItStronger methods to determine which one beats the other.
    KING(13),
    QUEEN(12),
    VALET(11),
    TEN(10),
    NINE(9),
    EIGHT(8);

    final int value;

    CardType(int value) {
        this.value = value;
    }
}

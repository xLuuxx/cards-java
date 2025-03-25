package fr.ynov.javacards.cards;

public class Card {
    CardType type; // is it a head or a number kind of cards ?
    String cardName;

    //CONSTRUCTOR
    public Card(CardType type, String cardName) {
        this.type = type;
        this.cardName = cardName;
    }

    //GETTER AND SETTER
    public int getStrength() {
        return type.value;
    }

    public String getCardName() {
        return cardName;
    }
}
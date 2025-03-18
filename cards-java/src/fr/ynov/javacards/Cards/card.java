package fr.ynov.javacards.Cards;

public class card {
    cardType type; // is it a head or a number kind of cards ?
    String cardName;

    //CONSTRUCTOR
    public card(cardType type, String cardName) {
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

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
}
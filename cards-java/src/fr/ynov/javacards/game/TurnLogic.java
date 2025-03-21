package fr.ynov.javacards.game;

import fr.ynov.javacards.cards.Card;
import fr.ynov.javacards.players.Computer;
import fr.ynov.javacards.players.Player;
import fr.ynov.javacards.players.Student;

import static fr.ynov.javacards.game.CardLogic.isItStronger;

public class TurnLogic {
    private Student StudentPlayer;
    private Computer ComputerPlayer;

    // Constructor
    public TurnLogic(Student StudentPlayer, Computer ComputerPlayer) {
        this.StudentPlayer = StudentPlayer;
        this.ComputerPlayer = ComputerPlayer;
    }

    // Compute the turn
    public Card computeTurn(int studentCardIndex) {
        Card studentCard = studentTurn(studentCardIndex);
        Card computerCard = computerTurn();
        boolean isItStronger = isItStronger(studentCard, computerCard);

        if (isItStronger) {
            StudentPlayer.addTwoCards(studentCard, computerCard);
        } else {
            ComputerPlayer.addTwoCards(computerCard, studentCard);
        }

        return computerCard;
    }


    // Check the loose condition
    public boolean isItLoose(Player player) {
        if (player.getNumberOfCards() == 0) {
            return true;
        }
        return false;
    }

    // Handle the student turn in play
    public Card studentTurn(int cardIndex) {
       return StudentPlayer.studentPlays(cardIndex);
    }

    // Handle the computer turn in play
    public Card computerTurn() {
        return ComputerPlayer.computerPlays();
    }

    // GETTER AND SETTER
    public Student getStudentPlayer() {
        return StudentPlayer;
    }

    public void setStudentPlayer(Student StudentPlayer) {
        this.StudentPlayer = StudentPlayer;
    }

    public Computer getComputerPlayer() {
        return ComputerPlayer;
    }

    public void setComputerPlayer(Computer ComputerPlayer) {
        this.ComputerPlayer = ComputerPlayer;
    }
}

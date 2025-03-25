package fr.ynov.javacards.game;

import fr.ynov.javacards.cards.Card;
import fr.ynov.javacards.players.Computer;
import fr.ynov.javacards.players.Player;
import fr.ynov.javacards.players.Student;

import static fr.ynov.javacards.game.CardLogic.isItStronger;

public class TurnLogic {
    private Student studentPlayer;
    private Computer computerPlayer;

    // CONSTRUCTOR
    public TurnLogic(Student studentPlayer, Computer computerPlayer) {
        this.studentPlayer = studentPlayer;
        this.computerPlayer = computerPlayer;
    }

    // Compute the turn
    public Card computeTurn(int studentCardIndex) {
        Card studentCard = studentTurn(studentCardIndex);
        Card computerCard = computerTurn();
        int comparisonResult = isItStronger(studentCard, computerCard);

        // Handle the comparison result
                switch (comparisonResult) {
                    case 1 : studentPlayer.addScore(studentPlayer.getScore()+1);
                    break;
                    case 2 : computerPlayer.addScore(computerPlayer.getScore()+1);
                    break;
                    case 3 :
                        studentPlayer.addScore(studentPlayer.getScore() + 1);
                        computerPlayer.addScore(computerPlayer.getScore() + 1);
                        break;
                }
        return computerCard;
    }


// handle the winning condition
    public boolean isItLoose(Player player) {
        if (player.getScore() == 7) {
            return true;
        }
        return false;
    }

    // Handle the student turn in play
    public Card studentTurn(int cardIndex) {
       return studentPlayer.studentPlays(cardIndex);
    }

    // Handle the computer turn in play
    public Card computerTurn() {
        return computerPlayer.computerPlays();
    }

    // GETTER AND SETTER
    public void setStudentPlayer(Student StudentPlayer) {
        this.studentPlayer = StudentPlayer;
    }

    public void setComputerPlayer(Computer ComputerPlayer) {
        this.computerPlayer = ComputerPlayer;
    }
}

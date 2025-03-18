package fr.ynov.javacards.Game;

import fr.ynov.javacards.Players.student;
import fr.ynov.javacards.Players.computer;

public class gameLogic {
    private student studentPlayer;
    private computer computerPlayer;

    // CONSTRUCTOR
    public gameLogic(student studentPlayer, computer computerPlayer) {
        this.studentPlayer = studentPlayer;
        this.computerPlayer = computerPlayer;
    }

    // GETTER AND SETTER
    public student getStudentPlayer() {
        return studentPlayer;
    }

    public void setStudentPlayer(student studentPlayer) {
        this.studentPlayer = studentPlayer;
    }

    public computer getComputerPlayer() {
        return computerPlayer;
    }

    public void setComputerPlayer(computer computerPlayer) {
        this.computerPlayer = computerPlayer;
    }
}

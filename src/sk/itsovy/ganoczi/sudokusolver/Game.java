package sk.itsovy.ganoczi.sudokusolver;

import sk.itsovy.ganoczi.sudokusolver.model.Board;

public class Game {

    private Board board;
    private boolean state;

    public Game(Board board, boolean state) {
        this.board = board;
        this.state = state;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}

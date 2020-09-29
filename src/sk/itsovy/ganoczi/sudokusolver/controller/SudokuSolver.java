package sk.itsovy.ganoczi.sudokusolver.controller;

import sk.itsovy.ganoczi.sudokusolver.Data;
import sk.itsovy.ganoczi.sudokusolver.model.Board;

public class SudokuSolver {

    private int arr[][];
    private Board board;
    private Data data;


    public Board getBoard() {
        return board;
    }

    public void start(){
        if (readData()==false){
            System.out.println("data source failed");
        }
        board= new Board(arr);
    }

    public boolean readData(){
        arr=new Data().getData();
        return true;
    }

    public void reduceAvailableValues(){
        reduceInCol();
        reduceInRow();
        reduceInSquare();
    }


    public void reduceInCol(){
        for (int i=0; i<board.getTiles().length; i++){
            for (int j=0; j<board.getTiles().length; j++){
                if (board.getTiles()[i][j].getAvailable() != null){
                    for (int k=0; k<board.getTiles().length; k++){
                        if (board.getTiles()[k][j].getValue() > 0){
                            board.getTiles()[i][j].remove(board.getTiles()[k][j].getValue());
                        }
                    }
                }
            }
        }
    }

    public void reduceInRow(){
        for (int i = 0; i < board.getTiles().length; i++) {
            for (int j = 0; j < board.getTiles().length; j++) {
                if (board.getTiles()[i][j].getAvailable() != null) {
                    for (int k = 0; k < board.getTiles().length; k++) {
                        if (board.getTiles()[i][k].getValue() > 0) {
                            board.getTiles()[i][j].remove(board.getTiles()[i][k].getValue());
                        }
                    }
                }
            }
        }
    }

    public void reduceInSquare(){
        int k=0, l=0, m=0, n=0;
        for (int i=0; i<board.getTiles().length; i+=3){
            for (int j=0; j<board.getTiles().length; j+=3){
                for (k+=i; k<i+3; k++) {
                    for (l+=j; l<j+3; l++) {
                        if (board.getTiles()[k][l].getAvailable() == null) {
                            for (m+=i; m<i+3; m++) {
                                for (n+=j; n<j+3; n++) {
                                    if (board.getTiles()[m][n].getAvailable() != null) {
                                        board.getTiles()[m][n].remove(board.getTiles()[k][l].getValue());
                                    }
                                }
                                n=0;
                            }
                            m=0;
                        }
                    }
                    l=0;
                }
                k=0;
            }
        }
    }

    public boolean isComplete(){
        for (int i=0; i<board.getTiles().length; i++){
            for (int j=0; j<board.getTiles().length; j++){
                if (board.getTiles()[i][j].getValue() == 0){
                    return false;
                }
            }
        }
        return true;
    }

    public void assignNumber(){
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                if (board.getTiles()[i][j].getAvailable()!=null && board.getTiles()[i][j].getAvailable().size()==1){
                    board.getTiles()[i][j].setValue(board.getTiles()[i][j].getAvailable().iterator().next());
                    board.getTiles()[i][j].remove(board.getTiles()[i][j].getValue());
                }
            }
        }
    }

}

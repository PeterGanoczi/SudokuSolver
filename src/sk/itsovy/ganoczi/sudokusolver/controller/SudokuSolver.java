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

    }

    public void reduceInRow(){

    }

    public void reduceInSquare(){

    }

}

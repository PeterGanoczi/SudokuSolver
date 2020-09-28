package sk.itsovy.ganoczi.sudokusolver;

import sk.itsovy.ganoczi.sudokusolver.controller.SudokuSolver;
import sk.itsovy.ganoczi.sudokusolver.model.Board;
import sk.itsovy.ganoczi.sudokusolver.view.View;

public class Main {
    public static void main(String[] args) {


       Data data=new Data();
       View view =new View();
        Board board=new Board(data.getData());
       SudokuSolver sdk=new SudokuSolver();
       view.printBoard(board.getTiles());




    }
}

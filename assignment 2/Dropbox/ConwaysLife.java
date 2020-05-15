/*
* [ConwaysLife Class]
*
* COMP 1020 SECTION [A03]
* INSTRUCTOR: [Amir Memar]
* NAME: [Xichen HE]
* ASSIGNMENT: [Assignment 2]
* QUESTION: [question 3]
*
* PuRPOSE: implement a simulation of Conway's game of Life:
*          +constructors: one is used to build the board with specific size and density; another is used to read a file to get initial board.
*          -countNeighbours(int,int): int
*          +nextGeneration(): void
*/
/**
 * COMP 1020 Winter 2016
 * (C) Computer Science, University of Manitoba
 * Implement a simulation of John Conway's Game of Life
 */
import java.io.*;
import java.util.Scanner;

public class ConwaysLife {

    //---------  Instance variables  -------------------------
    private int boardSize;
    private boolean[][] board;
    private boolean[][] nextBoard; //Used to calculate the next generation

    //---------  Constructors  --------------------------------
    public ConwaysLife(int size, double density) {
        this.boardSize = size;
        board = new boolean[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = (Math.random() < density);
            }/*random() is within[0,1), comparing with density to get true or false */
        }//initialize board array with random cells
        nextBoard = new boolean[boardSize][boardSize];
    }//constructor 1

    public ConwaysLife(File chosenFile) {
        try {
            Scanner readFile = new Scanner(chosenFile);//open input file
            String size = readFile.nextLine();//read the first row
            this.boardSize = Integer.parseInt(size);//convert the number at the first line from String to int
            board = new boolean[boardSize][boardSize];
            nextBoard = new boolean[boardSize][boardSize];
            while (readFile.hasNextLine()) {
                for (int i = 0; i < boardSize; i++) {
                    String line = readFile.nextLine();//read from the second row
                    for (int j = 0; j < boardSize; j++) {
                        if (line.charAt(j) == 'X') {
                            board[i][j] = true;
                        }//if 
                        else {
                            board[i][j] = false;
                        }//else
                    }//for loop: column
                }//for loop: row
            }//while loop
            readFile.close();
        } catch (IOException io) {
            io.getMessage();
        }
    }//constructor 2

    //----------------  Calculate the next generation -----------------
    public void nextGeneration() {
        //Generate nextBoard from board (get the next generation)
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                int life = countNeighbours(i, j);//call countNeighbours method to count surrounding
                //apply the rules
                if (life <= 1 || life >= 4) {
                    nextBoard[i][j] = false;
                }//die of lonelyness or overcrowding
                if (board[i][j] == true && life == 2) {
                    nextBoard[i][j] = true;
                }//stay alive
                if (life == 3) {
                    nextBoard[i][j] = true;
                }//stay alive or become alive
            }//for loop: column
        }//for loop: row
        //Swap the two boards so that the next generation becomes the board
        boolean[][] temp = board;
        board = nextBoard;
        nextBoard = temp;
    }//nextGeneration method: fill up the nextBoard array to respresent the next generation as per the rules

    private int countNeighbours(int row, int col) {
        int countLife = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            if (i < 0 || i > boardSize - 1) {
                continue;
            }//if any row is out of the boundry, consider the next row
            for (int j = col - 1; j <= col + 1; j++) {
                if (j < 0 || j > boardSize - 1) {
                    continue;
                }//if any column is out of the boundry, consider the next column
                if (i == row && j == col) {
                    continue;
                }//if row and column are equal to the input param, means it is the cell that we are counting it's around, do not count it
                if (board[i][j] == true) {
                    countLife++;
                }
            }//for loop: column
        }//for loop: row
        return countLife;
    }//countNeighbours method: counting the num of living cells around the cell at the given position

    //---------------- draw method --------------------------------- 
    public void draw() {
        //Draw the board using StdDraw graphics
        for (int i = 0; i <= boardSize; i++) {
            StdDraw.line(0, (double) i / boardSize, 1, (double) i / boardSize);
            StdDraw.line((double) i / boardSize, 0, (double) i / boardSize, 1);
        }
        for (int r = 0; r < boardSize; r++) {
            for (int c = 0; c < boardSize; c++) {
                if (board[r][c]) {
                    StdDraw.filledCircle((2 * c + 1) / (2.0 * boardSize),
                            1.0 - (2 * r + 1) / (2.0 * boardSize),
                            1 / (2.0 * boardSize));
                }
            }
        }
    }//draw

    //-------------  toString method  --------------------
    public String toString() {
        String result = "";
        for (int r = 0; r < boardSize; r++) {
            for (int c = 0; c < boardSize; c++) {
                if (board[r][c]) {
                    result += 'X';
                } else {
                    result += '.';
                }
            }
            result += '\n';
        }
        return result;
    }//toString

}//ConwaysLife class

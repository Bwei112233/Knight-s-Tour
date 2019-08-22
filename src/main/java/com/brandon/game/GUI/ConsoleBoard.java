package com.brandon.game.GUI;

import java.util.Arrays;
import java.util.Scanner;
import com.brandon.game.Pieces.*;

public class ConsoleBoard {
    private char rows[][];

    public char[][] getRows() {
        return rows;
    }

    public ConsoleBoard(int row, int col){
        rows = buildBoard(row, col);
    }

    public void addPiece(Knight knight){
        rows[knight.getRowLocation()][knight.getColLocation()] = 'D';
    }

    private char[][] buildBoard(int row, int col) {
        char[][] board = new char[row + 1][col + 1];
        board[0][0] = ' ';
        char c = 'a';
        for(int i = 1; i < board[0].length; i++){
            board[0][i] = c;
            c++;
        }
        char colIndex = '1';
        for(int rows = 1; rows < board.length; rows++){
            for(int cols = 0; cols < board[0].length; cols++){
                if(rows == 0 && cols == 0){
                    board[rows][cols] = ' ';
                    continue;
                }
                if(cols == 0){
                    board[rows][cols] = colIndex;
                    colIndex++;
                }
                else{
                    board[rows][cols] = '-';
                }
            }
        }
        return board;
    }

    public static ConsoleBoard setUpBoard(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of rows");
        String rows = scanner.nextLine();
        System.out.println("Enter number of columns");
        String cols = scanner.nextLine();
        ConsoleBoard consoleBoard = new ConsoleBoard(Integer.parseInt(rows), Integer.parseInt(cols));
        return consoleBoard;
    }

    public void printBoard(){
        for(char[] c: rows){
            System.out.println(Arrays.toString(c));
        }
    }
}

package com.brandon.game.Pieces;

import java.util.ArrayList;
import java.util.List;

import com.brandon.game.GUI.ConsoleBoard;

public class Knight {
    List<List<Integer>> possibleMoves;
    private int colLocation;
    private int rowLocation;

    public Knight(int widthLocation, int hieghtLocation) {
        this.rowLocation = hieghtLocation;
        this.colLocation = widthLocation;
    }

    public void moveKnight(int moveHorizontal, int moveVertical) {

        colLocation += moveHorizontal;
        rowLocation += moveVertical;
    }

    public void moveKnight(String move, char[][] rows, Knight knight) {
        int cols = (int) move.charAt(0) - 96;
        int row = Integer.parseInt(move.substring(1));
        rows[row][cols] = 'D';
        knight.setRowLocation(row);
        knight.setColLocation(cols);
    }

    public boolean isValidMove(String move, int rowLocation, int colLocation, char[][] rows) {
        int cols = (int) move.charAt(0) - 96;
        int row = Integer.parseInt(move.substring(1));
        if (Math.abs(cols - colLocation) == 2 && Math.abs(rowLocation - row) == 1 && rows[rowLocation][colLocation] != '0') {
            if (rowLocation >= 1 && rowLocation < rows.length && colLocation >= 1 && colLocation < rows[0].length) {
                return true;
            }
        }
        if (Math.abs(cols - colLocation) == 1 && Math.abs(rowLocation - row) == 2 && rows[rowLocation][colLocation] != '0') {
            if (rowLocation >= 1 && rowLocation < rows.length && colLocation >= 1 && colLocation < rows[0].length) {
                return true;
            }
        }
        return false;
    }

    public List<List<Integer>> getPossibleMoves(char[][] board) {
        possibleMoves = new ArrayList<List<Integer>>();
        List<Integer> move = new ArrayList<Integer>();

        if (this.rowLocation + 2 <= board.length - 1 && this.colLocation + 1 <= board[0].length - 1
                && board[rowLocation + 2][colLocation + 1] != '0') {
            move.add(this.rowLocation + 2);
            move.add(this.colLocation + 1);
            possibleMoves.add(new ArrayList<>(move));
            move.clear();
        }
        if (this.rowLocation + 2 <= board.length - 1 && this.colLocation - 1 >= 1
                && board[rowLocation + 2][colLocation - 1] != '0') {
            move.add(this.rowLocation + 2);
            move.add(this.colLocation - 1);
            possibleMoves.add(new ArrayList<>(move));
            move.clear();
        }
        if (this.rowLocation + 1 <= board.length - 1
                && this.colLocation + 2 <= board[0].length - 1
                && board[rowLocation + 1][colLocation + 2] != '0') {
            move.add(this.rowLocation + 1);
            move.add(this.colLocation + 2);
            possibleMoves.add(new ArrayList<>(move));
            move.clear();
        }
        if (this.rowLocation - 1 >= 1 && this.colLocation + 2 <= board[0].length - 1
                && board[rowLocation - 1][colLocation + 2] != '0') {
            move.add(this.rowLocation - 1);
            move.add(this.colLocation + 2);
            possibleMoves.add(new ArrayList<>(move));
            move.clear();
        }
        if (this.rowLocation - 1 >= 1 && this.colLocation - 2 >= 1
                && board[rowLocation - 1][colLocation - 2] != '0') {
            move.add(this.rowLocation - 1);
            move.add(this.colLocation - 2);
            possibleMoves.add(new ArrayList<>(move));
            move.clear();
        }
        if (this.rowLocation - 2 >= 1 && this.colLocation - 1 >= 1
                && board[rowLocation - 2][colLocation - 1] != '0') {
            move.add(this.rowLocation - 2);
            move.add(this.colLocation - 1);
            possibleMoves.add(new ArrayList<>(move));
            move.clear();
        }
        if (this.rowLocation - 2 >= 1 && this.colLocation + 1 <= board[0].length - 1 &&
                board[rowLocation - 2][colLocation + 1] != '0') {
            move.add(this.rowLocation - 2);
            move.add(this.colLocation + 1);
            possibleMoves.add(new ArrayList<>(move));
            move.clear();
        }
        if (this.rowLocation + 1 <= board.length - 1 && this.colLocation - 2 >= 1 &&
                board[rowLocation + 1][colLocation - 1] != '0') {
            move.add(this.rowLocation + 1);
            move.add(this.colLocation - 2);
            possibleMoves.add(new ArrayList<>(move));
            move.clear();
        }
        return possibleMoves;
    }

    public int getColLocation() {
        return colLocation;
    }

    public int getRowLocation() {
        return rowLocation;
    }

    public void setColLocation(int colLocation) {
        this.colLocation = colLocation;
    }

    public void setRowLocation(int rowLocation) {
        this.rowLocation = rowLocation;
    }
}

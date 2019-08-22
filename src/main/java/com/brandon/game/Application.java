package com.brandon.game;
import com.brandon.game.GUI.Board;

import java.io.Console;
import java.util.List;
import java.util.Scanner;
import com.brandon.game.ConsoleDriver.Driver;
import com.brandon.game.GUI.ConsoleBoard;
import com.brandon.game.Pieces.Knight;

import static com.brandon.game.GUI.ConsoleBoard.setUpBoard;
public class Application {

    public static void main(String args[]){
        try {
            Application application = new Application();
            ConsoleBoard consoleBoard = setUpBoard();
            application.startGame(consoleBoard);
        }
        catch(IllegalArgumentException e){
            System.out.println("invalid input");
        }
        catch(Exception e){
            System.out.println("invalid row col");
        }

    }

    public void startGame(ConsoleBoard consoleBoard)
    {
        char[][] gameBoard = consoleBoard.getRows();
        Knight knight = new Knight(1,1);
        consoleBoard.addPiece(knight);
        consoleBoard.printBoard();
        printDirections();
        int moveCount = 0;
        Scanner scanner = new Scanner(System.in);
        while(moveCount <= 63) {
            List<List<Integer>> possibleMoves = knight.getPossibleMoves(gameBoard);
            System.out.println(possibleMoves.toString());
            if(possibleMoves.size() == 0){
                System.out.println("Not a valid Knight's Tour");
                System.out.println("Do you want to try again? (Y/N)");
                String response = scanner.nextLine();
                if(response.equalsIgnoreCase("Y")){
                   ConsoleBoard newConsoleBoard = setUpBoard();
                   System.gc();
                    startGame(newConsoleBoard);
                }
                else {
                    break;
                }
            }
            System.out.println("Choose a move");
            String move = scanner.nextLine();
            if (knight.isValidMove(move, knight.getRowLocation(), knight.getColLocation(), gameBoard)) {
                moveCount++;
                gameBoard[knight.getRowLocation()][knight.getColLocation()] = '0';
                knight.moveKnight(move, gameBoard, knight);
                consoleBoard.printBoard();
            } else {
                System.out.println("Invalid Move");
                consoleBoard.printBoard();
                continue;
            }
        }
    }

    private void printDirections() {
        System.out.println("choose a move using the following syntax: col (a, b, c) then row(1, 2,3)");
        System.out.println("Example: a4, d5, c2");
    }
}

package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class ticTacToe {
    public static void gameBoard() {
        int nextPlayer = 1;
        int round = 0;
        String winner = null;

        String[] board = new String[9];

        Arrays.fill(board, " ");

        boolean whichPlayerIsPlaying = false;

        do {
            round++;
            String square;
            String mark;

            if(whichPlayerIsPlaying) {
                whichPlayerIsPlaying = false;
                mark = "O";
            } else {
                whichPlayerIsPlaying = true;
                mark = "X";
            }

            System.out.println(
                "+--Tic-Tac-Toe--+\n\n"
                + "    A   B   C \n"
                + "              \n"
                + "      |   |   \n"
                + "3   " + board[6] + " | " + board[7] + " | " + board[8] + " \n"
                + "   ___|___|___\n"
                + "      |   |   \n"
                + "2   " + board[3] + " | " + board[4] + " | " + board[5] + " \n"
                + "   ___|___|___\n"
                + "      |   |   \n"
                + "1   " + board[0] + " | " + board[1] + " | " + board[2] + " \n"
                + "      |   |   \n"
            );

            square = squareChoice(whichPlayerIsPlaying);

            boolean playerTurn = true;

            while(playerTurn) {
                switch (square) {
                    case "1A":
                        if(board[0].equals(" ")) {
                            board[0] = mark;
                            playerTurn = false;
                        } else {
                            System.out.println("Square already used");
                            square = squareChoice(whichPlayerIsPlaying);
                        }
                        break;
                    case "1B":
                        if(board[1].equals(" ")) {
                            board[1] = mark;
                            playerTurn = false;
                        } else {
                            System.out.println("Square already used");
                            square = squareChoice(whichPlayerIsPlaying);
                        }
                        break;
                    case "1C":
                        if(board[2].equals(" ")) {
                            board[2] = mark;
                            playerTurn = false;
                        } else {
                            System.out.println("Square already used");
                            square = squareChoice(whichPlayerIsPlaying);
                        }
                        break;
                    case "2A":
                        if(board[3].equals(" ")) {
                            board[3] = mark;
                            playerTurn = false;
                        } else {
                            System.out.println("Square already used");
                            square = squareChoice(whichPlayerIsPlaying);
                        }
                        break;
                    case "2B":
                        if(board[4].equals(" ")) {
                            board[4] = mark;
                            playerTurn = false;
                        } else {
                            System.out.println("Square already used");
                            square = squareChoice(whichPlayerIsPlaying);
                        }
                        break;
                    case "2C":
                        if(board[5].equals(" ")) {
                            board[5] = mark;
                            playerTurn = false;
                        } else {
                            System.out.println("Square already used");
                            square = squareChoice(whichPlayerIsPlaying);
                        }
                        break;
                    case "3A":
                        if(board[6].equals(" ")) {
                            board[6] = mark;
                            playerTurn = false;
                        } else {
                            System.out.println("Square already used");
                            square = squareChoice(whichPlayerIsPlaying);
                        }
                        break;
                    case "3B":
                        if(board[7].equals(" ")) {
                            board[7] = mark;
                            playerTurn = false;
                        } else {
                            System.out.println("Square already used");
                            square = squareChoice(whichPlayerIsPlaying);
                        }
                        break;
                    case "3C":
                        if(board[8].equals(" ")) {
                            board[8] = mark;
                            playerTurn = false;
                        } else {
                            System.out.println("Square already used");
                            square = squareChoice(whichPlayerIsPlaying);
                        }
                        break;
                    case "exit":
                        nextPlayer = 0;
                        break;
                    default:
                        System.out.println("Invalid square");
                        square = squareChoice(whichPlayerIsPlaying);
                }
            }

            if (round >= 5) {
                winner = verifyWin(board);
                System.out.println(winner);
                
                if(winner.equals("X")) {
                    winner = "Player 1 (X) won the game!";
                    nextPlayer = 0;
                } else if(winner.equals("O")) {
                    winner = "Player 2 (O) won the game!";
                    nextPlayer = 0;
                }
            }

        } while (nextPlayer != 0);
        System.out.println(winner);
    }

    public static String squareChoice(boolean whichPlayerIsPlaying) {
        String square;
        String player;
        if(whichPlayerIsPlaying) {
            player = "Player 1 (X)";
        } else {
            player = "Player 2 (O)";
        }
        Scanner keyboard = new Scanner(System.in);
        System.out.println(
            player + "\n"
            + "Choose a square:\n"
        );
        square = keyboard.nextLine();
        return square;
    }

    public static String verifyWin(String[] board) {

        String winningLine = null;

        for(int k = 0; k < 8; k++) {
            switch (k) {
                case 0:
                    winningLine = board[0] + board[1] + board[2];
                    break;
                case 1:
                    winningLine = board[3] + board[4] + board[5];
                    break;
                case 2:
                    winningLine = board[6] + board[7] + board[8];
                    break;
                case 3:
                    winningLine = board[0] + board[3] + board[6];
                    break;
                case 4:
                    winningLine = board[1] + board[4] + board[7];
                    break;
                case 5:
                    winningLine = board[2] + board[5] + board[8];
                    break;
                case 6:
                    winningLine = board[0] + board[4] + board[8];
                    break;
                case 7:
                    winningLine = board[6] + board[4] + board[2];
                    break;
            }

            if(winningLine.equals("XXX")) {
                return "X";
            }
            if(winningLine.equals("OOO")) {
                return "O";
            }
        }
        return "Not yet";
    }

    public static void main(String[] args) {
        gameBoard();
    }
}

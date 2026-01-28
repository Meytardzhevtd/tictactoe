package com.example.tictactoe.model;

public class Game {
    private char[][] board;
    private char currentSymbol;
    private Player playerX;
    private Player playerO;

    private void switchPlayer() {
        currentSymbol = (currentSymbol == 'X') ? 'O' : 'X';
    }

    public boolean joinPlayer(Player player) {
        if (playerX == null) {
            playerX = player;
            return true;
        } else if (playerO == null) {
            playerO = player;
            return true;
        }
        return false;
    }

    private boolean isCorrectMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3;
    }

    public Game() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        currentSymbol = 'X';
    }

    public boolean makeMove(Player player, int row, int col) {
        if (playerX == null || playerO == null) {
            return false;
        }
        if (!player.equals(playerX) && !player.equals(playerO)) {
            return false;
        }
        Player expectedPlayer = (currentSymbol == 'X') ? playerX : playerO;
        if (!player.equals(expectedPlayer)) {
            return false;
        }
        if (!isCorrectMove(row, col) || board[row][col] != ' ') {
            return false;
        }
        board[row][col] = currentSymbol;
        switchPlayer();
        return true;
    }

    public boolean isWin(char symbol) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) {
                return true;
            }
        }
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == symbol && board[1][j] == symbol && board[2][j] == symbol) {
                return true;
            }
        }
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
            return true;
        }
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
            return true;
        }
        return false;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public Player getPlayerX() {
        return playerX;
    }

    public Player getPlayerO() {
        return playerO;
    }

    public char getCurrentSymbol() {
        return currentSymbol;
    }

    public char[][] getBoard() {
        return board;
    }

    public boolean isActive() {
        return playerX != null && playerO != null &&
                !isWin('X') && !isWin('O') && !isBoardFull();
    }
}
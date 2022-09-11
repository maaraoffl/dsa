package com.engineer4life.assessment;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    boolean sudokuSolved = false;

    void placeNextNumbers(char[][] board, int row, int col) {
        if ((col == 8) && (row == 8)) {
            sudokuSolved = true;
        } else {
            if (col == 8)
                backtrack(board, row + 1, 0);
            else
                backtrack(board, row, col + 1);
        }
    }

    void backtrack(char[][] board, int row, int col) {
        // System.out.printf("%d, %d\n", row, col);
        if (board[row][col] == '.') {
            for (int i = 1; i <= 9; i++) {
                if (tryDigit(board, row, col, i)) {
                    char temp = board[row][col];
                    board[row][col] = (char) (i + '0');
                    placeNextNumbers(board, row, col);
                    if (!sudokuSolved) {
                        board[row][col] = temp;
                        
                    }
                }
            }
        } else {
            placeNextNumbers(board, row, col);
        }
    }

    boolean tryDigit(char[][] board, int row, int col, int digit) {

        for (int colIdx = 0; colIdx < 9; colIdx++) {
            int value = board[row][colIdx] - '0';
            if (value == digit)
                return false;
        }

        for (int rowIdx = 0; rowIdx < 9; rowIdx++) {
            int value = board[rowIdx][col] - '0';
            if (value == digit)
                return false;
        }

        int rowStart = row / 3 * 3;
        int colStart = col / 3 * 3;
        for (int rowIdx = rowStart; rowIdx < rowStart + 3; rowIdx++) {
            for (int colIdx = colStart; colIdx < colStart + 3; colIdx++) {
                int value = board[rowIdx][colIdx] - '0';
                if (value == digit)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
        new SudokuSolver().solveSudoku(board);
        // var isValid = new SudokuSolver().tryDigit(board, 0, 5, 8);
        for (var row = 0; row < 9; row++) {
            for (var col = 0; col < 9; col++) {
                System.out.printf("%c\t", board[row][col]);
            }
            System.out.println("\n");
        }
    }
}

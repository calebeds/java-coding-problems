package me.calebeoliveira.nqueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        char[][] board = new char[n][n];

        for(int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backtrack(board, 0, solutions);
        return solutions;
    }

    private void backtrack(char[][] board, int row, List<List<String>> solutions) {
        // Base case: all queens placed successfully
        if(row == board.length) {
            solutions.add(constructBoard(board));
            return;
        }

        for(int col = 0; col < board.length; col++) {
            if(isSafe(board, row, col)) {
                board[row][col] = 'Q';

                backtrack(board, row + 1, solutions);

                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col) {
        // Check column
        for(int i = 0; i < row; i++) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }

        // Check upper-left diagonal
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        // Check upper-right diagonal
        for(int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j--) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }


        return true;
    }

    private List<String> constructBoard(char[][] board) {
        final List<String> solution = new ArrayList<>();
        for(char[] row: board) {
            solution.add(String.valueOf(row));
        }

        return solution;
    }
}

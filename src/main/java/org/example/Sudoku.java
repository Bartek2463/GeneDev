package org.example;

import java.util.ArrayList;

public class Sudoku {

    public ArrayList<Character> getNumbersSolutions( char[][] board,int row, int col){
        ArrayList<Character> solutions = new ArrayList<>();

        char[] number = {'1','2','3','4','5','6','7','8','9'};
        for (char possibleNum: number) {
            boolean combinations = false;
            for (int i=0;i<9;i++) {
                if (board[row][i]==possibleNum ||
                        board[i][col]==possibleNum ||
                        board[(row-row%3)+(int)(i/3)][(col-col%3)+i%3]==possibleNum) {
                    combinations = true;
                    break;
                }
            }
            if (!combinations) {
                solutions.add(possibleNum);
            }
        }
        System.out.println(solutions);
        return solutions;
    }
    }



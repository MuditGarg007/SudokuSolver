package com.mudit;
import java.util.Scanner;

public class sudokusolver {

    public static boolean isInRow(int[][] board, int row, int num){
        for(int i=0; i<board.length; i++){
            if(board[row][i]==num){
                return true;
            }
        }
        return false;
    }

    public static boolean isInCol(int[][] board, int col, int num){
        for(int i=0; i<board.length; i++){
            if(board[i][col]==num){
                return true;
            }
        }
        return false;
    }

    public static boolean isInBox(int[][] board, int row, int col, int num){
        int rowBox = row - row%3;
        int colBox = col - col%3;

        for(int i=rowBox; i<rowBox+3; i++){
            for(int j=colBox; j<colBox+3; j++){
                if(board[i][j]==num){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isValid(int[][] board, int row, int col, int num){
        if(!isInRow(board, row, num) &&
            !isInCol(board, col, num) &&
            !isInBox(board, row, col, num)
        ){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static boolean solveBoard(int[][] board){
        for(int row=0; row<board.length; row++){
            for(int col=0; col<board.length; col++){
                if(board[row][col]==0){
                    for(int numTrial=1; numTrial<=board.length; numTrial++){
                        if(isValid(board, row, col, numTrial)){
                            board[row][col] = numTrial;
                            if(solveBoard(board)){
                                return true;
                            }
                            else{
                                board[row][col]=0;
                            }
                        }

                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static void printBoard(int[][] board){
        for(int i=0; i<board.length; i++){
            if(i%3==0 && i!=0){
                System.out.println("-----------------------");
            }
            for(int j=0; j<board.length; j++){
                if(j%3==0 && j!=0){
                    System.out.print(" |");
                }
                System.out.print(" " + board[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] inputBoard(){
        int[][] board = {
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0}
        };
        printBoard(board);
        System.out.println();
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                System.out.print("Enter Number: ");
                board[i][j] = sc.nextInt();
                System.out.println();
                printBoard(board);
                System.out.println();
            }
        }
        sc.close();
        return board;
    }

    
    public static void main(String args[]){

        int[][] board = inputBoard();

        printBoard(board);

        if(solveBoard(board)){
            System.out.println();
            System.out.println("Successfully solved!");
            System.out.println();
        }
        else{
            System.out.println("Invalid Board :(");
        }

        printBoard(board);
    }

}
// int[][] board = {
//     {7, 0, 2, 0, 5, 0, 6, 0, 0},
//     {0, 0, 0, 0, 0, 3, 0, 0, 0},
//     {1, 0, 0, 0, 0, 9, 5, 0, 0},
//     {8, 0, 0, 0, 0, 0, 0, 9, 0},
//     {0, 4, 3, 0, 0, 0, 7, 5, 0},
//     {0, 9, 0, 0, 0, 0, 0, 0, 8},
//     {0, 0, 9, 7, 0, 0, 0, 0, 5},
//     {0, 0, 0, 2, 0, 0, 0, 0, 0},
//     {0, 0, 7, 0, 4, 0, 2, 0, 3} 
// };
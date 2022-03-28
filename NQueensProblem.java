package Backtracking;

public class NQueensProblem {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n]; // originally all the elements will be true
        System.out.println(queens(board, 0));
    }

    // Defining the function
    static int queens(boolean[][] board, int row){
        if(row == board.length){
            display(board);
            System.out.println();
            return 1;
        }
        // number of ways to place the queens
        int count = 0;
        // Placing the queen by checking rows and cols
        for (int col = 0; col < board.length; col++) {
            // Place the queen when no other queen crosses its path
            if(isSafe(board, row, col)){
                board[row][col] = true;
                count += queens(board, row + 1); // Recursive call
                board[row][col] = false; // undoing the changes done in recursion or Backtracking
            }
        }
        return count;
    }
    // Check if it's okay to place the queen
    private static boolean isSafe(boolean[][] board, int row, int col) {
        // Checking vertical row
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }
        // Checking for diagonal left
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if(board[row - i][col - i]){
                return false;
            }
        }
        // Checking for diagonal right
        int maxRight = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= maxRight; i++) {
            if(board[row - i][col + i]){
                return false;
            }
        }
        return true;
    }


    // Function used to display the board
    private static void display(boolean[][] board) {
        for (boolean[] row : board){ // traversing the rows
            for(boolean element : row){ // traversing individual cells
                if(element){  // if true
                    System.out.print("Q ");
                }
                else{        // if false
                    System.out.print("X ");
                }
            }
            System.out.println(); // new line
        }
    }

}

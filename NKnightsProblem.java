package Backtracking;

public class NKnightsProblem {
    public static void main(String[] args) {
    int n = 4;
    boolean board[][] = new boolean[n][n];
    Nknights(board, 0, 0, 4);
    }

    static void Nknights(boolean[][]board, int row, int col, int knights){
        // All the knights are placed
        if(knights == 0){
            display(board);
            System.out.println();
            return;
        }

        // If we are at the end of the board
        if(row == board.length - 1 && col == board.length){
            return;
        }

        // if we reach the last element in the row
        if(col == board.length){
            // Go to the next row
            Nknights(board, row + 1, 0, knights);
            return;
        }

        // If we can place the knight
        if(isSafe(board, row, col)){
            board[row][col] = true;
            // Knight is placed
            Nknights(board, row, col + 1, knights - 1);
            board[row][col] = false;
        }

        // Only triggers when none of the above condition is triggered
        Nknights(board, row, col + 1, knights);
    }

    // Function that checks if we can place the knight
    private static boolean isSafe(boolean[][] board, int row, int col){
        // up-up-left
        if(isValid(board, row - 2, col - 1 )){
            // Checks if the current cell is available to be filled
            if(board[row - 2][col - 1]){
                return false; // Makes it false
            }
        }
        // up-up-right
        if(isValid(board, row - 2, col + 1 )){
            // Checks if the current cell is available to be filled
            if(board[row - 2][col + 1]){
                return false; // Makes it false
            }
        }
        // Up-left-left or left-left-up
        if(isValid(board, row - 1, col - 2 )){
            // Checks if the current cell is available to be filled
            if(board[row - 1][col - 2 ]){
                return false; // Makes it false
            }
        }
        // Up-right-right or right-right-up
        if(isValid(board, row - 1, col + 2 )){
            // Checks if the current cell is available to be filled
            if(board[row - 1][col + 2]){
                return false; // Makes it false
            }
        }
        return true;
    }

    // Function that checks if we are still inside the matrix
    // Made so that repetition is avoided
    static boolean isValid(boolean[][] board, int row, int col){
        return row >= 0 && row < board.length && col >= 0 && col < board.length;
    }


    // Function used to display the board
    private static void display(boolean[][] board) {
        for (boolean[] row : board){ // traversing the rows
            for(boolean element : row){ // traversing individual cells
                if(element){  // if true
                    System.out.print("K ");
                }
                else{        // if false
                    System.out.print("X ");
                }
            }
            System.out.println(); // new line
        }
    }
}

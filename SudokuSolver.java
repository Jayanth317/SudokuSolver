class SudokuSolver {
    // To check whether a number is present in a certain row or not
    public static boolean isNumberInRow(int[][] board, int row, int number) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == number)
                return true;
        }
        return false;
    }

    // To check whether a number is present in a certain column or not
    public static boolean isNumberInColumn(int[][] board, int column, int number) {
        for (int i = 0; i < 9; i++) {
            if (board[i][column] == number)
                return true;
        }
        return false;
    }

    // To check whether a number is present in a certain 3X3 box
    public static boolean isNumberInBox(int[][] board, int row, int column, int number) {
        int boxRow = row - row % 3;
        int boxColumn = column - column % 3;
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxColumn; j < boxColumn; j++) {
                if (board[i][j] == number)
                    return true;
            }
        }
        return false;
    }

    //To check whether the number placed in blank space is valid or not
    public static boolean isValidPlacement(int[][] board, int row, int column, int number) {
        return !isNumberInRow(board, row, number) &&
                !isNumberInColumn(board, column, number) &&
                !isNumberInBox(board, row, column, number);
    }

    //Method to solve the sudoku
    public static boolean solveBoard(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (board[row][column] == 0) {
                    for (int validNumber = 1; validNumber <= 9; validNumber++) {
                        if (isValidPlacement(board, row, column, validNumber)) {
                            board[row][column] = validNumber;
                            if (solveBoard(board))
                                return true;
                            else
                                board[row][column] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    //Method to print the sudoku
    public static void printBoard(int[][] board) {
        for (int row = 0; row < 9; row++) {
            if (row % 3 == 0 && row != 0)
                System.out.println("----------------------");

            for (int column = 0; column < 9; column++) {
                if (column % 3 == 0 && column != 0)
                    System.out.print(" | ");
                System.out.print(board[row][column]);

            }
            System.out.println(" ");
        }
    }

    public static void main(String[] args) {
        int[][] board = {
                { 7, 0, 2, 0, 5, 0, 6, 0, 0 },
                { 0, 0, 0, 0, 0, 3, 0, 0, 0 },
                { 1, 0, 0, 0, 0, 9, 5, 0, 0 },
                { 8, 0, 0, 0, 0, 0, 0, 9, 0 },
                { 0, 4, 3, 0, 0, 0, 7, 5, 0 },
                { 0, 9, 0, 0, 0, 0, 0, 0, 8 },
                { 0, 0, 9, 7, 0, 0, 0, 0, 5 },
                { 0, 0, 0, 2, 0, 0, 0, 0, 0 },
                { 0, 0, 7, 0, 4, 0, 2, 0, 3 }
        };
        System.out.println("The given sudoku: ");
        printBoard(board);

        if (solveBoard(board)) {
            System.out.println("Sudoku solved Successfully :)");
        } else
            System.out.println("Invalid Sudoku matrix :(");

        printBoard(board);

    }
}
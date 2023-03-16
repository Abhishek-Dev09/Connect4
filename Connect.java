public class Connect {
    char[][] board;
    int rows;
    int columns;
    int connectNum;
    char currentPlayer;

    public Connect(int rows, int columns, int connectNum) {
        this.rows = rows;
        this.columns = columns;
        this.connectNum = connectNum;
        board = new char[rows][columns];
        currentPlayer = 'X';
        initializeGame();
    }

    private void initializeGame() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void printBoard() {
        System.out.println("-------------");
        for (int row = 0; row < rows; row++) {
            System.out.print("| ");
            for (int col = 0; col < columns; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public boolean isBoardFull() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] == '-')
                    return false;
            }
        }
        return true;
    }

    public boolean isWinner() {
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column <= columns-connectNum; column++) {
                if(checkSequence(row, column, 0, 1))
                    return true;
            }
        }
        for (int row = 0; row <= rows - connectNum; row++) {
            for (int col = 0; col < columns; col++) {
                if (checkSequence(row, col, 1, 0)) {
                    return true;
                }
            }
        }

        // Check diagonal
        for (int row = 0; row <= rows - connectNum; row++) {
            for (int col = 0; col <= columns - connectNum; col++) {
                if (checkSequence(row, col, 1, 1)) {
                    return true;
                }
            }
        }

        // Check anti-diagonal
        for (int row = connectNum - 1; row < rows; row++) {
            for (int col = 0; col <= columns - connectNum; col++) {
                if (checkSequence(row, col, -1, 1)) {
                    return true;
                }
            }
        }

        return false;
    }

    boolean checkSequence(int row, int col, int rowOffset, int colOffset){
        char startChar = board[row][col];
        if(startChar == '-')
            return false;
        for (int i = 1; i < connectNum; i++) {
            int newRow = row + i*rowOffset;
            int newCol = col + i*colOffset;
            if(newRow<0 || newRow>=rows || newCol<0 || newCol>=columns)
                return false;
            if(board[newRow][newCol] != startChar)
                return false;
        }
        return true;
    }
    public boolean placeMark(int row, int col) {
        if (row >= 0 && row < rows && col>= 0 && col < columns) {
            if (board[row][col] == '-') {
                board[row][col] = currentPlayer;
                return true;
            }
        }
        return false;
    }

    public void changePlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }
}

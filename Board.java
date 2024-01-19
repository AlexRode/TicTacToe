public class Board {
    private static final char EMPTY = ' ';
    private final char[][] board = new char[3][3];

    public Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = EMPTY;
            }
        }
    }
   public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("-----");
        }
    }
   

    public char[][] getBoard() {
        return board;
    }


    public boolean hasWinner() {
        return (checkRows() || checkColumns() || checkDiagonals());
    }

    public boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != EMPTY && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }
        return false;
    }

    public boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (board[0][i] != EMPTY && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDiagonals() {
        return (board[0][0] != EMPTY && board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
               (board[0][2] != EMPTY && board[0][2] == board[1][1] && board[1][1] == board[2][0]);
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean makeMove(int row, int col, char player) {
        if (isValidMove(row, col)) {
            board[row][col] = player;
            return true;
        }
        return false;
    }
    public void undoMove(int row, int col) {
        board[row][col] = EMPTY;
    }
    
    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == EMPTY;
    }
    public boolean isCellEmpty(int row, int col) {
        return board[row][col] == EMPTY;
    }

    public int evaluateBoard(char aiSymbol, char playerSymbol) {
        // Verifica cada linha
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                if (board[i][0] == aiSymbol) return +10;
                else if (board[i][0] == playerSymbol) return -10;
            }
        }
    
        // Verifica cada coluna
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                if (board[0][i] == aiSymbol) return +10;
                else if (board[0][i] == playerSymbol) return -10;
            }
        }
    
        // Verifica as diagonais
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            if (board[0][0] == aiSymbol) return +10;
            else if (board[0][0] == playerSymbol) return -10;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            if (board[0][2] == aiSymbol) return +10;
            else if (board[0][2] == playerSymbol) return -10;
        }
    
        // Se o jogo ainda está em aberto ou é um empate, retorna 0
        return 0;
    }
    public boolean isGameFinished() {
        if (hasWinner()) {
            return true;
        }

        return isBoardFull(); // Verifica se o tabuleiro está cheio, indicando um empate
    }

     public char getWinner() {
        // Verifica cada linha
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != EMPTY && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return board[i][0];
            }
        }

        // Verifica cada coluna
        for (int i = 0; i < 3; i++) {
            if (board[0][i] != EMPTY && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return board[0][i];
            }
        }

        // Verifica as diagonais
        if (board[0][0] != EMPTY && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return board[0][0];
        }
        if (board[0][2] != EMPTY && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return board[0][2];
        }

        return EMPTY; // Retorna EMPTY se não houver vencedor
    }
    
}
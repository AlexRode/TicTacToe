public class InvincibleAI implements TicTacToeAI {
    private char aiSymbol;
    private char playerSymbol;

    public InvincibleAI(char aiSymbol, char playerSymbol) {
        this.aiSymbol = aiSymbol;
        this.playerSymbol = playerSymbol;
    }

    @Override
    public void makeMove(Board board) {
        int[] bestMove = findBestMove(board);
        board.makeMove(bestMove[0], bestMove[1], aiSymbol);
    }

    private int[] findBestMove(Board board) {
        int bestScore = Integer.MIN_VALUE;
        int[] bestMove = {-1, -1};

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board.isCellEmpty(row, col)) {
                    board.makeMove(row, col, aiSymbol);
                    int score = minimax(board, 0, false);
                    board.undoMove(row, col);

                    if (score > bestScore) {
                        bestScore = score;
                        bestMove[0] = row;
                        bestMove[1] = col;
                    }
                }
            }
        }
        return bestMove;
    }

    private int minimax(Board board, int depth, boolean isMaximizing) {
        int score = board.evaluateBoard(aiSymbol, playerSymbol);
    
        if (Math.abs(score) == 10 || board.isBoardFull()) {
            return score;
        }
    
        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (board.isCellEmpty(row, col)) {
                        board.makeMove(row, col, aiSymbol);
                        bestScore = Math.max(bestScore, minimax(board, depth + 1, false));
                        board.undoMove(row, col);
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (board.isCellEmpty(row, col)) {
                        board.makeMove(row, col, playerSymbol);
                        bestScore = Math.min(bestScore, minimax(board, depth + 1, true));
                        board.undoMove(row, col);
                    }
                }
            }
            return bestScore;
        }
    }
}
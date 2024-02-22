import java.util.Scanner;



public class tictactoe_2 {
   
    Board board;
    TicTacToeAI ai;
    char currentPlayer;
    char playerSymbol;
    char aiSymbol;
   

    public tictactoe_2(char playerSymbol,TicTacToeAI ai) {
        this.playerSymbol = playerSymbol;
        this.aiSymbol = (playerSymbol == 'X') ? 'O' : 'X';
        this.currentPlayer = 'X';  // X sempre começa.
        this.board = new Board();
        this.ai = ai;

        // Se o jogador escolher 'O' e estiver jogando contra a IA, a IA joga primeiro
        if (this.playerSymbol == 'O' && this.ai != null) {
            ai.makeMove(board);
            this.currentPlayer = 'O';  // Muda para o jogador humano
        }
    }
    public void playGame(Scanner scanner, boolean againstComputer) {
        while (!board.isGameFinished()) {
            board.printBoard();
    
            if (againstComputer && currentPlayer == aiSymbol) {
                ai.makeMove(board);
                switchPlayer();
            } else {
                System.out.println("Player " + currentPlayer + ", enter your move (row[1-3] column[1-3]): ");
                int row = scanner.nextInt() - 1;
                int col = scanner.nextInt() - 1;
                if (!board.makeMove(row, col, currentPlayer)) {
                    System.out.println("Invalid move. Try again.");
                    continue;
                }
                switchPlayer();
            }
        }
        board.printBoard();
        announceResult(); // Anuncia o resultado após o jogo terminar
    }
 
   

    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
    private void announceResult() {
        if (board.hasWinner()) {
            System.out.println("Player " + (currentPlayer == 'X' ? 'O' : 'X') + " wins!");
        } else {
            System.out.println("The game is a draw!");
        }
    }

}
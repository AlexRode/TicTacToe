//import java.util.Random;

public interface TicTacToeAI {
    void makeMove(Board board);
}
 /*    private Board board;
    private Random random;
    private char aiSymbol;

  
    public TicTacToeAI(Board board, char aiSymbol) {
        this.board = board;
        this.aiSymbol = aiSymbol; // Inicializa o símbolo do AI
        this.random = new Random();
    }


    public void makeComputerMoveRandom() {
        int row, col;
        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (!board.makeMove(row, col, aiSymbol)); // Garante que o símbolo correto é usado
        System.out.println("Computer played at (" + (row + 1) + ", " + (col + 1) + ")");
    }

*/


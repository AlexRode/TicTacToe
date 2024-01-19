import java.util.Random;

public class DumbAI implements TicTacToeAI {
    private Random random = new Random();
    private char aiSymbol;

    public DumbAI(char aiSymbol) {
        this.aiSymbol = aiSymbol;
    }

    @Override
    public void makeMove(Board board) {
        int row, col;
        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (!board.makeMove(row, col, aiSymbol));
       System.out.println("Dumb AI played at (" + (row + 1) + ", " + (col + 1) + ")");
    }
    public char getSymbol() {
        return aiSymbol; // Retorna o símbolo da IA
    }
}

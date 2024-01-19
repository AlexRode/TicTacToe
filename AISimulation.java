import java.util.ArrayList;
import java.util.List;

public class AISimulation {
    public static void main(String[] args) {
        int numberOfGames = 100000;  // Número de jogos a serem simulados
        int dumbAIWins = 0;

        DumbAI dumbAI = new DumbAI('X');
        InvincibleAI invincibleAI = new InvincibleAI('O', 'X');
        List<List<String>> winningGames = new ArrayList<>();

        for (int i = 0; i < numberOfGames; i++) {
            Board board = new Board();
            List<String> gameHistory = new ArrayList<>();
            boolean isDumbAITurn = true;

            while (!board.isGameFinished()) {
                if (isDumbAITurn) {
                    dumbAI.makeMove(board);
                    gameHistory.add(board.toString());  // Armazena o estado do tabuleiro
                } else {
                    invincibleAI.makeMove(board);
                }

                isDumbAITurn = !isDumbAITurn;
            }

            if (board.hasWinner() && board.getWinner() == dumbAI.getSymbol()) {
                dumbAIWins++;
                winningGames.add(gameHistory);
            }
        }

        System.out.println("Dumb AI wins: " + dumbAIWins);
        for (List<String> game : winningGames) {
            System.out.println("Winning Game:");
            for (String state : game) {
                System.out.println(state);
            }
            System.out.println("-----------------");
        }
    }
}


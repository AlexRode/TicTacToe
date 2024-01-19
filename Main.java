import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int gameTypeChoice = GameMenu.showMenu(scanner); // Mostra o menu e obtém a escolha do tipo de jogo

        // Determinar se o jogo é contra outro jogador ou contra o computador
        boolean againstComputer = (gameTypeChoice == 2);

        char playerSymbol = 'X'; // Por padrão, o jogador é 'X'
        char aiSymbol = 'O'; // Por padrão, o AI é 'O'

        if (againstComputer) {
            playerSymbol = GameMenu.choosePlayer(scanner); // Permite ao usuário escolher o símbolo
            aiSymbol = (playerSymbol == 'X') ? 'O' : 'X'; // Define o símbolo do AI como o oposto do jogador
        }

        TicTacToeAI ai = null;
        if (againstComputer) {
            ai = GameMenu.chooseAI(scanner, aiSymbol, playerSymbol);
        }

        // Inicializa o jogo com o símbolo escolhido
        tictactoe_2 game = new tictactoe_2(playerSymbol, ai);

        // Inicia o jogo
        game.playGame(scanner, againstComputer);

        scanner.close();
    }
}
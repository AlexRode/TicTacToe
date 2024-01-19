import java.util.Scanner;

public class GameMenu {

    public static int showMenu(Scanner scanner) {
        System.out.println("Tic-Tac-Toe Game");
        System.out.println("1. Player vs Player");
        System.out.println("2. Player vs Computer");
        int choice;
        do {
            System.out.print("Enter your choice (1 or 2): ");
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a number!");
                scanner.next(); // Limpa o input incorreto
                System.out.print("Enter your choice (1 or 2): ");
            }
            choice = scanner.nextInt();
        } while (choice != 1 && choice != 2);
        return choice;
    }

    public static char choosePlayer(Scanner scanner) {
        System.out.println("Choose your symbol (X goes first):");
        System.out.println("1. X");
        System.out.println("2. O");
        char symbol;
        do {
            System.out.print("Enter your choice (1 or 2): ");
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a number!");
                scanner.next(); // Limpa o input incorreto
                System.out.print("Enter your choice (1 or 2): ");
            }
            int symbolChoice = scanner.nextInt();
            symbol = (symbolChoice == 1) ? 'X' : 'O';
        } while (symbol != 'X' && symbol != 'O');
        return symbol;
    }

    public static TicTacToeAI chooseAI(Scanner scanner, char aiSymbol, char playerSymbol) {
        System.out.println("Choose the AI difficulty:");
        System.out.println("1. Dumb AI");
        System.out.println("2. Invincible AI");
        int aiChoice;
        do {
            System.out.print("Enter your choice (1 or 2): ");
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a number!");
                scanner.next();
                System.out.print("Enter your choice (1 or 2): ");
            }
            aiChoice = scanner.nextInt();
        } while (aiChoice != 1 && aiChoice != 2);

        if (aiChoice == 1) {
            return new DumbAI(aiSymbol);
        } else {
            return new InvincibleAI(aiSymbol, playerSymbol);
        }
    }
}

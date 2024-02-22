import java.util.Scanner;

import javax.swing.JButton;

import javax.swing.JFrame;
import java.awt.Insets;

import javax.swing.WindowConstants;



import java.awt.Dimension;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class GameMenu {
private JFrame MenuPanel;
private final int width = 800; // Largura do canvas
private final int height = 600; // Altura do canvas

public GameMenu() {
    MenuPanel = new JFrame("TicTacToe");
    MenuPanel.setPreferredSize(new Dimension(width, height));
		// para que o botao de fechar a janela termine a aplicacao
		MenuPanel.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		addFrameContent();
		
		// para que a janela se redimensione de forma a ter todo o seu conteudo visivel
		MenuPanel.pack();
	}

	public void open() {
		// para abrir a janela (torna-la visivel)
		MenuPanel.setVisible(true);
	}

    private void addFrameContent() {
		
		
		/* para organizar o conteudo em grelha (linhas x colunas)
		se um dos valores for zero, o numero de linhas ou colunas (respetivamente) fica indefinido,
		e estas sao acrescentadas automaticamente */
		MenuPanel.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();

    JButton buttonLocal = new JButton("Player vs Player");
    JButton buttonAi = new JButton("Player vs Computer");

    // Configurações para centralizar os componentes
    gbc.gridwidth = GridBagConstraints.REMAINDER; // Faz com que o componente seja o último na sua linha.
    gbc.fill = GridBagConstraints.HORIZONTAL; // Faz com que o botão expanda-se horizontalmente.
    gbc.anchor = GridBagConstraints.CENTER; // Centraliza o componente.
   
    gbc.insets = new Insets(10, 0, 10, 0);
   
    // Adiciona os botões ao painel com as restrições definidas
    
        buttonLocal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                TicTacToeGUI.main(null);
             
			}
		});
        MenuPanel.add(buttonLocal, gbc);
        MenuPanel.add(buttonAi, gbc);
	}
		


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

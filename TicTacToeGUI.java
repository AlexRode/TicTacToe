import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGUI {
    private JFrame frame;
    private JButton[][] buttons = new JButton[3][3];
    private tictactoe_2 game;

    public TicTacToeGUI() {
        game = new tictactoe_2('X', null); // Começar com o jogador 'X', sem IA
        frame = new JFrame("TicTacToe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLayout(new GridLayout(3, 3)); // Usar GridLayout para o tabuleiro

        // Inicializar e adicionar botões
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = new JButton();
                button.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
                int finalI = i;
                int finalJ = j;
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (game.board.isCellEmpty(finalI, finalJ)) {
                            game.board.makeMove(finalI, finalJ, game.currentPlayer);
                            button.setText(String.valueOf(game.currentPlayer));
                            if (game.board.hasWinner() || game.board.isBoardFull()) {
                                game.announceResult();
                                disableButtons();
                            } else {
                                game.switchPlayer();
                            }
                        }
                    }
                });
                frame.add(button);
                buttons[i][j] = button;
            }
        }

        frame.setVisible(true);
    }
    private void disableButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
    }
    
    public static void main(String[] args) {
        // Execute a GUI no Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TicTacToeGUI();
            }
        });
    }
}

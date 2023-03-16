import Inteligence.HumanIntelligence;
import Inteligence.Intelligence;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = scanner.nextInt();

        System.out.print("Enter number of connecting marks: ");
        int connectNum = scanner.nextInt();

        Connect game = new Connect(rows, cols, connectNum);

        game.printBoard();

        while (!game.isBoardFull() && !game.isWinner()) {
            Intelligence intelligence = new HumanIntelligence();
            List<Integer> cordinates = intelligence.getCordinates(game.currentPlayer, rows, cols);

            if (game.placeMark(cordinates.get(0), cordinates.get(1))) {
                game.printBoard();
                game.changePlayer();
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        if (game.isWinner()) {
            game.changePlayer();
            System.out.println("Player " + game.getCurrentPlayer() + " wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}
package Inteligence;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HumanIntelligence implements Intelligence{
    @Override
    public List<Integer> getCordinates(char currentPlayer, int rows, int columns) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Player " + currentPlayer + ", enter row (0-" + (rows - 1) + "): ");
        int row = scanner.nextInt();

        System.out.print("Player " + currentPlayer + ", enter column (0-" + (columns - 1) + "): ");
        int col = scanner.nextInt();
        return Arrays.asList(row, col);
    }
}

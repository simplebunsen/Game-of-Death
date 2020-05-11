package life;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Random;
import java.util.RandomAccess;
import java.util.Scanner;

public class Main {
    static boolean[][] universe;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();

        universe = new boolean[n][n];

        Random random = new Random(s);
        for (int row = 0; row < universe.length; row++) {
            for (int spot = 0; spot < universe[0].length; spot++) {
                universe[row][spot] = random.nextBoolean(); //brain bending order of row and col
            }
        }

        printUniverse();
    }

    private static void printUniverse() {
        for (boolean[] row : universe) {
            for (boolean spot : row) {
                if (spot) System.out.print("O");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }
}

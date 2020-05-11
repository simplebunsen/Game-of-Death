package life;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        clearScreen();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long s = -1; //scanner.nextLong();
        int m = 10;

        UniverseHandler u = new UniverseHandler(n, s);
        clearScreen();
        for (int i = 0; i < m; i++) {
            u.generateNextStep();
            System.out.printf("Generation #%d \n", i + 1);
            System.out.printf("Alive: %d \n", u.getCurrentAlive());
            u.printUniverse();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clearScreen();
        }


    }

    private static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        }
        catch (IOException | InterruptedException e) {}
    }

}

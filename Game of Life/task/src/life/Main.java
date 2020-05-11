package life;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long s = scanner.nextLong();
        int m = scanner.nextInt();

        UniverseHandler u = new UniverseHandler(n, s);

        for (int i = 0; i < m; i++) {
            u.generateNextStep();
        }

        u.printUniverse();
    }

}

package life;

import jdk.swing.interop.SwingInterOpUtils;

import javax.swing.text.Position;
import java.util.Random;
import java.util.RandomAccess;
import java.util.Scanner;

public class UniverseHandler {

    boolean[][] universe;
    int universeSize;

    public UniverseHandler (int n, long s) {
        this.universe = new boolean[n][n];
        this.universeSize = n;

        Random random = new Random(s);
        for (int row = 0; row < universeSize; row++) {
            for (int spot = 0; spot < universeSize; spot++) {
                universe[row][spot] = random.nextBoolean(); //brain bending order of row and col
            }
        }
    }

    public void generateNextStep() {
        boolean[][] nextUniverse = new boolean[universeSize][universeSize];


        for (int row = 0; row < universeSize; row++) {
            for (int spot = 0; spot < universeSize; spot++) {
                int neighborCount = 0;

                //System.out.println("Checking neighbor for pos " + row + " " + spot);
                for (int nRow = row - 1; nRow <= row + 1 ; nRow++) {
                    for (int nSpot = spot - 1; nSpot <= spot + 1; nSpot++) {
                        //System.out.printf("%d %d cell location, %d %d neighbor \n", row, spot, nRow, nSpot);
                        if (!(nRow == row && nSpot == spot))
                            neighborCount += checkNeighbor(nRow, nSpot);

                    }
                }
                //System.out.printf("cell at %d %d has %d neighbors\n", row, spot, neighborCount);
                if (universe[row][spot]) {
                    //alive
                    switch (neighborCount) {
                        case 2:
                        case 3:
                            nextUniverse[row][spot] = true;
                            break;
                        default:
                            nextUniverse[row][spot] = false;
                    }
                } else {
                    //dead
                    switch (neighborCount) {
                        case 3:
                            nextUniverse[row][spot] = true;
                            break;
                        default:
                            nextUniverse[row][spot] = false;
                    }
                }
            }
        }
        universe = nextUniverse;
    }

    private int checkNeighbor(int row, int spot) {
        //ystem.out.println("Checking neighbor -> at " + row + " " + spot + " specifically.");
        // put the thingies on the playing board if they loop around the side, else the modulo won't change them.
            row = Math.floorMod(row, universeSize);
            spot = Math.floorMod(spot, universeSize);

        //System.out.printf("looking at %d %d. has a cell? %b\n", row, spot, universe[row][spot]);
            return universe[row][spot] ? 1 : 0;
    }


    private void PrintUniverseBetter() {
        System.out.print("     ");
        for (int i = 0; i < universeSize; i++) {
            System.out.print(i + "  ");
        }
        System.out.println();

        int i = 0;
        for (boolean[] row : universe) {
            System.out.print(i + " | ");
            i++;
            for (boolean spot : row) {
                if (spot) System.out.print(" O ");
                else System.out.print("[_]");
            }
            System.out.println();
        }
    }

    public void printUniverse() {
        for (boolean[] row : universe) {
            for (boolean spot : row) {
                if (spot) System.out.print("O");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }
}

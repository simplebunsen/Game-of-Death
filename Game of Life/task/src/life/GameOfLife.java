package life;

import javax.swing.*;
import java.awt.*;

//GUI
public class GameOfLife extends JFrame {
    private static final int GRID_GAP = 2;
    private JPanel[][] cells;
    private JPanel labelPanel;
    private JLabel genLabel;
    private JLabel aliveLabel;

    public GameOfLife(int universeSize) {
        super("Game Of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if (universeSize >= 80) {
            add(new JLabel("Your universe is to big, I don't guarantee anything.."));
        }
        setSize(universeSize * 25, universeSize * 25 + 25);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));


        labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
        add(labelPanel);

        genLabel = new JLabel();
        genLabel.setText("Generation #XX");
        genLabel.setName("GenerationLabel");
        labelPanel.add(genLabel);

        aliveLabel = new JLabel();
        aliveLabel.setText("Alive: XX");
        aliveLabel.setName("AliveLabel");
        labelPanel.add(aliveLabel);


        JPanel universePanel = new JPanel();
        universePanel.setLayout(new GridLayout(universeSize, universeSize, GRID_GAP, GRID_GAP));
        universePanel.setBackground(Color.BLACK);
        add(universePanel);

        cells = new JPanel[universeSize][universeSize];
        for (int row = 0; row < universeSize; row++) {
            for (int spot = 0; spot < universeSize; spot++) {
                JPanel cell = new JPanel();
                cell.setBackground(Color.WHITE);
                cells[row][spot] = cell;
                universePanel.add(cell);
            }
        }


        setVisible(true);
//        JLabel test = new JLabel();
//        test.setText("This should not be shown");
//        universePanel.add(test);

    }

    public void editUniverseGUI(int row, int spot, boolean targetState) {
        cells[row][spot].setBackground(targetState ? Color.BLACK : Color.WHITE);
    }

    public void editGenerationGUI(int targetGeneration) {
        genLabel.setText("Generation #".concat(String.valueOf(targetGeneration)));
    }
    public void editAliveGUI(int targetAlive) {
        aliveLabel.setText("Alive: ".concat(String.valueOf(targetAlive)));
    }
}

class Test {

    public static void main(String[] args) throws InterruptedException {
        GameOfLife GUI = new GameOfLife(25);

        Thread.sleep(2000);
        GUI.editUniverseGUI(3,4, true);
        Thread.sleep(2000);
        GUI.editGenerationGUI(552);
        GUI.editAliveGUI(841);

    }
}

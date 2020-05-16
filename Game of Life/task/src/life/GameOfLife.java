package life;

import javax.swing.*;
import java.awt.*;

//GUI
public class GameOfLife extends JFrame {
    private static final int GRID_GAP = 1;
    private JPanel[][] cells;
    private JPanel infoPanel;
    private JLabel genLabel;
    private JLabel aliveLabel;
    private JToggleButton pauseButton;
    private JButton resetButton;

    public GameOfLife() {
        super("Game Of Life");

        int universeSize = UniverseHandler.universeSize;
        System.out.println("UNIVERSE SIZE IN GOL: " + universeSize);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        if (universeSize >= 80) {
            add(new JLabel("Your universe is to big, I don't guarantee anything.."));
        }

        setSize(universeSize * 10 + 60, universeSize * 10);
        setLocationRelativeTo(null);
        //setLayout(new BoxLayout(getContentPane(), BoxLayout.LINE_AXIS));



        infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(infoPanel, BorderLayout.WEST);




        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        infoPanel.add(buttonPanel);

        pauseButton = new JToggleButton("pause");
        pauseButton.setName("PlayToggleButton");
        buttonPanel.add(pauseButton);

        resetButton = new JButton("reset");
        resetButton.setName("ResetButton");
        buttonPanel.add(resetButton);

        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(2,1));
        infoPanel.add(labelPanel);

        genLabel = new JLabel("Generation #0", SwingConstants.LEFT);
        genLabel.setName("GenerationLabel");
        labelPanel.add(genLabel);

        aliveLabel = new JLabel("Alive: 0", SwingConstants.LEFT);
        aliveLabel.setName("AliveLabel");
        labelPanel.add(aliveLabel);







//        JPanel universePanel = new JPanel();
//        universePanel.setLayout(new GridLayout(universeSize, universeSize, GRID_GAP, GRID_GAP));
//        universePanel.setBackground(Color.BLACK);
//        add(universePanel);
//
//        cells = new JPanel[universeSize][universeSize];
//        for (int row = 0; row < universeSize; row++) {
//            for (int spot = 0; spot < universeSize; spot++) {
//                JPanel cell = new JPanel();
//                cell.setBackground(Color.WHITE);
//                cell.setMinimumSize(new Dimension(1,1));
//                cells[row][spot] = cell;
//                universePanel.add(cell);
//            }
//        }
//

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

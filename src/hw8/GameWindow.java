package hw8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {

    static final int WINDOW_POS_X = 500;
    static final int WINDOW_POS_Y = 300;
    static final int WINDOW_WIDTH = 500;
    static final int WINDOW_HEIGHT = 555;

    private SettingsWindow settingsWindow;
    private BattleMap battleMap;

    private static JLabel logField = new JLabel("Welcome, player!",SwingConstants.CENTER);

    public GameWindow(){
        setBounds(WINDOW_POS_X,WINDOW_POS_Y,WINDOW_WIDTH,WINDOW_HEIGHT);
        setTitle("Крестики-нолики");

        //окно настроек
        this.settingsWindow = new SettingsWindow(this);

        //игровое поле
        this.battleMap = new BattleMap(this);
        add(battleMap, BorderLayout.CENTER);

        //нижняя панель
        JPanel bottomPanel = new JPanel(new GridLayout(2,1));

        JPanel panel = new JPanel(new GridLayout(1,2));
        JButton btnNewGame = new JButton("Start new game");
        JButton btnExit = new JButton("Exit");
        panel.add(btnNewGame);
        panel.add(btnExit);

        bottomPanel.add(logField);
        bottomPanel.add(panel);

        add(bottomPanel, BorderLayout.SOUTH);
        btnExit.setBackground(Color.PINK);
        btnNewGame.setBackground(Color.GREEN);

        btnNewGame.addActionListener(e -> settingsWindow.setVisible(true));

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    void startNewGame(int size, int winningLine){
        battleMap.startNewGame(size, winningLine);
        logField.setText("New game started! Dots to win = "+winningLine);
    }

    public static void setGameResults(String gameResult) {
        logField.setText(gameResult);
    }
}

package hw8;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {

    static final int WINDOW_POS_X = GameWindow.WINDOW_POS_X+50;
    static final int WINDOW_POS_Y = GameWindow.WINDOW_POS_Y+50;
    static final int WINDOW_WIDTH = 400;
    static final int WINDOW_HEIGHT = 300;

    private GameWindow gameWindow;
    private JButton btnStart;
    private JSlider slFieldSize;
    private JSlider slWinningLength;

    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 9;
    private static final int MIN_WIN_LENGTH = 3;
    private static final int MAX_WIN_LENGTH = 7;


    public SettingsWindow(GameWindow gameWindow){
        this.gameWindow = gameWindow;
        setBounds(WINDOW_POS_X,WINDOW_POS_Y,WINDOW_WIDTH,WINDOW_HEIGHT);
        setTitle("Настройки");

        setLayout(new GridLayout(5,1));

        add(new Label("Field size:"));
        slFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE,MIN_FIELD_SIZE);
        slFieldSize.setMajorTickSpacing(1);
        slFieldSize.setPaintLabels(true);
        slFieldSize.setPaintTicks(true);
        add(slFieldSize);

        add(new Label("Dots-in-line to win:"));
        slWinningLength = new JSlider(MIN_WIN_LENGTH,MIN_WIN_LENGTH,MIN_WIN_LENGTH);
        slWinningLength.setMajorTickSpacing(1);
        slWinningLength.setPaintLabels(true);
        slWinningLength.setPaintTicks(true);
        add(slWinningLength);

        slFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                slWinningLength.setMaximum(slFieldSize.getValue());
            }
        });


        btnStart = new JButton("Start");
        add(btnStart);
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                int size = slFieldSize.getValue();
                int winningLength = slWinningLength.getValue();

                TheGame.SIZE = size;
                TheGame.DOTS_TO_WIN = winningLength;
                TheGame.initGame();
                gameWindow.startNewGame(size, winningLength);
            }
        });

        setVisible(false);
    }


}

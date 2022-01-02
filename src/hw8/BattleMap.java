package hw8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BattleMap extends JPanel {

    private GameWindow gameWindow;

    private int size;
    private int winningLength;

    private boolean isInit;

    private int cellWidth;
    private int cellHeigth;

    public BattleMap(GameWindow gameWindow){
        this.gameWindow = gameWindow;
        setBackground(Color.LIGHT_GRAY);

        //click mouse button
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int cellX = e.getX()/cellWidth;
                int cellY = e.getY()/cellHeigth;
                TheGame.humanTurn(cellX,cellY);
            }
        });
    }

    void startNewGame(int size, int winningLength){
        //System.out.printf("size %dx%d ; line - %d dots\n", size,size,winningLength);
        this.size = size;
        this.winningLength = winningLength;

        isInit = true;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (!isInit){
            return;
        }

        cellHeigth = getHeight() / size;
        cellWidth = getWidth() / size;

        g.setColor(Color.DARK_GRAY);
        ((Graphics2D)g).setStroke(new BasicStroke(2f));

        for (int i = 0; i < size; i++) {
            int y = i*cellHeigth;
            g.drawLine(0,y,getWidth(),y);
        }

        for (int i = 0; i < size; i++) {
            int x = i * cellWidth;
            g.drawLine(x,0,x, getHeight());
        }

        for (int i = 0; i < TheGame.SIZE; i++) {
            for (int j = 0; j < TheGame.SIZE; j++) {
                if (TheGame.map[j][i]==TheGame.DOT_X) {
                    drawX(g,i,j);
                }
                if (TheGame.map[j][i]==TheGame.DOT_0) {
                    drawO(g,i,j);
                }
            }
        }
        if (TheGame.WIN) {
            drawWinningLine(g, TheGame.winningCellX, TheGame.winningCellY, TheGame.winnignDirrection);

            gameWindow.setGameResults("Game ower! The winner is "
                    +(TheGame.humansTurn ? "COMPUTER! Good luck next time!" : "HUMAN. Cheers!"));
        }
        if (TheGame.currentTurn == TheGame.MAX_TURNS)
        {
            gameWindow.setGameResults("It is a draw! Let's try one more time!");
        }

        repaint();
    }

    private void drawX(Graphics g, int cellX, int cellY){
        g.setColor(Color.BLUE);
        ((Graphics2D)g).setStroke(new BasicStroke(5f));

        g.drawLine(cellX * cellWidth+5, cellY*cellHeigth+5, cellX*cellWidth+cellWidth-5,cellY*cellHeigth+cellHeigth-5);
        g.drawLine(cellX * cellWidth+5, cellY*cellHeigth+cellHeigth-5, cellX*cellWidth+cellWidth-5,cellY*cellHeigth+5);
    }

    private void drawO(Graphics g, int cellX, int cellY){
        g.setColor(Color.RED);
        ((Graphics2D)g).setStroke(new BasicStroke(5f));

        g.drawOval(cellX*cellWidth+5, cellY*cellHeigth+5, cellWidth-10, cellHeigth-10);
    }

    private void  drawWinningLine(Graphics g, int cellX, int cellY, String direction){
        int shiftX = 0;
        int shiftY = 0;
        switch (direction) {
            case "down":
                shiftX = 0;
                shiftY = 1;
                break;
            case "right":
                shiftX = 1;
                shiftY = 0;
                break;
            case "diag_up":
                shiftX = 1;
                shiftY = -1;
                break;
            case "diag_down":
                shiftX = 1;
                shiftY = 1;
        }

        int startX = cellX*cellWidth+cellWidth/2;
        int startY = cellY*cellHeigth+cellHeigth/2;
        int finishX = cellX*cellWidth+cellWidth/2 + shiftX*(TheGame.DOTS_TO_WIN-1)*cellWidth;
        int finishY = cellY*cellHeigth+cellHeigth/2 + shiftY*(TheGame.DOTS_TO_WIN-1)*cellHeigth;

        g.setColor(Color.GREEN);
        ((Graphics2D)g).setStroke(new BasicStroke(10f));

        g.drawLine(startX, startY, finishX, finishY);

    }
}

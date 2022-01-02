package hw8;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TheGame {

    static char[][] map;
    static int SIZE = 3; //размер поля, зависит от уровня сложности. MIN = 3x3. +1 lvl = +2 к размеру поля
    static int DOTS_TO_WIN = 3; //кол-во точек для победы, зависит от уровня сложности. MIN = 3. +1 lvl = +1 к кол-ву точек для победы

    static final char DOT_EMPTY = '*';
    static final char DOT_X = 'X';
    static final char DOT_0 = '0';

    static int MAX_TURNS; //максимальное кол-во ходов = кол-во ячеек
    static int currentTurn;

    static boolean humansTurn; //ход игрока
    static char DOT_HUMAN;
    static char DOT_AI;
    static boolean WIN; //признак победы
    static int winningCellX;
    static int winningCellY;
    static String winnignDirrection;
    static boolean GAME_END;

    public static Random rnd = new Random();

    public static void playRound() {
        //проверка текущего хода
        if (!WIN && currentTurn<MAX_TURNS) {
            WIN = checkTheWin(humansTurn, true);
            currentTurn++;
            humansTurn = !humansTurn;
        }
        //если ходил игрок и игра продолжается - передаём ход компьютеру (он вызовет опять эту функцию)
        if (!WIN && currentTurn<MAX_TURNS && !humansTurn) {
            aiTurn();
        } else if (WIN || currentTurn==MAX_TURNS)
        //else if - исключаем повторный вывод результатов после победного хода компьютера в рекурсии хода компьютера
        {
            GAME_END = true;
        }
    }


    public static void initGame(){

        WIN = false;
        currentTurn = 0;
        GAME_END = false;
        MAX_TURNS = SIZE*SIZE;
        map = new char[SIZE][SIZE];

        for (int i=0; i<SIZE; i++){
            for (int j=0; j<SIZE; j++){
                map[i][j] = DOT_EMPTY;
            }
        }

        humansTurn  = rnd.nextBoolean(); //рандом кто будет ходить первым
        DOT_HUMAN   = (humansTurn ? DOT_X : DOT_0); //фишки игрока
        DOT_AI      = (humansTurn ? DOT_0 : DOT_X); //фишки компьютера

        if (!humansTurn){
            aiTurn();
        }
    }


    public static boolean checkTheWin(boolean itIsHuman, boolean saveWinResult) {
        for (int i=0; i<SIZE; i++){
            for (int j=0; j<SIZE; j++)
            {
                if ((checkPoint_down(i, j, itIsHuman, saveWinResult))
                        || (checkPoint_right(i, j, itIsHuman, saveWinResult))
                        || (checkPoint_diag_up(i, j, itIsHuman, saveWinResult))
                        || (checkPoint_diag_down(i, j, itIsHuman, saveWinResult))) return true;
            }
        }
        return false;
    }

    //проверка по вертикали
    private static boolean checkPoint_down(int i,int j, boolean human, boolean saveWinResult) {
        if (i+DOTS_TO_WIN>SIZE) return false; else {
            for (int t=0; t<DOTS_TO_WIN;t++){
                if (map[i+t][j] != (human ? DOT_HUMAN : DOT_AI)) return false;
            }
            if (saveWinResult) {
                saveWinningLine(i,j,"down");
            }
            return true;
        }
    }

    //проверка по горизонтали
    private static boolean checkPoint_right(int i,int j, boolean human, boolean saveWinResult) {
        if (j+DOTS_TO_WIN>SIZE) return false; else {
            for (int t=0; t<DOTS_TO_WIN;t++){
                if (map[i][j+t] != (human ? DOT_HUMAN : DOT_AI)) return false;
            }
            if (saveWinResult) {
                saveWinningLine(i,j,"right");
            }
            return true;
        }
    }

    //проверка диагонали вверх
    private static boolean checkPoint_diag_up(int i,int j, boolean human, boolean saveWinResult) {
        if ((j+DOTS_TO_WIN>SIZE) || (i-DOTS_TO_WIN+1<0)) return false; else {
            for (int t=0; t<DOTS_TO_WIN;t++){
                if (map[i-t][j+t] != (human ? DOT_HUMAN : DOT_AI)) return false;
            }
            if (saveWinResult) {
                saveWinningLine(i,j,"diag_up");
            }
            return true;
        }
    }

    //проверка диагонали вниз
    private static boolean checkPoint_diag_down(int i,int j, boolean human, boolean saveWinResult) {
        if ((j+DOTS_TO_WIN>SIZE) || (i+DOTS_TO_WIN>SIZE)) return false; else {
            for (int t=0; t<DOTS_TO_WIN;t++){
                if (map[i+t][j+t] != (human ? DOT_HUMAN : DOT_AI)) return false;
            }
            if (saveWinResult) {
                saveWinningLine(i,j,"diag_down");
            }
            return true;
        }
    }

    private static void saveWinningLine(int y, int x, String line) {
        winningCellX = x;
        winningCellY = y;
        winnignDirrection = line;
    }

    public static void humanTurn(int x, int y) {
        if (!GAME_END) {
            if (correctCell(x, y)) {
                map[y][x] = DOT_HUMAN;
                playRound();
            }
        }
    }

    public static boolean correctCell(int x,int y) {
        if (x<0 || x>SIZE-1 || y<0 || y> SIZE-1) return false;
        else return (map[y][x] == DOT_EMPTY);
    }

    public static void aiTurn() {
        if (!checkWinOnNextTurn(false)) {
            //победы следующим ходом нет => проверим поражение следующим ходом
            if (!checkWinOnNextTurn(true)) {
                //поражения следующим ходом нет =>> делаем рандомный ход
                randomPoint();
            }
        }
        playRound();
    }

    public static boolean checkWinOnNextTurn(boolean itIsHuman) {

        for (int i=0; i<SIZE; i++) {
            for (int j=0; j<SIZE; j++) {

                if (correctCell(j,i)) {
                    map[i][j] = (itIsHuman ? DOT_HUMAN : DOT_AI);
                    if (checkTheWin(itIsHuman, !itIsHuman)) {
                        if (itIsHuman) map[i][j] = DOT_AI;
                        return true;
                    }
                    map[i][j] = DOT_EMPTY; //возвращаем пустое значение ячейки
                }
            }
        }
        //если не было победных ходов
        return false;
    }

    //ход компуктера в рандомную точку
    public static void randomPoint() {
        int x,y;
        do {
            x = rnd.nextInt(SIZE);
            y = rnd.nextInt(SIZE);
        } while (!correctCell(x,y));
        map[y][x]= DOT_AI;
    }
}

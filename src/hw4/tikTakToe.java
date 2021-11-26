package hw4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class tikTakToe {

    public static char[][] map;
    public static int SIZE; //размер поля, зависит от уровня сложности. MIN = 3x3. +1 lvl = +2 к размеру поля
    public static int DOTS_TO_WIN; //кол-во точек для победы, зависит от уровня сложности. MIN = 3. +1 lvl = +1 к кол-ву точек для победы

    public static final char DOT_EMPTY = '*';
    public static final char DOT_X = 'X';
    public static final char DOT_0 = '0';

    public static int LEVEL; //уровень сложности
    public static int MAX_TURNS; //максимальное кол-во ходов = кол-во ячеек

    public static boolean humansTurn; //ход игрока
    public static char DOT_HUMAN;
    public static char DOT_AI;
    public static boolean WIN; //признак победы

    public static Scanner scan = new Scanner(System.in);
    public static Random rnd = new Random();

    public static void main(String[] args) {

        initGame();
        int currentTurn = 0;
        do {
            currentTurn++;
            drawGameField();
            System.out.println("===== #"+currentTurn+": ХОД "+(humansTurn ? "ЧЕЛОВЕКА" : "КОМПЬЮТЕРА")+" =====");
            if (humansTurn)  humanTurn(); else aiTurn();
            WIN = checkTheWin(map, humansTurn);
            humansTurn = !humansTurn;
        } while (!WIN && currentTurn<MAX_TURNS);
        gameResult(currentTurn);
    }

    public static void gameResult(int Turn) {
        drawGameField();
        String result = "Игра завершилась на "+Turn+" ходе ";
        if (WIN) result+=(humansTurn ? " победой КОМПЬЮТЕРА!" : " победой ИГРОКА!");
                else result+="боевой НИЧЬЕЙ!";
        System.out.println(result);
    }

    public static void initGame(){
        LEVEL = 0;
        WIN = false;

        do {
            System.out.println("Введите уровень сложности (от 1 до N):");
            int lvl = scan.nextInt();
            if (lvl>0) LEVEL=lvl;
        } while (LEVEL==0);
        SIZE = 3+(LEVEL-1)*2; //поле с шагом в 2 за каждый уровень сложности. MIN 3x3
        DOTS_TO_WIN = 2+LEVEL;
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
    }

    public static void drawGameField() {
        for (int i=0; i<=SIZE; i++) {
            for (int j=0; j<=SIZE; j++) {
                if (i==0 && j==0) {
                    System.out.print("y\\x\t");
                } else if (i==0)
                {
                    System.out.print(j+"\t");
                } else if (j==0) {
                    System.out.print(i+"\t");
                } else System.out.print(map[i-1][j-1]+"\t");
            }
            System.out.println();
        }
    }

    public static boolean checkTheWin(char[][] gameMap, boolean human) {
        for (int i=0; i<SIZE; i++){
            for (int j=0; j<SIZE; j++)
            {
                if ((checkPoint_down(gameMap, i, j, human))
                        || (checkPoint_right(gameMap, i, j, human))
                        || (checkPoint_diag_up(gameMap, i, j, human))
                        || (checkPoint_diag_down(gameMap, i, j, human))) return true;
            }
        }
        return false;
    }

    public static boolean checkPoint_down(char[][] gameMap, int i,int j, boolean human) {
        if (i+DOTS_TO_WIN>SIZE) return false; else {
            for (int t=0; t<DOTS_TO_WIN;t++){
                if (gameMap[i+t][j] != (human ? DOT_HUMAN : DOT_AI)) return false;
            }
            return true;
        }
    }

    public static boolean checkPoint_right(char[][] gameMap, int i,int j, boolean human) {
        if (j+DOTS_TO_WIN>SIZE) return false; else {
            for (int t=0; t<DOTS_TO_WIN;t++){
                if (gameMap[i][j+t] != (human ? DOT_HUMAN : DOT_AI)) return false;
            }
            return true;
        }
    }

    public static boolean checkPoint_diag_up(char[][] gameMap, int i,int j, boolean human) {
        if ((j+DOTS_TO_WIN>SIZE) || (i-DOTS_TO_WIN+1<0)) return false; else {
            for (int t=0; t<DOTS_TO_WIN;t++){
                if (gameMap[i-t][j+t] != (human ? DOT_HUMAN : DOT_AI)) return false;
            }
            return true;
        }
    }

    public static boolean checkPoint_diag_down(char[][] gameMap, int i,int j, boolean human) {
        if ((j+DOTS_TO_WIN>SIZE) || (i+DOTS_TO_WIN>SIZE)) return false; else {
            for (int t=0; t<DOTS_TO_WIN;t++){
                if (gameMap[i+t][j+t] != (human ? DOT_HUMAN : DOT_AI)) return false;
            }
            return true;
        }
    }

    public static void humanTurn() {
        int x,y;
        do {
            System.out.print("Выберите ячейку для хода в формате координат X Y:");
            x = scan.nextInt();
            y = scan.nextInt();
        } while (!correctCell(x-1,y-1,map));
        map[y-1][x-1]= DOT_HUMAN;
    }

    public static boolean correctCell(int x,int y, char[][] gameField) {
        if (x<0 || x>SIZE-1 || y<0 || y> SIZE-1) return false;
                else return (gameField[y][x] == DOT_EMPTY);
    }

    public static void aiTurn() {
       char[][] temp_map = initCopyMap();
       if (!checkWinOnNextTurn(temp_map,false, true, DOT_AI)) {
           //победы следующим ходом нет => проверим поражение следующим ходом
           if (!checkWinOnNextTurn(temp_map,true, true, DOT_AI)) {
              //поражения следующим ходом нет =>> делаем рандомный ход
              randomPoint();
           }
       }
    }

    public static char[][] initCopyMap() {
        char[][] temp_map = new char[SIZE][SIZE];

        //иницилизация копии карты
        for (int i = 0; i < SIZE; i++) {
            temp_map[i] = Arrays.copyOf(map[i],SIZE);
        }
        return temp_map;
    }

    /*
    public static void minMaxStrategy(char[][] temp_map) {
        int bestScore = 0;
        int bestXcoord = 0;
        int bestYcoord = 0;
        for (int i=0; i<SIZE; i++) {
            for (int j=0; j<SIZE; j++){
                if (correctCell(j,i,temp_map)) {
                    int score = howGoodIsThisMove(temp_map, i, j, false);
                }
            }
        }
    }

    public static int howGoodIsThisMove(char[][]tmp_map, int i, int j, boolean itIsHuman) {

    } */

    /*проверяет возможность победы на следующем ходе на копии игрового поля:
    * параметры:
    * itIsHuman - чей ход проверяется;
    * makeMove - если победа достигается на виртуальной карте, то при true ставится маркер в реальном поле
    * dot - метка, которую надо поставить на реальном поле (метка AI для победы / предотвращения поражения)*/
    public static boolean checkWinOnNextTurn(char[][] temp_map,boolean itIsHuman, boolean makeMove, char dot) {

        for (int i=0; i<SIZE; i++) {
            for (int j=0; j<SIZE; j++) {

                if (correctCell(j,i,temp_map)) {
                    temp_map[i][j] = (itIsHuman ? DOT_HUMAN : DOT_AI);
                    if (checkTheWin(temp_map,itIsHuman)) {
                        //победа следующим ходом существует
                        if (makeMove) map[i][j] = dot; //
                        return true;
                    }
                    temp_map[i][j] = DOT_EMPTY; //возвращаем пустое значение ячейки
                }
            }
        }
        //если не было победных ходов
        return false;
    }



    public static void randomPoint() {
        int x,y;
        do {
            x = rnd.nextInt(SIZE);
            y = rnd.nextInt(SIZE);
        } while (!correctCell(x,y,map));
        map[y][x]= DOT_AI;
    }
}

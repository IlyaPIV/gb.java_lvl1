package hw3;

public class Main {
    public static void main(String[] args) {
        printLine(1);
        task1();
        printLine(2);
        task2();
        printLine(3);
        task3();
        printLine(4);
        task4();
        printLine(5);
        task5();
        printLine(6);

    }

    public static void printLine(int num){
        System.out.println("===== #"+num+" =====");
    }

    public static void task1(){
        int massLength = 10;
        int[] mass = new int[massLength];

        System.out.println("Инициализация массива:");
        for (int i=0; i<massLength; i++)
        {
            mass[i] = (int) (Math.random()*1.45);
            System.out.print(mass[i]+"\t");
        }
        System.out.println("\nИнвертированный массив:");
        for (int i=0; i<massLength; i++){
            mass[i] = (mass[i]==0 ? 1 : 0);
            System.out.print(mass[i]+"\t");
        }
        System.out.println();
    }

    public static void task2(){
        int[] mass = new int[100];
        System.out.println("Генерируем массив:");
        for (int i=0; i<100; ++i){
            mass[i] = i;
            System.out.print(mass[i]+"\t");
        }
        System.out.println();
    }

    public static void printMass(int[] mass){
        for (int i=0; i<mass.length; i++) {
            System.out.print(mass[i]+"\t");
        }
        System.out.println();
    }

    public static void task3(){
        int[] mass = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        System.out.println("Начальный массив:");
        printMass(mass);
        System.out.println("Отредактированный массив:");
        for (int i=0;i<mass.length;i++){
            if (mass[i]<6) mass[i]*=2;
            System.out.print(mass[i]+"\t");
        }
        System.out.println();
    }

    public static void task4(){
        int[][] mass = new int[5][5];
        for (int i=0; i<5; i++){
            for (int j=0; j<5; j++){
                mass[i][j] = (i==j ? 1 : 0);
            }
        }
        System.out.println("Получившийся двухмерный массив:");
        for (int i=0;i<5; i++){
            printMass(mass[i]);
        }
    }

    public static int[] initMass(int length, int initValue, boolean fix){
        int[] mass = new int[length];
        for (int i=0; i<length; i++) {
            if (fix) {
                mass[i] = initValue;
            } else {
                mass[i] = (int) (Math.random()*initValue);
            }
        }
        return mass;
    }

    public static void task5(){
        int[] mass = initMass(7,33, true);
        System.out.println("Инициированный массив:");
        printMass(mass);
    }

}

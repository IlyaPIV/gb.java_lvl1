package hw3;

import java.util.Arrays;

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
        task6();
        printLine(7);
        task7();
        printLine(8);
        task8();
    }

    public static void printLine(int num){
        System.out.println("===== #"+num+" =====");
    }

/*  1. Задать целочисленный массив, состоящий из элементов 0 и 1.
    Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    С помощью цикла и условия заменить 0 на 1, 1 на 0; */

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

    /*2. Задать пустой целочисленный массив длиной 100.
    С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;
     */

    public static void task2(){
        int[] mass = new int[100];
        System.out.println("Генерируем массив:");
        for (int i=0; i<100; ++i){
            mass[i] = i;
            System.out.print(mass[i]+"\t");
        }
        System.out.println();
    }

    //печать одномерного массива

    public static void printMass(int[] mass){
        for (int i=0; i<mass.length; i++) {
            System.out.print(mass[i]+"\t");
        }
        System.out.println();
    }

    /*3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
    и числа меньшие 6 умножить на 2;
     */

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

    /*4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
    Определить элементы одной из диагоналей можно по следующему принципу:
    индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
     */

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

    /*генератор массива. параметры:
    * - длина массива;
    * - фиксированное значение / диапазон рандома;
    * - фиксированное или случайное значение; */

    public static int[] initMass(int length, int initValue, boolean fix){
        int[] mass = new int[length];
        for (int i=0; i<length; i++) {
             mass[i] = (fix ? initValue : (int) (Math.random()*initValue));
        }
        System.out.println("Инициированный массив:");
        System.out.println(Arrays.toString(mass));
        return mass;
    }

    /*5. Написать метод, принимающий на вход два аргумента: len и initialValue,
     и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue;
      */

    public static void task5(){
        int[] mass = initMass(7,33, true);
    }

    /*6. * Задать одномерный массив и найти в нем минимальный и максимальный элементы ; */

    public static void task6(){
        int[] mass = initMass(7,33, false);

        int minValue = mass[0];
        int maxValue = mass[0];
        for (int i=1; i<mass.length; i++){
            if (mass[i]<minValue) minValue=mass[i];
            if (mass[i]>maxValue) maxValue=mass[i];
        }
        System.out.println("MIN значение = "+minValue);
        System.out.println("MAX значение = "+maxValue);
    }

    /*7. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
    метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
     */

    public static void task7(){
        int[] mass = initMass(11, 5, false);
        boolean theSame = checkMassHalfs(mass);
        System.out.println(theSame ? "Имеются две равные части лево-право" : "Не имеется двух равных частей" );
     }

    public static boolean checkMassHalfs(int[] mass){
        int summL = 0;
        for (int i=0; i<mass.length; i++){
            int summR = 0;
            summL+=mass[i];
            if (i+1!=mass.length){
                for (int j=i+1; j<mass.length;j++) summR+=mass[j];
            }
            if (summL==summR)   return true;
        }
        return false;
    }

    /*8. *** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
    при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично.
    Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ];
    [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
    При каком n в какую сторону сдвиг можете выбирать сами.
     */

    public static void task8(){
        int[] mass = initMass(7, 10, false);

        int n = (int) (Math.random()*10-5);
        mass = changeMass(mass,n);
        System.out.println("Изменённый массив:");
        //printMass(mass);
        System.out.println(Arrays.toString(mass));
    }

    public static int[] changeMass(int[] mass, int n){
        int temp;
        System.out.println("Сдвиг массива на "+n+" элементов");
        for (int count=0; count<(n<0 ? -n: n); count++) {
            if (n>0) {
                temp = mass[mass.length-1]; //последний элемент в память
                for (int i=mass.length-1;i>0;i--){
                    mass[i]=mass[i-1]; //смещаем вправо
                }
                mass[0] = temp; //в первый элемент помещаем старый последний
            } else {
                temp = mass[0]; //первый элемент в память
                for (int i=0;i<mass.length-1;i++){
                    mass[i]=mass[i+1]; //смещаем влево
                }
                mass[mass.length-1] = temp; //в последний элемент помещаем старый первый
            }
        }

        return mass;
    }
}

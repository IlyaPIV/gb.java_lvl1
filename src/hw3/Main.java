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
        task6();
        printLine(7);
        task7();
        printLine(8);
        task8();
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
        System.out.println("Инициированный массив:");
        printMass(mass);
        return mass;
    }

    public static void task5(){
        int[] mass = initMass(7,33, true);
    }

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

    public static void task7(){
        int[] mass = initMass(11, 5, false);
        boolean theSame = checkMass(mass);
        System.out.println(theSame ? "Имеются две равные части лево-право" : "Не имеется двух равных частей" );
     }

    public static boolean checkMass(int[] mass){
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

    public static void task8(){
        int[] mass = initMass(7, 10, false);

        int n = (int) (Math.random()*10-5);
        mass = changeMass(mass,n);
        System.out.println("Изменённый массив:");
        printMass(mass);
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

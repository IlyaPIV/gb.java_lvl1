package hw3;

public class Main {
    public static void main(String[] args) {
        printLine(1);
        task1();
        printLine(2);
        task2();
        printLine(3);
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
}

package hw1;

public class Main {

    public static void main(String[] args) {
        printLine(2);
        printThreeWords();
        printLine(3);
        checkSumSign();
        printLine(4);
        short a = (short) (Math.random()*200-100);
        short b = (short) (Math.random()*100);
        printColor(a);
        printLine(5);
        compareNumbers(a,b);
    }

    public static void printLine(int num){
        System.out.println("===== #"+num+" =====");
    }

    public static void printThreeWords(){
        System.out.println("Orange");
        System.out.print("Banana\n");
        String word = "Apple";
        System.out.println(word);
    }

    public static void checkSumSign(){
        short a = (short) (Math.random()*1000-1000);
        short b = (short) (Math.random()*1000);

        System.out.println("A = "+a);
        System.out.println("B = "+b);
        String summ;
        if ((a+b)<0) {
            summ = "отрицательная сумма";
        } else {
            summ = "положительная сумма";
        }
        System.out.printf("%d + %d = %d (%s)%n", a,b,a+b,summ);

    }

    public static void printColor(short t){
        System.out.println("t = "+t);
        //правильный способ
        if (t<=0) {
            System.out.println("Красный");
        } else if (t<=100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
        //способ для новичков
        if (t<=0) {
            System.out.println("Красный");
        }
        if (t>0 && t<=100) {
            System.out.println("Желтый");
        }
        if (t>100) {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers(short a, short b){
        if (a>=b) {
            System.out.printf("%d >= %d\n",a,b);
        } else {
            System.out.printf("%d < %d\n",a,b);
        }
    }

}


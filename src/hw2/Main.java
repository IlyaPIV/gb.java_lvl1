package hw2;

public class Main {
    public static void main(String[] args) {
        printLine(1);
        task1();
        printLine(2);
        //объединенные пункты ДЗ 2 и 3
        int num = (int) (Math.random()*10-10);
        System.out.println(num + " - это " +task2(num));
        printLine(3);
        System.out.println("см. выше");
        printLine(4);
        num = (int) (Math.random()*10+1); //исключаем 0 из рандома
        task4("Мама мыла раму",num);
        printLine(5);
        num = (int) (Math.random()*2000);
        if (task5(num)){
            System.out.printf("Год %d является високосным\n",num);
        } else  {
            System.out.printf("Год %d НЕ високосный\n",num);
        }
    }

    public static void printLine(int num){
        System.out.println("===== #"+num+" =====");
    }

    public static void task1(){
        int a = (int) (Math.random()*10);
        int b = (int) (Math.random()*10);
        System.out.println("A = "+a+"; B = "+b);
        if (check_sum(a,b)) {
            System.out.println("Сумма А и В попадает в диапазон от 10 по 20");
        } else {
            System.out.println("Сумма А и В находится вне диапазона от 10 по 20");
        }
    }

    public static boolean check_sum(int a, int b){
        return ((a+b)>10 && (a+b)<=20);
    }

    public static String task2(int num){

        if (num>0){
            return "положительное число";
        }  else
        {
            return "отрицательное число";
        }
    }

    public static void task4(String s, int n)
    {
        System.out.printf("Повторяем фразу %d раз:\n",n);
        int count = 0;
        while (count++<n){
            System.out.println(s);
        }
    }

    public static boolean task5(int year)
    {
        if (year%400==0){
            return true;
        } else if (year%100==0){
            return false;
        } else return year % 4 == 0;
    }
}

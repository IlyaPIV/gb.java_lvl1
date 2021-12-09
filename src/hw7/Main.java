package hw7;

import java.util.Random;

public class Main {

    public static final int NUMBER = 10;

    public static void main(String[] args) {

        Cat[] cats = new Cat[NUMBER];
        initCats(cats);
        Plate plate = new Plate(100);
        feedCats(cats,plate);
        statusOfCats(cats);
    }

    public static void initCats(Cat[] cats){
        Random rnd = new Random();
        for (int i = 0; i < NUMBER ; i++) {
            String catName = "Новый_Барсик_"+(i+1);
            cats[i] = new Cat(catName, rnd.nextInt(3)*10+5); //округляем до красивых чисел (5/10/15/20/25/30/35)
        }
        //return cats;
    }

    public static void feedCats(Cat[] cats, Plate plate){
        for (int i = 0; i < NUMBER; i++) {
            System.out.print("Статус тарелки ДО кормёжки: ");
            plate.info();
            cats[i].eat(plate);
            System.out.print("Статус тарелки ПОСЛЕ кормёжки: ");
            plate.info();
        }
        //return cats;
    }

    public static void statusOfCats(Cat[] cats){
        System.out.println("Текущее состояние котиков:");
        for (int i = 0; i < NUMBER; i++) {
            cats[i].status();
        }
    }
}

package hw6;

import hw6.Animals.Animal;
import hw6.Animals.Dog;
import hw6.Animals.Cat;

import java.util.Random;

public class Main {
    static Random rnd = new Random();
    static String[] dog_names = {"Рэкс", "Дружок", "Жужа", "Муму", "Мухтар"};
    static String[] cat_names = {"Мурка", "Барсик", "Борис", "Муркало", "Черныш"};
    static final int number_of_animals = 5;

    public static void main(String[] args) {
        Animal[] zoo = new Animal[number_of_animals];
        initZoo(zoo);
        System.out.println("==================//====================");
        testZoo(10,zoo);
    }

    private static Animal[] initZoo(Animal[] zoo){
        Animal new_animal;
        for (int i=0; i<zoo.length; i++) {

            new_animal = (rnd.nextBoolean() ? new_Dog(i) : new_Cat(i));
            new_animal.calculateInit();
            zoo[i] = new_animal;
        }
        return zoo;
    }

    private static Animal new_Dog(int i){
        return new Dog(dog_names[i]);
    }

    private static Animal new_Cat(int i){
        return new Cat(cat_names[i]);
    }

    private static void testZoo(int tasksCount,Animal[] zoo){
        for (int i = 0; i < tasksCount; i++) {
            int j = rnd.nextInt(number_of_animals); //случайное животное
            int rangeDistance = rnd.nextInt(600); //случайная дистанция
            if (rnd.nextBoolean()) {
                zoo[j].swim(rangeDistance); //заставляем плыть
            } else {
                zoo[j].run(rangeDistance); //заставляем бежать
            }
        }
    }
}

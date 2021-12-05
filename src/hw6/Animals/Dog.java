package hw6.Animals;

public class Dog extends Animal{

    static int number_of_representative;

    public Dog(String name){
        super(name,500,200);
        number_of_representative++;
    }

    public void calculateInit(){
        System.out.printf("Появился пёсель %s!\n", name);
        System.out.println("Всего пёсэ на данный момент: "+number_of_representative);
        super.calculate();
    }

    public void swim(int length){
        String message = "Пёсэ " + name + " ПРОПЛЫЛ на " +
                (length>MAX_RUN ? (MAX_RUN + " метров из "+length +"." ): (length+" метров! Гав!"));
        System.out.println(message);
    }

    public void run(int length){
        String message = "Пёсэ " + name + " ПРОБЕЖАЛ на " +
                (length>MAX_RUN ? (MAX_RUN + " метров из "+length +"." ): (length+" метров! Гав!"));
        System.out.println(message);
    }
}

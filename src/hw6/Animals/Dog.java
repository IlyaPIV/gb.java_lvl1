package hw6.Animals;

public class Dog extends Animal{

    private final static int MAX_RUN = 500;
    private final static int MAX_SWIM = 200;
    static int number_of_representative;

    public Dog(String name){
        super(name);
        number_of_representative++;
    }

    public void calculateInit(){
        System.out.printf("Появился пёсель %s!\n", name);
        System.out.println("Всего пёсэ на данный момент: "+number_of_representative);
        super.calculate();
    }

    public void swim(int length){
        String message = "Пёсэ " + name + " проплыл на " +
                (length>MAX_RUN ? (MAX_RUN + " метров из "+length +"." ): (length+" метров! Гав!"));
        System.out.println(message);
    }

    public void run(int length){
        String message = "Пёсэ " + name + " пробежал на " +
                (length>MAX_RUN ? (MAX_RUN + " метров из "+length +"." ): (length+" метров! Гав!"));
        System.out.println(message);
    }
}

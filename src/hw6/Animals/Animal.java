package hw6.Animals;

public abstract class Animal {
    String name;
    final static int MAX_RUN = 0;

    static int number_of_representative;

    public Animal(String name){
        this.name = name;
        number_of_representative++;
    }

    public abstract void run(int length);

    public abstract void swim(int length);

    public void calculate(){
        System.out.printf("Всего животных на данный момент: %d штук\n",number_of_representative);
    }

    public abstract void calculateInit();
}

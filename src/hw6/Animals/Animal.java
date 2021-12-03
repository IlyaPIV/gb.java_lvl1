package hw6.Animals;

public abstract class Animal {
    protected String name;
    protected int MAX_RUN;
    protected int MAX_SWIM;

    static int number_of_representative;

    public Animal(String name, int maxRunDistance, int maxSwimDistance){
        this.name = name;
        this.MAX_RUN = maxRunDistance;
        this.MAX_SWIM = maxSwimDistance;
        number_of_representative++;
    }

    public abstract void run(int length);

    public abstract void swim(int length);

    public void calculate(){
        System.out.printf("Всего животных на данный момент: %d штук\n",number_of_representative);
    }

    public abstract void calculateInit();
}

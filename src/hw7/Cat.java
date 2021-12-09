package hw7;

public class Cat {
    private String name;
    private int appetite;
    private boolean isFeeded;

    public Cat(String name, int appetite){
        this.name = name;
        this.appetite = appetite;
        this.isFeeded = false;
    }

    public void eat(Plate p){
        this.isFeeded = p.decreaseFood(appetite, this);
    }

    public void status(){
        System.out.printf("Кот %s "+(isFeeded ? "сыт\n" : "голоден\n"),this.name);
    }

    public String getName() {
        return name;
    }
}

package hw7;

public class Plate {
    private int food;

    public Plate(int food){
        this.food = food;
    }

    public void info(){
        System.out.println("остаток еды в тарелке = "+food);
    }

    public boolean decreaseFood(int n, Cat cat){
        if (food == 0) {
            System.out.println("Тарелка пуста.");
            increaseFood(50);
        }
        int count = (n<=food ? n : 0);
        food -= count;
        System.out.printf("Кот %s съел %d единиц корма\n",cat.getName(),count);
        return n<=food;
    }

    public void increaseFood(int food){
        this.food += food;
        System.out.printf("В тарелку досыпали %d единиц корма.\n",food);
    }
}

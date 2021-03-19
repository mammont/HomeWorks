package Level1.HomeWork7;

public class Plate {
    private int food;
    public Plate(int food) {
        this.food = food;
    }
    public boolean decreaseFood(int n) {
        if (n < food) {
            food -= n;
            System.out.println("еда -" + n);
            return true;
        }
        else {
            System.out.println("Еды в тарелке не достаточно.");
            return false;
        }
    }

    public void addFood(int n){
        this.food = food + n;
        System.out.printf("В тарелку добавлено %s еды. %n", n);
    }

    public int getFood() {
        return food;
    }

    public void info() {
        System.out.printf("В тарелке %s еды. %n", food);
    }
}

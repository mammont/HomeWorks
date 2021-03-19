package Level1.HomeWork7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;
    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }
    public void eat(Plate plate) {
        String isHungry = !satiety ? "Голодный" : "Сытый";
        System.out.printf("%s кот %s с аппетитом %s подошёл к тарелке с едой. В тарелке %s еды. %n",
                isHungry, name, appetite, plate.getFood());
        if (!satiety && plate.decreaseFood(appetite)) {
            System.out.printf("Кот %s съел %s еды %n", name, appetite);
            satiety = true;
        }
    }
    void info(){
        String isHungry = !satiety ? "голоден" : "сыт";
        System.out.printf("Кот %s %s. %n", name, isHungry);
    }
}


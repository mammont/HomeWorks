package Level2.HomeWork1;

public class Human implements Action {
    private String name;
    private int runLimit = 1000;
    private int jumpLimit = 2;
    private boolean onDistance = true;

    public Human(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void jump(int height) {
        if (onDistance) {
            if (height <= jumpLimit) System.out.printf("Человек по имени %s прыгнул на высоту %s %n", name, height);
            else {
                onDistance = false;
                System.out.printf("Человек по имени %s не смог прыгнуть на высоту %s и сходит с дистанции %n", name, height);
            }
        }
    }

    @Override
    public void run(int distance) {
        if (onDistance) {
            if (distance <= runLimit) System.out.printf("Человек по имени %s пробежал %s %n", name, distance);
            else {
                onDistance = false;
                System.out.printf("Человек по имени %s не смог пробежать %s и сходит с дистанции %n", name, distance);
            }
        }
    }
}

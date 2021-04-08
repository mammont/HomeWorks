package Level2.HomeWork1;

public class Cat implements Action{
    private String name;
    private final int runLimit = 500;
    private final int jumpLimit = 5;
    private boolean onDistance = true;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void jump(int height) {
        if (onDistance) {
            if (height <= jumpLimit) System.out.printf("Кот по имени %s прыгнул на высоту %s %n", name, height);
            else {
                onDistance = false;
                System.out.printf("Кот по имени %s не смог прыгнуть на высоту %s и сходит с дистанции %n", name, height);
            }
        }
    }

    @Override
    public void run(int distance) {
        if (onDistance) {
            if (distance <= runLimit) System.out.printf("Кот по имени %s пробежал %s %n", name, distance);
            else {
                onDistance = false;
                System.out.printf("Кот по имени %s не смог пробежать %s и сходит с дистанции %n", name, distance);
            }
        }
    }
}

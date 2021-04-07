package Level2.HomeWork1;

public class Wall extends Barrier {
    private int height;
    public Wall(int height) {
        this.height = height;
    }

    public void moving(Action action) {
        action.jump(height);
    }
}

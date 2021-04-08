package Level2.HomeWork1;

public class Wall implements Barrier {
    private int height;
    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void moving(Action action) {
        action.jump(height);
    }
}

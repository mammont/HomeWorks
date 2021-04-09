package Level2.HomeWork1;

public class Track implements Barrier{
    private int distance;
    public Track(int distance) {
        this.distance = distance;
    }

    @Override
    public void moving(Action action) {
        action.run(distance);
    }
}

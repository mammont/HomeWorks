package Level2.HomeWork1;

public class Track extends Barrier{
    private int distance;
    public Track(int distance) {
        this.distance = distance;
    }

    void moving(Action action) {
        action.run(distance);
    }
}

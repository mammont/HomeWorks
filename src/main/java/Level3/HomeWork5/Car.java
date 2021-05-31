package Level3.HomeWork5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private final CountDownLatch countDownLatchReady;
    private final CountDownLatch countDownLatchFinish;
    private CyclicBarrier cyclicBarrier;
    private Race race;
    private int speed;
    private String name;

    private static boolean winner = false;

    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed, CountDownLatch countDownLatchReady, CountDownLatch countDownLatchFinish, CyclicBarrier cyclicBarrier) {
        this.race = race;
        this.speed = speed;
        this.countDownLatchReady = countDownLatchReady;
        this.countDownLatchFinish = countDownLatchFinish;
        this.cyclicBarrier = cyclicBarrier;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            countDownLatchReady.countDown();
            System.out.println(this.name + " готов");
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        checkWinner(this);

        countDownLatchFinish.countDown();
    }

    private static synchronized void checkWinner(Car car) {
        if (!winner) {
            System.out.println(car.name + " - WIN");
            winner = true;
        }
    }
}

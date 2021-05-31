package Level3.HomeWork5;

public class Tunnel extends Stage {
    public Tunnel(int length) {
        this.length = length;
        this.description = "Тоннель " + length + " метров";
    }
    @Override
    public void go(Car car) {
        try {
            try {
                System.out.println(car.getName() + " готовится к этапу(ждет): " + description);
                System.out.println(car.getName() + " начал этап: " + description);
                Thread.sleep(length / car.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(car.getName() + " закончил этап: " + description);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

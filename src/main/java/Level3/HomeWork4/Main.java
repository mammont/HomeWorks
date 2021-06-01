package Level3.HomeWork4;

public class Main {
    public static void main(String[] args) {
        Abc.printABC a = new Abc.printABC('A', 'B');
        Abc.printABC b = new Abc.printABC('B', 'C');
        Abc.printABC c = new Abc.printABC('C', 'A');

        a.start();
        b.start();
        c.start();
    }
}

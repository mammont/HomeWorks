package Level1.HomeWork1;

//        1. Создать пустой проект в IntelliJ IDEA и прописать метод main().
//        2. Создать переменные всех пройденных типов данных и инициализировать их значения.
public class Main {
    public static void main(String[] args) {
        byte b; short s; int i; long l; float f; double d; boolean bool; char c;
        b = -11;
        s = 3838;
        i = 47474747;
        l = 888L;
        f = 135.005f;
        d = 28.4747747;
        bool = false;
        c = 'Q';

        System.out.println(b);
        System.out.println(s);
        System.out.println(i);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);
        System.out.println(bool);
        System.out.println(c);

        System.out.println(calculate(1.0f, 2.0f, 3.0f, 4.0f));
        checkSum(12,3);
        isPosNeg(-33);
        System.out.println(isPosNegBool(33));
        printHello("Михаил");
        checkYear(2020);
    }
//        3. Написать метод, вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
//           где a, b, c, d – аргументы этого метода, имеющие тип float.
    public static float calculate(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }
//        4. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах
//           от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
    public static boolean checkSum(int x, int y) {
        return x + y >= 10 && x + y <= 20;
        }
//        5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
//           положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
    public static void isPosNeg(int a){
        if (a >= 0) System.out.println("Число " + a + " положительно.");
        else System.out.println("Число " + a + " отрицательно.");
    }
//        6. Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true,
//           если число отрицательное, и вернуть false если положительное.
    public static boolean isPosNegBool(int a){
        return a >= 0;
    }
//        7. Написать метод, которому в качестве параметра передается строка, обозначающая имя. Метод должен вывести
//           в консоль сообщение «Привет, указанное_имя!».
    public static void printHello(String name) {
        System.out.println("Привет, " + name);
    }
//        8. * Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль.
//           Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    public static void checkYear(int year) {
        if(year % 4 == 0 && year % 100 != 0 || year%400==0) System.out.println("Год " + year + " високосный");
        else System.out.println("Год " + year + " не високосный");
    }
}

package Level2.HomeWork2;

// 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При подаче массива
//    другого размера необходимо бросить исключение MyArraySizeException.
// 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
//    Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст
//    вместо числа), должно быть брошено исключение MyArrayDataException с детализацией, в какой именно
//    ячейке лежат неверные данные.
// 3. В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и
//    MyArrayDataException и вывести результат расчета (сумму элементов, при условии что подали на вход
//    корректный массив).

public class Main {
    public static void main(String[] args) {

        String[][] arr1 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"},
                {"17"}
        };

        String[][] arr2 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "QQQ"}
        };

        String[][] arr3 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            System.out.println(ArrayInt4x4SumElements.sumElements(arr1));
        }
        catch (MyException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(ArrayInt4x4SumElements.sumElements(arr2));
        }
        catch (MyException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(ArrayInt4x4SumElements.sumElements(arr3));
        }
        catch (MyException e) {
            e.printStackTrace();
        }
    }
}

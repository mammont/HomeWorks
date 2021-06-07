package Level3.HomeWork6;

import java.util.Arrays;

/*
1. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив. Метод
   должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов, идущих после
   последней четверки. Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо выбросить
   RuntimeException.
    Написать набор тестов для этого метода (по 3-4 варианта входных данных).
    Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
    Вх: [ 1 2 4 4 2 3 4 ] -> вых: [ ].
    Вх: [ 1 2 44 2 34 1 2 ] -> вых: RuntimeException.
    Вх: [ 1 2 1 7 ] -> вых: RuntimeException.

2. Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки или единицы,
   то метод вернет false; если в нем есть что то, кроме 1 и 4, то метод вернет false; Написать набор тестов для этого
   метода (по 3-4 варианта входных данных).
    [ 1 1 1 4 4 1 4 4 ] -> true
    [ 1 1 1 1 1 1 ] -> false
    [ 4 4 4 4 ] -> false
    [ 1 4 4 1 1 4 3 ] -> false
 */
public class Main {
    public static int[] getFrom4ToInfinity(int[] array) throws RuntimeException {
        if (array.length == 0) { throw new NullPointerException("Массив пуст"); }
        int index4 = 0;
        for (int i = 0; i < array.length; i++) if (array[i] == 4) index4 = i + 1;
        if (index4 == 0) throw new RuntimeException("В массиве нет 4");
        else return Arrays.copyOfRange(array, index4, array.length);
    }

    public static boolean check1And4(int[] arr) {
        int el1 = 0, el4 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) el1++;
            else if (arr[i] == 4) el4++;
            else return false;
        }
        return (el1 > 0 && el4 > 0);
    }
}

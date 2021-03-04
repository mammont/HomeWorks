package Level1.HomeWork2;

public class Main {
    public static void main(String[] args) {

        int[] array1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        printArray(array1);
        revertArray(array1);
        printArray(array1);


        int[] array2 = new int[8];
        make3Array(array2);
        printArray(array2);


        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        printArray(array3);
        multiplyArrayBy6(array3);
        printArray(array3);

        int i = 9;
        int[][] array4 = new int[i][i];
        print2Array(array4);
        fillDiagonalBy1(array4);
        print2Array(array4);


        findMinMaxInArray(array3);


        int[] array5 = {2, 2, 2, 1, 2, 2, 10, 1};
        int[] array6 = {1, 1, 1, 2, 1};
        System.out.println(checkBalance(array5));
        System.out.println(checkBalance(array6));

        int[] array7 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n = 23;
        int m = -23;
        moveArray(array7, n);
        moveArray(array7, m);
    }
    static void printArray(int[] array){
        System.out.println("-------------------");
        for (int i = 0; i < array.length; i++) System.out.print(array[i] + " ");
        System.out.println();
    }
    static void print2Array(int[][] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                System.out.print(numbers[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }
//    1. Задать целочисленный массив, состоящий из элементов 0 и 1.
//       Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
    static int[] revertArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) array[i] = 0;
            else array[i] = 1;
        }
        return array;
    }

//    2. Задать пустой целочисленный массив размером 8.
//       С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    static int[] make3Array(int[] array){
        for (int i = 0; i < array.length; i++) array[i] = i * 3;
        return array;
    }

//    3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
//       и числа меньшие 6 умножить на 2;
    static int[] multiplyArrayBy6(int[] array){
        for (int i = 0; i < array.length; i++) if (array[i] < 6) array[i] = array[i] * 6;
        return array;
    }

//    4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое)
//       и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    static int[][] fillDiagonalBy1(int[][] array){
        for (int i = 0; i < array.length; i++) {
            array[i][i] = 1;
            array[array.length - 1 - i][i] = 1;
        }
        return array;
    }

//    5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    static void findMinMaxInArray(int[] array) {
        System.out.println("В массиве: ");
        printArray(array);
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) max = array[i];
            if (array[i] < min) min = array[i];
        }
        System.out.println("Максимальный элемет: " + max + " \nМинимальный элемент: " + min);
    }

//    6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
//    метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части
//    массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
//    checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
    static boolean checkBalance(int[] array){
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < array.length; i++) {
            rightSum = rightSum + array[i];
        }
        for (int i = 0; i < array.length - 1; i++) {
            leftSum = leftSum + array[i];
            rightSum = rightSum - array[i];
            if (rightSum == leftSum) {
                return true;
            }
        }
        return false;
    }

//    7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
//       или отрицательным), при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются
//       циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
//       Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ];
//       [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
//       При каком n в какую сторону сдвиг можете выбирать сами.
    static int[] moveArray(int[] array, int n) {
        printArray(array);
        int buffer;
        if (Math.abs(n) > array.length) n = n % array.length; // для меньшего количества итераций
        if (n == 0) return array;
        if (n > 0) {
            for (int k = 0; k < n; k++){
                buffer = array[0];
                for (int i = 0; i < array.length-1; i++) array[i] = array[i + 1];
                array[array.length-1]=buffer;
//                printArray(array);
            }
        }
        if (n < 0) {
            for (int k = 0; k > n; k--) {
                buffer = array[array.length-1];
                for (int i = array.length-1; i > 0; i--) array[i] = array[i - 1];
                array[0] = buffer;
//                printArray(array);
            }
        }
        printArray(array);
        return array;
    }
}
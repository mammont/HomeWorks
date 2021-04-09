package Level2.HomeWork2;

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
            System.out.println(Method.method(arr1));
        }
        catch (MyException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(Method.method(arr2));
        }
        catch (MyException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(Method.method(arr3));
        }
        catch (MyException e) {
            e.printStackTrace();
        }
    }
}
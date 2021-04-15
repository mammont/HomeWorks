package Level2.HomeWork2;

public class ArrayInt4x4SumElements {
    public static int method(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (arr.length != MyArraySizeException.dimension) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != MyArraySizeException.dimension) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j, arr[i][j]);
                }
            }
        }
        return sum;
    }
}

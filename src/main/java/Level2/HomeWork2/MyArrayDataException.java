package Level2.HomeWork2;

public class MyArrayDataException extends MyException {
    public MyArrayDataException(int i, int j, String msg) {
        super(String.format("Недопустимое значение %s в ячейке [%s][%s]", msg, i, j));
    }
}

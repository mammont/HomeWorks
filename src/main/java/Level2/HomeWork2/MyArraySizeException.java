package Level2.HomeWork2;

public class MyArraySizeException extends MyException {
    static final int dimension = 4;
    MyArraySizeException(){
        super(String.format("Размерность массива должна быть %sx%s!!!", dimension, dimension));
    }
}

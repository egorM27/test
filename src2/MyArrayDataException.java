package lesson2;

public class MyArrayDataException extends RuntimeException {

    private int i;
    private int j;

    public MyArrayDataException(String message, int i, int j) {
        super(String.format("НЕВЕРНЫЙ ФОРМАТ ДАННЫХ В ЯЧЕЙКЕ [%s, %d] В МАССИВЕ", i, j));
        this.i = i;
        this.j = j;
    }

}

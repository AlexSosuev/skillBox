package practice.twoDimensionalArray;

public class TwoDimensionalArray {

    public static final char SYMBOL = 'X';

    public static char[][] getTwoDimensionalArray(int size) {
        char[][] array = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j || j == size - 1 - i) {
                    array[i][j] = 'X';
                } else {
                    array[i][j] = ' ';
                }
            }
        }
        return array;
    }
}

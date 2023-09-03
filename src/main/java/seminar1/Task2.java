package seminar1;

/*
Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
Необходимо посчитать и вернуть сумму элементов этого массива.
При этом накладываем на метод 2 ограничения:
метод может работать только с квадратными массивами (кол-во строк = кол-ву столбцов),
и в каждой ячейке может лежать только значение 0 или 1.
Если нарушается одно из условий, метод должен бросить RuntimeException с сообщением об ошибке.
 */
public class Task2 {
    public static void main(String[] args) {

        int[][] ints = new int[3][];
        ints[0] = new int[]{0, 1, 0};
        ints[1] = new int[]{1, 1, 1};
        ints[2] = new int[]{0, 1, 0};
        try {
            System.out.println(matrixCount2(ints));
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        System.out.println("Hello World");

    }

    public static int matrixCount(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix.length != matrix[i].length) {
                throw new RuntimeException("Not square matrix");
            }
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0 && matrix[i][j] != 1) {
                    throw new RuntimeException("Element is not 0, 1");
                }
            }
        }

        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result = result + matrix[i][j];
            }
        }
        return result;
    }

    public static int matrixCount2(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix.length != matrix[i].length) {
                throw new RuntimeException("Not square matrix");
            }
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0 && matrix[i][j] != 1) {
                    throw new RuntimeException("Element is not 0, 1");
                }
            }
        }

        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result = result + matrix[i][j];
            }
        }
        return result;
    }


}

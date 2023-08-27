package homework1;

/*
1. Реализуйте метод, принимающий в качестве аргументов двумерный массив.
Метод должен проверить что длина строк и столбцов с одинаковым индексом одинакова,
детализировать какие строки со столбцами не требуется.
 */

public class Task1 {

    public static void main(String[] args) {

        int[][] ints1 = new int[5][];
        ints1[0] = new int[]{1, 2, 3, 4, 5};
        ints1[1] = new int[]{1, 2, 3, 4};
        ints1[2] = new int[]{1, 2, 3};
        ints1[3] = new int[]{1, 2, 3, 4};
        ints1[4] = new int[]{1, 2};

        int[][] ints2 = new int[5][];
        ints2[0] = new int[]{1, 2, 3, 4, 5};
        ints2[1] = new int[]{1, 2, 3, 4, 5};
        ints2[2] = new int[]{1, 2, 3, 4, 5};
        ints2[3] = new int[]{1, 2, 3, 4, 5};
        ints2[4] = new int[]{1, 2, 3, 4, 5};

        int[][] ints3 = null;

        System.out.println(checkArray(ints1));
        System.out.println(checkArray(ints2));
        System.out.println(checkArray(ints3));

    }

    public static boolean checkArray(int[][] arr) {
        try {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (i != j && arr[i].length != arr[j].length) {
                        System.out.println("Строки " + i + " и " + j + " не равны");
                    } else {
                        System.out.println("Строки " + i + " и " + j + " равны");
                    }
                }
            }
        } catch (RuntimeException e){
            return false;
        }
        return true;
    }

}

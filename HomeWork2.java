/**
 * Java. Level 1. Lesson 2. Homework 2
 *
 * @author Olga Petrova
 * @version dated Sep 16, 2018
 */

import java.util.Arrays;

public class HomeWork2 {

    /**
     * 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
     *    С помощью цикла и условия заменить 0 на 1, 1 на 0
     */
    public static void createBinArray() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++)
            arr[i] = (arr[i] == 0)? 1 : 0;
        System.out.println(Arrays.toString(arr));
        System.out.println();
    }

    /**
     * 2. Задать пустой целочисленный массив размером 8.
     *    С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21
     */
    public static void createTripleArray() {
        int[] arr = new int[8];
        for (int i = 0; i < 8; i++)
            arr[i] = i * 3;
        System.out.println(Arrays.toString(arr));
        System.out.println();
    }

    /**
     * 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ],
     *    пройти по нему циклом, и числа меньшие 6 умножить на 2
     */
    public static void createDoubleArray() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++)
            if (arr[i] < 6)
                arr[i] *= 2;
        System.out.println(Arrays.toString(arr));
        System.out.println();
    }

    /**
     * 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
     *    и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
     */
    public static void createQuadrate(int n) {
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            arr[i][i] = 1;
            arr[i][n - i - 1] = 1;
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println();
    }

    /**
     * 5. Задать одномерный массив и найти в нем минимальный и максимальный элементы
     */
    public static void findMinMax() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arr));
        int min, max;
        min = max = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (arr[i] < min)
                min = arr[i];
            if (arr[i] > max)
                max = arr[i];
        }
        System.out.println("min = " + min);
        System.out.println("max = " + max);
        System.out.println();
    }

    /**
     * 6. Написать метод, в который передается непустой одномерный целочисленный массив,
     *    метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части массива равны.
     *    Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false, checkBalance ([10, || 10]) → true,
     *    граница показана символами ||, эти символы в массив не входят
     */
    public static boolean compareSums(int[] arr) {
        boolean res = false;
        int k = 1;
        do {
            int s1 = 0, s2 = 0;            
            for (int i = 0; i < k; i++)
                s1 += arr[i];
            for (int j = k; j < arr.length; j++)
                s2 += arr[j];
            res = s1 == s2;
            k++;
        }
        while (!res && k < arr.length);
    return res;
    }
    
     /**
     * 7. Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
     *    при этом метод должен сместить все элементы массива на n позиций.
     *    Для усложнения задачи нельзя пользоваться вспомогательными массивами
     */
    public static void shiftArray(int[] arr, int n) {
        if (n >= 0) { // shift right
            for (int i = 0; i < n; i++) {
                int cell = arr[arr.length - 1];
                for (int j = arr.length - 1; j > 0; j--)
                    arr[j] = arr[j - 1];
                arr[0] = cell;
            } 
        } else { // shift left
            for (int i = 0; i < n * (-1); i++) {
                int cell = arr[0];
                for (int j = 0; j < arr.length - 1; j++)
                    arr[j] = arr[j + 1];
                arr[arr.length - 1] = cell;
            }
        }
    }

    public static void main(String[] args) {
        // call for task 1
        createBinArray();

        // call for task 2
        createTripleArray();

        // call for task 3
        createDoubleArray();
        
        // tests for task 4
        createQuadrate(5); // odd dimension
        createQuadrate(10); // even dimension

        // call for task 5
        findMinMax();

        // tests for task 6
        int[] testArr1 = {1, 1, 1, 2, 1};
        System.out.println(Arrays.toString(testArr1));
        System.out.println(compareSums(testArr1));
        int[] testArr2 = {2, 1, 1, 2, 1};
        System.out.println(Arrays.toString(testArr2));
        System.out.println(compareSums(testArr2));
        int[] testArr3 = {10, 10};
        System.out.println(Arrays.toString(testArr3));
        System.out.println(compareSums(testArr3));
        System.out.println();
        
        // tests for task 7
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("before\n" + Arrays.toString(arr1));
        shiftArray(arr1, -2); // shift left
        System.out.println("after shift -2 (left)\n" + Arrays.toString(arr1));
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("before\n" + Arrays.toString(arr2));
        shiftArray(arr2, 5); // shift right
        System.out.println("after shift +5 (right)\n" + Arrays.toString(arr2));
    }
}


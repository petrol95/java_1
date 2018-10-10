import java.util.Arrays;

/**
 * Java. Level 1. Lesson 8. Homework 8
 *
 * @author Olga Petrova
 * @version dated Oct 10, 2018
 */
 
// Заполнить матрицу 10х10 по спирали
public class Spiral {

    public static void makeSpiral(int arr[][]) {
        int mid = arr.length / 2;
        arr[mid][mid] = 1;
        int i = mid;
        int j = mid;
        int l = 2;
        for (int n = 0; n < arr.length + 1; n++) {
            for (int k = 0; k < n + 1; k++)
                if(l <= arr.length * arr.length) {
                    j += (int)Math.pow(-1, n + 1);
                    arr[i][j] = l++;
                }
                else
                    return;
            for (int k = 0; k < n + 1; k++)
                if(l <= arr.length * arr.length) {
                    i += (int)Math.pow(-1, n + 1);
                    arr[i][j] = l++;
                }
                else
                    return;
        }
    }

    public static void main(String[] args) {
        int arr[][] = new int[4][4];
        makeSpiral(arr);
        for (int i = 0; i < 4; i++)
            System.out.println(Arrays.toString(arr[i]));
    }
}
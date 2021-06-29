import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * You will be given an array of numbers. You have to sort the odd numbers in
 * ascending order while leaving the even
 * numbers at their original positions.
 * <p>
 * Examples
 * <p>
 * [7, 1]  =>  [1, 7]
 * [5, 8, 6, 3, 4]  =>  [3, 8, 6, 5, 4]
 * [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]  =>  [1, 8, 3, 6, 5, 4, 7, 2, 9, 0]
 */

public class Kata {
    public static int[] sortArray(int[] array) {
        List<Integer> oddList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0){
                oddList.add(array[i]);
                array[i] = -1;
            }
        }
        Collections.sort(oddList);
        for (int i = 0; i <array.length ; i++) {
            if(array[i] == -1){
                array[i] = oddList.get(0);
                oddList.remove(0);
            }
        }
        return array;
    }
}

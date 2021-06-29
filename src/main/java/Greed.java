import java.util.Arrays;

/**
 * Greed is a dice game played with five six-sided dice. Your mission, should you choose to accept it, is to score a throw according to these rules. You will always be given an array with five six-sided dice values.
 * <p>
 * Three 1's => 1000 points
 * Three 6's =>  600 points
 * Three 5's =>  500 points
 * Three 4's =>  400 points
 * Three 3's =>  300 points
 * Three 2's =>  200 points
 * One   1   =>  100 points
 * One   5   =>   50 point
 * <p>
 * A single die can only be counted once in each roll. For example, a given "5" can only count as part of a triplet (contributing to the 500 points) or as a single 50 points, but not both in the same roll.
 * <p>
 * Example scoring
 * <p>
 * Throw       Score
 * ---------   ------------------
 * 5 1 3 4 1   250:  50 (for the 5) + 2 * 100 (for the 1s)
 * 1 1 1 3 1   1100: 1000 (for three 1s) + 100 (for the other 1)
 * 2 4 4 5 4   450:  400 (for three 4s) + 50 (for the 5)
 * <p>
 * In some languages, it is possible to mutate the input to the function. This is something that you should never do. If you mutate the input, you will not be able to pass all the tests.
 */

public class Greed {

    public static int points;


    public static int greedy(int[] dice) {
        points = 0;
        Arrays.sort(dice);
        StringBuilder arr = new StringBuilder();
        for (int tmp : dice) {
            arr.append(tmp);
        }
        StringBuilder extracted = extracted(arr, "111");
        if (extracted.length() == 2) {
            points += 1000;
            searchElement(extracted);
        }
        StringBuilder extracted1 = extracted(arr, "222");
        if (extracted1.length() == 2) {
            points += 200;
            searchElement(extracted1);
        }
        StringBuilder extracted2 = extracted(arr, "333");
        if (extracted2.length() == 2) {
            points += 300;
            searchElement(extracted2);
        }
        StringBuilder extracted3 = extracted(arr, "444");
        if (extracted3.length() == 2) {
            points += 400;
            searchElement(extracted3);
        }
        StringBuilder extracted4 = extracted(arr, "555");
        if (extracted4.length() == 2) {
            points += 500;
            searchElement(extracted4);
        }
        StringBuilder extracted5 = extracted(arr, "666");
        if (extracted5.length() == 2) {
            points += 600;
            searchElement(extracted5);
        }
        searchElement(extracted);

        return points;
    }


    private static StringBuilder extracted(StringBuilder arr, String s) {
        int i = arr.indexOf(s);
        if (i != -1) {
            arr.delete(i, i + 3);
        }
        return arr;
    }

    private static void searchElement(StringBuilder sB){
        int i = sB.indexOf("1");
        if(i != -1){
            points += 100;
            sB.delete(i,i+1);
            searchElement(sB);
        }
        int i1 = sB.indexOf("5");
        if(i1 != -1){
            points += 50;
            sB.delete(i1,i1+1);
            searchElement(sB);
        }
    }
}

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A bookseller has lots of books classified in 26 categories labeled A, B, ... Z. Each book has a code c of 3, 4, 5 or
 * more characters. The 1st character of a code is a capital letter which defines the book category.
 * <p>
 * In the bookseller's stocklist each code c is followed by a space and by a positive integer n (int n >= 0) which
 * indicates the quantity of books of this code in stock.
 * <p>
 * For example an extract of a stocklist could be:
 * <p>
 * L = {"ABART 20", "CDXEF 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60"}.
 * or
 * L = ["ABART 20", "CDXEF 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60"] or ....
 * <p>
 * You will be given a stocklist (e.g. : L) and a list of categories in capital letters e.g :
 * <p>
 * M = {"A", "B", "C", "W"}
 * or
 * M = ["A", "B", "C", "W"] or ...
 * <p>
 * and your task is to find all the books of L with codes belonging to each category of M and to sum their quantity
 * according to each category.
 * <p>
 * For the lists L and M of example you have to return the string (in Haskell/Clojure/Racket a list of pairs):
 * <p>
 * (A : 20) - (B : 114) - (C : 50) - (W : 0)
 * <p>
 * where A, B, C, W are the categories, 20 is the sum of the unique book of category A, 114 the sum corresponding to
 * "BKWRK" and "BTSQZ", 50 corresponding to "CDXEF" and 0 to category 'W' since there are no code beginning with W.
 * <p>
 * If L or M are empty return string is "" (Clojure and Racket should return an empty array/list instead).
 * Note:
 * <p>
 * In the result codes and their values are in the same order as in M.
 */


public class StockList {

    // 1st parameter is the stocklist (L in example),
    // 2nd parameter is list of categories (M in example)
    public static String stockSummary(String[] L, String[] M) {
        Map<String, Integer> result = new LinkedHashMap<>();

        for (String key : M) {
            result.put(key, 0);
        }
        for (String key : M) {
            for (String stock : L) {
                if (!stock.startsWith(key)) {
                    continue;
                }
                String[] split = stock.split(" ");
                int count = Integer.parseInt(split[1]);
                Integer current = result.get(key);
                result.put(key, current + count);
            }
        }
        StringBuilder sB = new StringBuilder();
        int counter = 0;
        for (Map.Entry<String, Integer> s : result.entrySet()) {
            sB.append("(").append(s.getKey()).append(" : ").append(s.getValue()).append(")");
            if (counter++ < result.size()-1) {
                sB.append(" - ");
            }

        }
        return sB.toString();
    }
}

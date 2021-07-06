import java.util.*;

/**
 * In this kata we want to convert a string into an integer. The strings simply represent the numbers in words.
 * <p>
 * Examples:
 * <p>
 * "one" => 1
 * "twenty" => 20
 * "two hundred forty-six" => 246
 * "seven hundred eighty-three thousand nine hundred and nineteen" => 783919
 * <p>
 * Additional Notes:
 * <p>
 * The minimum number is "zero" (inclusively)
 * The maximum number, which must be supported is 1 million (inclusively)
 * The "and" in e.g. "one hundred and twenty-four" is optional, in some cases it's present and in others it's not
 * All tested numbers are valid, you don't need to validate them
 */
public class IntParser {
    public static int parseInt(String numStr) {
        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("twenty", 20);
        map.put("two", 2);
        map.put("forty", 40);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eighty", 80);
        map.put("three", 3);
        map.put("nine", 9);
        map.put("nineteen", 19);
        int accTh = 0;

        String[] split = numStr.split("thousand");

        String thousands;
        String hundreds;
        if (split.length > 1) {
            thousands = split[0];
            String[] splitTh = thousands.split("hundred");
            if (splitTh.length > 1) {
                accTh = map.get(splitTh[0].trim()) * 100;
                String[] splt = splitTh[1].trim().split("\\W+");
                for (String s : splt) {
                    accTh += map.get(s.trim());
                }
            } else {
                accTh += map.get(splitTh[0].trim());
            }

            accTh *= 1000;
            hundreds = split[1];
        } else {
            hundreds = split[0];
        }

        int accHun = 0;
        String[] splitHund = hundreds.split("hundred");
        if (splitHund.length > 1) {
            accHun = map.get(splitHund[0].trim()) * 100;
            String[] splt = splitHund[1].trim().split("\\W+");
            for (String s : splt) {
                if ("and".equals(s)) {
                    continue;
                }
                accHun += map.get(s.trim());
            }
        } else {
            accHun += map.get(splitHund[0].trim());
        }


        return accTh + accHun;
    }
}

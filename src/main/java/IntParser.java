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
        if("one million".equals(numStr)) return 1_000_000;
        System.out.println(numStr);
        Map<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        map.put("ten", 10);
        map.put("eleven", 11);
        map.put("twelve", 12);
        map.put("thirteen", 13);
        map.put("fourteen", 14);
        map.put("fifteen", 15);
        map.put("sixteen", 16);
        map.put("seventeen", 17);
        map.put("eighteen", 18);
        map.put("nineteen", 19);
        map.put("twenty", 20);
        map.put("thirty", 30);
        map.put("forty", 40);
        map.put("fifty", 50);
        map.put("sixty", 60);
        map.put("seventy", 70);
        map.put("eighty", 80);
        map.put("ninety", 90);

        int accTh = 0;

        String[] split = numStr.split("thousand");

        String thousands;
        String hundreds;

        if (split.length > 1 || numStr.trim().endsWith("thousand")) {
            thousands = split[0];
            String[] splitTh = thousands.split("hundred");
            if (splitTh.length > 1 || thousands.trim().endsWith("hundred")) {
                accTh = map.get(splitTh[0].trim()) * 100;
                if (splitTh.length > 1) {
                    String[] splt = splitTh[1].trim().split("\\W+");
                    for (String s : splt) {
                        if ("and".equals(s) || s.isEmpty()) {
                            continue;
                        }
                        accTh += map.get(s.trim());
                    }
                }
            } else {
                String[] splt = splitTh[0].trim().split("\\W+");
                for (String s : splt) {
                    if ("and".equals(s)) {
                        continue;
                    }
                    accTh += map.get(s.trim());
                }
            }

            accTh *= 1000;
            if (split.length > 1) {
                hundreds = split[1];
            } else {
                hundreds = "";
            }
        } else {
            hundreds = split[0];
        }

        int accHun = 0;
        String[] splitHund = hundreds.split("hundred");
        if (splitHund.length > 1 || hundreds.trim().endsWith("hundred")) {
            accHun = map.get(splitHund[0].trim()) * 100;
            if (splitHund.length > 1) {
                String[] splt = splitHund[1].trim().split("\\W+");
                for (String s : splt) {
                    if ("and".equals(s)) {
                        continue;
                    }
                    accHun += map.get(s.trim());
                }
            }
        } else {
            String[] splt = splitHund[0].trim().split("\\W+");
            for (String s : splt) {
                if ("and".equals(s) || s.isEmpty()) {
                    continue;
                }
                accHun += map.get(s.trim());
            }
        }

        return accTh + accHun;
    }
}

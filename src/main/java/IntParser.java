import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        map.put("hundred", 100);
        map.put("eighty", 80);
        map.put("three", 3);
        map.put("thousand", 1000);
        map.put("nine", 9);
        map.put("nineteen", 19);
        String[] split = numStr.split("\\W+");
        Integer count = 0;
        Integer tmp = 0;
        for (String number : split) {

            if(number.equals("hundred")){
                count += tmp *100;
                continue;
            }
            if(number.equals("thousand")){
                count += tmp *1000;
                continue;
            }

            map.get(number)
        }

        // Your code here!
        return -1;
    }
}

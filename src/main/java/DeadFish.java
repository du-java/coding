import java.util.*;

/**
 * Write a simple parser that will parse and run Deadfish.
 * <p>
 * Deadfish has 4 commands, each 1 character long:
 * <p>
 * i increments the value (initially 0)
 * d decrements the value
 * s squares the value
 * o outputs the value into the return array
 * <p>
 * Invalid characters should be ignored.
 * <p>
 * Deadfish.parse("iiisdoso") =- new int[] {8, 64};
 */
public class DeadFish {

//iiisdoso
    public static int[] parse(String data) {
        int startValue = 0;
        String[] array = data.split("");
        List<Integer> list = new ArrayList<>();
        for (String tmp : array) {
            switch (tmp) {
                case "i":
                    ++startValue;
                    break;
                case "d":
                    --startValue;
                    break;
                case "s":
                    startValue *= startValue;
                    break;
                case "o":
                    list.add(startValue);
                    break;
            }
        }

        System.out.println(list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}


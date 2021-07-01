import java.util.HashMap;
import java.util.Map;

/**
 * Complete the function scramble(str1, str2) that returns true if a portion of str1 characters can be rearranged to match str2, otherwise returns false.
 * <p>
 * Notes:
 * <p>
 * Only lower case letters will be used (a-z). No punctuation or digits will be included.
 * Performance needs to be considered
 * <p>
 * Input strings s1 and s2 are null terminated.
 * <p>
 * Examples
 * <p>
 * scramble('rkqodlw', 'world') ==> True
 * scramble('cedewaraaossoqqyt', 'codewars') ==> True
 * scramble('katas', 'steak') ==> False
 */
public class Scramblies {

    public static boolean scramble(String str1, String str2) {
        String[] split = str2.split("");

        for (String tmp : split) {
            if (str1.contains(tmp)) {
                str1 = str1.replaceFirst(tmp, "");
            } else {
                return false;
            }
        }
        return true;
    }
}

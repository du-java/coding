import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * The goal of this exercise is to convert a string to a new string where each character in the new string is "("
 * if that character appears only once in the original string, or ")" if that character appears more than once
 * in the original string. Ignore capitalization when determining if a character is a duplicate.
 * <p>
 * Examples
 * <p>
 * "din"      =>  "((("
 * "recede"   =>  "()()()"
 * "Success"  =>  ")())())"
 * "(( @"     =>  "))(("
 * <p>
 * Notes
 * <p>
 * Assertion messages may be unclear about what they display in some languages. If you read "...It Should encode XXX", the "XXX" is the expected result, not the input!
 */
public class DuplicateEncoder {
    static String encode(String word) {

        String[] split = word.toUpperCase(Locale.ROOT).split("");
        Map<String, Boolean> map = new HashMap<>();
        for (String tmp : split) {
            Boolean aBoolean = map.get(tmp);
            if (aBoolean == null) {
                map.put(tmp, false);
            } else {
                map.put(tmp,true);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : split) {
            Boolean aBoolean = map.get(s);
            if(aBoolean){
                stringBuilder.append(")");
            }
            else{
                stringBuilder.append("(");
            }
        }
        return stringBuilder.toString();
    }
}

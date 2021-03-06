import java.util.ArrayList;
import java.util.List;

/**
 * Complete the solution so that it strips all text that follows any of a set of comment markers passed in. Any whitespace at the end of the line should also be stripped out.
 * <p>
 * Example:
 * <p>
 * Given an input string of:
 * <p>
 * apples, pears # and bananas
 * grapes
 * bananas !apples
 * <p>
 * The output expected would be:
 * <p>
 * apples, pears
 * grapes
 * bananas
 * <p>
 * The code would be called like so:
 * <p>
 * var result = solution("apples, pears # and bananas\ngrapes\nbananas !apples", ["#", "!"])
 * // result should == "apples, pears\ngrapes\nbananas"
 */
public class StripComments {

    public static String stripComments(String text, String[] commentSymbols) {

        List<String> list = new ArrayList<>();
        String[] split = text.split("\n");
        for (String str : split) {
            for (String sym : commentSymbols) {
                int idx = str.indexOf(sym);
                if (idx != -1) {
                    str = str.substring(0, idx).replaceAll("\\s*$","");
                }
            }
            list.add(str);
        }
        return String.join("\n", list);
    }
}

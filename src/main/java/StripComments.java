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
        List<String> list = new ArrayList<String>();
        String[] split = text.split("\n");
        for (String s : split) {
            for (String s1 : commentSymbols) {
                int i = s.indexOf(s1);
                if (i != -1) {
                    s = s.substring(0, i).trim();
                }
            }

            list.add(s);
        }
//        "apples, pears\ngrapes\nbananas",
//                StripComments.stripComments("apples, pears # and bananas\ngrapes\nbananas !apples", new String[]{"#", "!"})
//      
//                "a\nc\nd",
//                StripComments.stripComments("a #b\nc\nd $e f g", new String[]{"#", "$"})

        return String.join("\n",list);
    }

}

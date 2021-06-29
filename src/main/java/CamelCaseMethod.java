import java.util.Locale;

/**
 * Write simple .camelCase method (camel_case function in PHP, CamelCase in C# or camelCase in Java) for strings. All words must have their first letter capitalized without spaces.
 * <p>
 * For instance:
 * <p>
 * camelCase("hello case"); // => "HelloCase"
 * camelCase("camel case word"); // => "CamelCaseWord"
 */
public class CamelCaseMethod {
    public static String camelCase(String str) {
        String[] s = str.split("\\s+");
        String word = "";
        String camelCase = "";
        for (int i = 0; i < s.length; i++) {
            if (s[i].isEmpty()){
                continue;
            }
            word = s[i];
            String firstLetter = s[i].substring(0, 1).toUpperCase(Locale.ROOT);
            String substring = word.substring(1);
            String rtn = firstLetter + substring;
            camelCase += rtn;
        }
        return camelCase;
    }
}


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
        final StringBuilder builder = new StringBuilder();
        for (String value : s) {
            if (value.isEmpty()) {
                continue;
            }
            builder.append(value.substring(0, 1).toUpperCase()).append(value.substring(1));
        }
        return builder.toString();
    }
}

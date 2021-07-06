import java.util.*;
import java.util.stream.Collectors;

/**
 * Write a function that, given a string of text (possibly with punctuation and line-breaks),
 * returns an array of the top-3 most occurring words, in descending order of the number of occurrences.
 * Assumptions:
 * <p>
 * A word is a string of letters (A to Z) optionally containing one or more apostrophes (') in ASCII.
 * (No need to handle fancy punctuation.)
 * Matches should be case-insensitive, and the words in the result should be lowercased.
 * Ties may be broken arbitrarily.
 * If a text contains fewer than three unique words, then either the top-2 or top-1 words should be returned,
 * or an empty array if a text contains no words.
 * <p>
 * Examples:
 * <p>
 * top_3_words("In a village of La Mancha, the name of which I have no desire to call to
 * mind, there lived not long since one of those gentlemen that keep a lance
 * in the lance-rack, an old buckler, a lean hack, and a greyhound for
 * coursing. An olla of rather more beef than mutton, a salad on most
 * nights, scraps on Saturdays, lentils on Fridays, and a pigeon or so extra
 * on Sundays, made away with three-quarters of his income.")
 * # => ["a", "of", "on"]
 * <p>
 * top_3_words("e e e e DDD ddd DdD: ddd ddd aa aA Aa, bb cc cC e e e")
 * # => ["e", "ddd", "aa"]
 * <p>
 * top_3_words("  //wont won't won't")
 * # => ["won't", "wont"]
 * <p>
 * For java users, the calls will actually be in the form: TopWords.top3(String s), expecting you to return a List<String>.
 * Bonus points (not really, but just for fun):
 * <p>
 * Avoid creating an array whose memory footprint is roughly as big as the input text.
 * Avoid sorting the entire array of unique words.
 */
public class TopWords {

    public static List<String> top3(String s) {

        String[] split = s.toLowerCase().split("([^a-z]+[^a-z']?[^a-z]+|[^a-z']+)");
        if (split.length == 0) return Collections.emptyList();
        Map<String, Integer> words = new HashMap<>();
        for (String s1 : split) {
            if (s1.isEmpty()) continue;
            words.merge(s1, 1, Integer::sum);
        }
        Map<String, Integer> sortWords = sortByValue(words);
        return sortWords.keySet().stream().limit(3).collect(Collectors.toList());
    }
    public static  Map<String, Integer> sortByValue(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());

        Map<String, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}



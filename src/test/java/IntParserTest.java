import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntParserTest {
    @Test
    public void fixedTests() {
        assertEquals(1, IntParser.parseInt("one"));
        assertEquals(100, IntParser.parseInt("one hundred"));
        assertEquals(2000, IntParser.parseInt("two thousand"));
        assertEquals(20, IntParser.parseInt("twenty"));
        assertEquals(21, IntParser.parseInt("twenty-one"));
        assertEquals(246, IntParser.parseInt("two hundred forty-six"));
        assertEquals(700000, IntParser.parseInt("seven hundred thousand"));
        assertEquals(783919, IntParser.parseInt("seven hundred eighty-three thousand nine hundred and nineteen"));
    }
}
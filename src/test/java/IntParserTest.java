import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntParserTest {
    @Test
    public void fixedTests() {
        assertEquals(1, IntParser.parseInt("one"));
        assertEquals(20, IntParser.parseInt("twenty"));
        assertEquals(246, IntParser.parseInt("two hundred forty-six"));
    }
}
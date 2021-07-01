import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrailingZerosTest {
    @Test
    public void testZeros() throws Exception {
        assertEquals(TrailingZeros.zeros(0), 0);
        assertEquals(TrailingZeros.zeros(6), 1);
        assertEquals(TrailingZeros.zeros(14), 2);
    }
}
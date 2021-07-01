import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatePhoneTest {
    @Test
    public void tests() {
        assertEquals(true, ValidatePhone.validPhoneNumber("(123) 456-7890"));
        assertEquals(false, ValidatePhone.validPhoneNumber("(1111)555 2345"));
        assertEquals(false, ValidatePhone.validPhoneNumber("(098) 123 4567"));
    }
}
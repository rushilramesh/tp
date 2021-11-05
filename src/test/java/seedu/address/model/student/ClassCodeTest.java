package seedu.address.model.student;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class ClassCodeTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new ClassCode(null));
    }

    @Test
    public void constructor_invalidClassCode_throwsIllegalArgumentException() {
        String invalidClassCode = "";
        assertThrows(IllegalArgumentException.class, () -> new ClassCode(invalidClassCode));
    }

    @Test
    public void classCodeComparable_validClassCode_success() {
        ClassCode G06 = new ClassCode("G06");
        ClassCode G92 = new ClassCode("G92");
        ClassCode G06_copy = new ClassCode("G06");
        ClassCode G99 = new ClassCode("G99");

        // compare same ClassCode
        assertTrue(G06.compareTo(G06_copy) == 0);
        assertTrue(G06.compareTo(G06) == 0);

        // compare different ClassCode
        assertTrue(G06.compareTo(G92) < 0);
        assertTrue(G99.compareTo(G92) > 0);
    }

    @Test
    public void isValidClassCode() {
        // null classCode
        assertThrows(NullPointerException.class, () -> ClassCode.isValidClassCode(null));

        // blank ClassCode
        assertFalse(ClassCode.isValidClassCode("")); // empty string
        assertFalse(ClassCode.isValidClassCode(" ")); // spaces only

        // invalid ClassCode
        assertFalse(ClassCode.isValidClassCode("Today")); // must start with G, followed by 2 digits
        assertFalse(ClassCode.isValidClassCode("12")); // only numbers
        assertFalse(ClassCode.isValidClassCode("T99")); // first character is G/g
        assertFalse(ClassCode.isValidClassCode("g001")); // must have 3 digits

        // valid ClassCode
        assertTrue(ClassCode.isValidClassCode("G00")); // Upper-case G
        assertTrue(ClassCode.isValidClassCode("g99")); // Lower-case G
    }
}

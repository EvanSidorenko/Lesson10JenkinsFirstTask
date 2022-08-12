package simple.test;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("simple")
public class NegativeTest {
    @Test
    void test00() {
        assertFalse(false);
    }

    @Test
    void test01() {
        assertFalse(false);
    }

    @Test
    void test02() {
        assertFalse(false);
    }

    @Test
    void test03() {
        assertFalse(false);
    }

    @Test
    void test04() {
        assertTrue(false);
    }
}

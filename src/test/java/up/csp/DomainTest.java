package up.csp;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DomainTest {

    private Domain rangeSet;

    @BeforeEach
    void setUp() {
        rangeSet = new Domain(10, 15);
    }

    @Test
    void shouldRemoveValueWhenInsideRange() {
        // Act
        rangeSet.removeValue(12);

        // Assert
        assertFalse(rangeSet.contains(12));
    }

    @Test
    void shouldNotModifySetWhenValueBelowRange() {
        // Act
        rangeSet.removeValue(5);

        // Assert
        assertTrue(rangeSet.contains(10));
        assertTrue(rangeSet.contains(11));
        assertTrue(rangeSet.contains(12));
        assertTrue(rangeSet.contains(13));
        assertTrue(rangeSet.contains(14));
        assertTrue(rangeSet.contains(15));
    }

    @Test
    void shouldNotModifySetWhenValueAboveRange() {
        // Act
        rangeSet.removeValue(20);

        // Assert
        assertTrue(rangeSet.contains(10));
        assertTrue(rangeSet.contains(11));
        assertTrue(rangeSet.contains(12));
        assertTrue(rangeSet.contains(13));
        assertTrue(rangeSet.contains(14));
        assertTrue(rangeSet.contains(15));
    }

    @Test
    void shouldRemoveMinValue() {
        rangeSet.removeValue(10);
        assertFalse(rangeSet.contains(10));
    }

    @Test
    void shouldRemoveMaxValue() {
        rangeSet.removeValue(15);
        assertFalse(rangeSet.contains(15));
    }
}
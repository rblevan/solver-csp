package up.csp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestVariable {

    private Domain domain; //Domain of the Variable
    private Variable var; // The variable 

    @BeforeEach
    public void setUp() {
        domain = new Domain(10, 20);
        var = new Variable("Myname", domain);

    }

    /**
     * @author Nicolas ITEY Return false for the function isAssigned because the
     * function has never been assigned
     */
    @Test
    public void shouldReturnFalseWhenNotAssigned() {

        assertFalse(var.isAssigned());
    }

    /**
     * @author Nicolas ITEY Verify that the function assign assigned a value to
     * the Variable
     */
    @Test
    public void shouldBeAssignedAfterAssignCall() {
        var.assign(15);
        assertTrue(var.isAssigned());
    }

    /**
     * @author Nicolas ITEY Verify the exception in the assign() function
     */
    @Test
    public void shouldThrowExceptionWhenValueNotInDomain() {
        assertThrows(IllegalArgumentException.class, ()
                -> var.assign(5)
        );
    }

    /**
     * @author Nicolas ITEY Verify assign() Test if the value after being
     * assigned is unassigned if it truly dissapear and if the value is now null
     */
    @Test
    public void shouldUnassignTheValue() {
        var.assign(15);
        var.unassign();
        assertFalse(var.isAssigned());
        assertNull(var.getValue());

    }

    /**
     * @author Nicolas ITEY Verify unassign() Verifiy if unassign make something
     * bug when no value has been assigned before
     */
    @Test
    public void shouldRemainUnassignedIfAlreadyUnassigned() {
        // jamais assignée avant
        var.unassign();

        assertFalse(var.isAssigned());
        assertNull(var.getValue());
    }

    /**
     * @author Nicolas ITEY Verify getname() Verify if the name in the variable
     * is saved as the same as the String "My name" by comparing them
     */
    @Test
    public void shouldReturnCorrectName() {
        String expected_name = "Myname";
        String actualName = var.getName();

        assertEquals(expected_name, actualName, "The name must be the same");
    }

    /**
     * @author Nicolas ITEY Verify the methode GetDomain Verify if the Domain
     * (10,20) is saved in the Variable
     */
    @Test
    public void shouldReturnCorrectDomain() {
        assertSame(domain, var.getDomain(), "The domain must be the same");
    }

    /**
     * @author Nicolas ITEY Verify the method getValue() Verify that if there is
     * no value assigned,it must be null
     */
    @Test
    public void shouldReturnNullWhenNotAssigned() {
        Integer actualValue = var.getValue();

        assertNull(actualValue, "Value should be null when variable is not assigned");
    }

    /**
     * @author Nicolas ITEY Verify the method getValue() We assign the value 15
     * before comparing if the Variable now has the value 15 in it with an
     * assert equal
     */
    @Test
    public void shouldReturnAssignedValue() {
        var.assign(15);

        Integer actualValue = var.getValue();

        assertEquals(15, actualValue, "Value should be the assigned value");
    }
}

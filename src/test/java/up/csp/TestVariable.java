package up.csp;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestVariable {

    private Domain domain;
    private Variable var;

    @BeforeEach
    void setUp() {
        domain = new Domain(10, 20);
        var = new Variable("Petit", domain);

    }
        @Test
    void shouldReturnFalseWhenNotAssigned() {

        assertFalse(var.isAssigned());
    }

    @Test
    void shouldReturnTrueWhenAssigned() {
       

        var.assign(5);

        assertTrue(var.isAssigned());
    }


    @Test
void shouldBeAssignedAfterAssignCall() {
    var.assign(15);
    assertTrue(var.isAssigned());
}
@Test
void shouldThrowExceptionWhenValueNotInDomain() {
    assertThrows(IllegalArgumentException.class, () -> {
        var.assign(5);
    });
}

@Test 
void shouldUnassignTheValue(){
    var.assign(15);
var.unassign();
assertFalse(var.isAssigned());
    assertNull(var.getValue());


}

@Test
void shouldRemainUnassignedIfAlreadyUnassigned() {
       // jamais assignée avant
    var.unassign();
    assertFalse(var.isAssigned());
    assertNull(var.getValue());
}

}

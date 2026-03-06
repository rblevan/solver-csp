package up.csp;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class TestVariable {

    private Domain domain;
    private Variable var;

    @Before
    public void setUp() {
        domain = new Domain(10, 20);
        var = new Variable("Petit", domain);

    }
        @Test
    public void shouldReturnFalseWhenNotAssigned() {

        assertFalse(var.isAssigned());
    }

    @Test
    public void shouldReturnTrueWhenAssigned() {
       

        var.assign(15);

        assertTrue(var.isAssigned());
    }


    @Test
public void shouldBeAssignedAfterAssignCall() {
    var.assign(15);
    assertTrue(var.isAssigned());
}
@Test
public void shouldThrowExceptionWhenValueNotInDomain() {
    assertThrows(IllegalArgumentException.class, () -> {
        var.assign(5);
    });
}

@Test 
public void shouldUnassignTheValue(){
    var.assign(15);
var.unassign();
assertFalse(var.isAssigned());
    assertNull(var.getValue());


}

@Test
public void shouldRemainUnassignedIfAlreadyUnassigned() {
       // jamais assignée avant
    var.unassign();
    assertFalse(var.isAssigned());
    assertNull(var.getValue());
}

}

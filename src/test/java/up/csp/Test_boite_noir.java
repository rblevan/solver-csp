package up.csp;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import up.csp.constraint.Constraint;

public class Test_boite_noir {

    private Domain domain; //Domain of the Variable

    private Variable var; // The variable 
    private Variable var2;
    private Labelling labelling;

    @Before
    public void setUp() {
        domain = new Domain(10, 20);
        var = new Variable("Myname", domain);
        var2 = new Variable("papate", domain);
        		labelling = new Labelling();

    }

    @Test
    public void testAddVariable() {
        CSP csp = new CSP();

        csp.addVariable(var);

        // Vérifie que la variable a été ajoutée
        assertEquals(1, csp.getVariables().size());
        assertTrue(csp.getVariables().contains(var));
    }

    @Test
    public void TestAddConstraint() {
        CSP csp = new CSP();

        Constraint c = Constraint.equal(var, 5);

        csp.addConstraint(c);
        assertEquals(1, csp.getConstraints().size());
        assertTrue(csp.getConstraints().contains(c));

    }

    @Test
    public void TestGetVariables() {
        CSP csp = new CSP();
        csp.addVariable(var);

        ArrayList<Variable> vars = csp.getVariables();

        assertEquals(1, vars.size());
        assertTrue(vars.contains(var));

        csp.addVariable(var2);
        vars = csp.getVariables();

        assertEquals(2, vars.size());
        assertTrue(vars.contains(var2));
    }


}

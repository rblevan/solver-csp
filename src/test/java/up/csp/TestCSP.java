package up.csp;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import up.csp.constraint.Constraint;

/**
 * Test the {@link CSP} class
 * @author Chloé LEMAIRE
 */
public class TestCSP {

    @Test
    public void testdReturnFalseWhenNotComplete() {
        CSP csp = new CSP();
        Variable x = new Variable("x", new Domain(1, 2));
        csp.addVariable(x);
        assertFalse(csp.isComplete());
    }

    @Test
    public void testdSolveSimpleUnaryConstraint() {
        CSP csp = new CSP();
        Variable x = new Variable("x", new Domain(1, 3));
        csp.addVariable(x);
        csp.addConstraint(Constraint.equal(x, 2));
        assertTrue(csp.solve());
        assertTrue(csp.isComplete());
        assertTrue(csp.isSatisfied());
    }

    @Test
    public void testdFailWhenConstraintsAreContradictory() {
        CSP csp = new CSP();
        Variable x = new Variable("x", new Domain(1, 1));
        csp.addVariable(x);
        csp.addConstraint(Constraint.equal(x, 1));
        csp.addConstraint(Constraint.different(x, 1));
        assertFalse(csp.solve());
    }

    @Test
    public void testForwardChecking(){
        CSP csp = new CSP();
        Variable X = new Variable("X",new Domain(0,2));
        Variable Y = new Variable("Y",new Domain(0,1));
        Variable Z = new Variable("Z",new Domain(0,1));
        csp.addVariable(X);
        csp.addVariable(Y);
        csp.addVariable(Z);
        Constraint diff = Constraint.allDifferent(csp.getVariables()); 
        csp.addConstraint(diff);
        csp.solve();
        assertTrue("all variables aren't different : \n x = "+X.toString()+
        "\nvalue y = "+Y.toString()+
        "\nvalue Z = "+Z.toString(),diff.check());
        assertTrue("value x = "+X.getValue().toString(),X.isAssigned());
        assertTrue("value y = "+Y.getValue().toString(),Y.isAssigned());
        assertTrue("value Z = "+Z.getValue().toString(),Z.isAssigned());
    }
}

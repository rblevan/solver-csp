package up.csp;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import up.csp.constraint.Constraint;

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
}

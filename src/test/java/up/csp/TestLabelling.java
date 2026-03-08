package up.csp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;


public class TestLabelling {

    private Labelling labelling;
    private CSP csp;
    private Variable x;
    private Variable y;

    @Before
    public void setUp() {
        labelling = new Labelling();
        csp = new CSP();
        x = new Variable("x", new Domain(1, 5));
        y = new Variable("y", new Domain(1, 2));
        csp.addVariable(x);
        csp.addVariable(y);
    }

    @Test
    public void testSelectFirstUnassignedVariable() {
        x.assign(1);
        labelling.setVarStrategy(Labelling.VAR_FIRST_UNASSIGNED);
        assertSame(y, labelling.selectVariable(csp));
    }

    @Test
    public void testSelectVariableWithSmallestDomain() {
        labelling.setVarStrategy(Labelling.VAR_MIN);
        assertSame(y, labelling.selectVariable(csp));
    }

    @Test
    public void testSelectFirstAvailableValueInOrder() {
        y.getDomain().removeValue(1);
        labelling.setValStrategy(Labelling.VAL_IN_ORDER);
        int selectedValue = labelling.selectValue(y);
        assertEquals(2, selectedValue);
    }
}

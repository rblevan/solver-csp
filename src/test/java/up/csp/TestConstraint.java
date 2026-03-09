package up.csp;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import up.csp.constraint.*;

public class TestConstraint{

    @Test
    public void testUnary(){
        Variable a = new Variable("a",new Domain(0,10));
        Constraint equality = Constraint.equal(a,10);
        assertFalse(equality.check());
        a.assign(10);
        assertTrue(equality.check());
        Constraint different = Constraint.different(a,5);
        assertTrue(different.check());
        a.assign(5);
        assertFalse(different.check());
    }

    @Test
    public void testBinary(){
        Variable a = new Variable("a",new Domain(0,20));
        Variable b = new Variable("b", new Domain(0,20));
        int constant = 0;
        Constraint equals = Constraint.equal(a,b);
        Constraint different = Constraint.different(a,b, constant);
        Constraint under = Constraint.under(a,b,constant);

        assertFalse(equals.check());
        assertFalse(different.check());
        assertFalse(under.check());

        a.assign(1);
        b.assign(2);

        assertFalse(equals.check());
        assertTrue(different.check());
        assertTrue(under.check());

        a.assign(2);

        assertTrue(equals.check());
        assertFalse(different.check());
        assertFalse(under.check());

        constant = 3;
        different = Constraint.different(a,b, constant);
        under = Constraint.under(a,b,constant);
        
        assertTrue(equals.check());
        assertTrue(different.check());
        assertTrue(under.check());

        constant = -3;
        different = Constraint.different(a,b, constant);
        under = Constraint.under(a,b,constant);

        assertTrue(equals.check());
        assertTrue(different.check());
        assertFalse(under.check());
    }   

    @Test
    public void testAllDifferent(){
        ArrayList<Variable> vars = new ArrayList<>();
        for(int i=0;i<10;i++){
            Variable v = new Variable(Integer.toString(i),new Domain(0,20));
            vars.add(v);
            v.assign(i);
        }
        AllDifferent diff = Constraint.allDifferent(vars);
        assertTrue(diff.check());
        vars.get(9).assign(1);
        assertFalse(diff.check());
    }
}
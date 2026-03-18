package up.csp;

import org.junit.Test;

/**
 * Test the {@link Domain} class
 * @author Evan Ribouleau
 * */

public class TestDomain {
    @Test
    public void testDomainCreation() {
        Domain domain = new Domain(1, 3);
        assert domain.size() == 3;
    }

    @Test
    public void testDomainContains() {
        Domain domain = new Domain(10, 20);
        assert domain.contains(10);
        assert domain.contains(15);
        assert !domain.contains(30);
    }

    @Test
    public void testDomainCreationNegative() {
        Domain domain = new Domain(-4, -10);
        assert domain.size() == 7;
    }

    @Test
    public void testDomainRemoveValue() {
        Domain domain = new Domain(1, 10);
        domain.removeValue(5);
        assert !domain.contains(5);
    }

    @Test
    public void testDomainRestoreValue() {
        Domain domain = new Domain(1, 10);
        domain.removeValue(5);
        domain.restoreValue(5);
        assert domain.contains(5);
    }

    @Test
    public void testDomainIntersection() {
        Domain domain1 = new Domain(1, 10);
        Domain domain2 = new Domain(5, 15);
        domain1.intersection(domain2);
        assert domain1.size() == 6;
        assert domain1.contains(5);
        assert domain1.contains(10);
        assert !domain1.contains(1);
        assert !domain1.contains(4);
        assert !domain1.contains(11);
        assert !domain1.contains(15);
    }

    @Test
    public void testDomainIntersectionEmpty() {
        Domain domain1 = new Domain(1, 10);
        Domain domain2 = new Domain(15, 20);
        domain1.intersection(domain2);
        assert domain1.size() == 0;
        assert !domain1.contains(5);
        assert !domain1.contains(10);
        assert !domain1.contains(13);
    }

    @Test
    public void testDomainGetMin() {
        Domain domain = new Domain(1, 10);
        assert domain.getMin() == 1;
    }

    @Test
    public void testDomainGetMax() {
        Domain domain = new Domain(1, 10);
        assert domain.getMax() == 10;
    }
}

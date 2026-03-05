package up.csp;

import org.junit.Test;

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
    public void testDomainRemoveValue() {
        Domain domain = new Domain(1, 10);
        domain.removeValue(5);
        assert !domain.contains(5);
    }

}

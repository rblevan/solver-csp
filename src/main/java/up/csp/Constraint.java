package up.csp;

import java.util.*;

public interface Constraint {

	Collection<CSP> getConstraints();

	boolean isSatisfied();

}
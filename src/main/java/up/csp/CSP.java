package up.csp;

import java.util.ArrayList;
import java.util.Collection;

public class CSP {

	private Collection<Variable> variables; 
	private Collection<Constraint> constraints;

	public CSP() {
		variables = new ArrayList<Variable>();
		constraints = new ArrayList<Constraint>();
	}

	public void solve() {
		// TODO - implement CSP.solve
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param var
	 */
	public void forwardCheck(Variable var) {
		// TODO - implement CSP.forwardCheck
		throw new UnsupportedOperationException();
	}

}
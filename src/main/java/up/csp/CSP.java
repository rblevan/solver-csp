package up.csp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import up.csp.constaint.Constraint;

public class CSP {

	/*
	* This class represents a Constraint Satisfaction Problem (CSP). It contains a collection of variables and a collection of constraints.
	*/
	private final ArrayList<Variable> variables; 
	private final ArrayList<Constraint> constraints;

	public CSP() 
	{
		variables = new ArrayList<>();
		constraints = new ArrayList<>();
	}

	/* 
	 *	@param v the variable to be added to the CSP
	 */
	public void addVariable(Variable v) 
	{
		variables.add(v);
	}
	/* 
	 * @param c the constraint to be added to the CSP
	 */
	public void addConstraint(Constraint c) 
	{
		constraints.add(c);
	}

	public ArrayList<Variable> getVariables()
	{
		return new ArrayList<>(variables);
	}

	public Collection<Constraint> getConstraints()
	{
		return Collections.unmodifiableCollection(constraints);
	}

	/*
	 * @return true if all variables in the CSP are assigned, false otherwise.
	 */
	public boolean isComplete() 
	{
		for (Variable v : variables) {
			if (!v.isAssigned()) {
				return false;
			}
		}
		return true;
	}

	/*
	 * @return true if all constraints in the CSP are satisfied, false otherwise.
	 */
	
	public boolean isSatisfied() 
	{
		for (Constraint c : constraints) {
			if (!c.check()) {
				return false;
			}
		}
		return true;
	}

	public void solve()
	{
		
	}

	}
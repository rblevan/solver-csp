package up.csp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import up.csp.constraint.Constraint;

public class CSP {

	private final ArrayList<Variable> variables; 
	private final ArrayList<Constraint> constraints;
	private final Labelling labelling;

	public CSP() 
	{
		variables = new ArrayList<>();
		constraints = new ArrayList<>();
		labelling = new Labelling();
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

	public void setVarStrategy(int strategy)
	{
		labelling.setVarStrategy(strategy);
	}

	public void setValStrategy(int strategy)
	{
		labelling.setValStrategy(strategy);
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


	public boolean solve()
	{
		if (isComplete()) {
			return isSatisfied();
		} else {
			Variable variable = labelling.selectVariable(this);
			if (variable == null) {
				return false;
			} else {
				List<Integer> values = labelling.orderValues(variable);
				for (int value : values) {
					variable.assign(value);
					if (solve()) {
						return true;
					} else {
						variable.unassign();
					}
				}
				return false;
			}
		}	}

	}
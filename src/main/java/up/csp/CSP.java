package up.csp;

import java.util.ArrayList;
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

	/**
	 * Adds a variable to this CSP.
	 *
	 * @param v variable to add
	 */
	public void addVariable(Variable v)
	{
		variables.add(v);
	}

	/**
	 * Adds a constraint to this CSP.
	 *
	 * @param c constraint to add
	 */
	public void addConstraint(Constraint c)
	{
		constraints.add(c);
	}

	/**
	 * loops through all constraints and sets variables according to them
	 */
	public void forwardCheck() {
        for (Constraint constraint : constraints) {
            constraint.set();
        }
    }
	/**
	 * Returns a copy of variables.
	 *
	 * @return modifiable copy of current variables
	 */
	public ArrayList<Variable> getVariables()
	{
		return new ArrayList<>(variables);
	}

	/**
	 * Returns constraints as an unmodifiable collection.
	 *
	 * @return an array list of constraints 
	 */
	public ArrayList<Constraint> getConstraints()
	{
		return new ArrayList<>(constraints);
	}

	/**
	 * Sets variable selection strategy used by labelling.
	 *
	 * @param strategy 
	 */
	public void setVarStrategy(int strategy)
	{
		labelling.setVarStrategy(strategy);
	}

	/**
	 * Sets value ordering strategy used by labelling.
	 *
	 * @param strategy 
	 */
	public void setValStrategy(int strategy)
	{
		labelling.setValStrategy(strategy);
	}

	/**
	 * Returns variable selection strategy used by labelling.
	 *
	 * @return current variable strategy constant
	 */
	public int getVarStrategy()
	{
		return labelling.getVarStrategy();
	}

	/**
	 * Returns value ordering strategy used by labelling.
	 *
	 * @return current value strategy constant
	 */
	public int getValStrategy()
	{
		return labelling.getValStrategy();
	}

	/**
	 * Checks whether all variables in the CSP are assigned.
	 *
	 * @return true if all variables are assigned, otherwise false
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

	/**
	 * Checks whether every constraint is satisfied.
	 *
	 * @return true if all constraints are satisfied, otherwise false
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

	/**
	 * Solves the CSP with recursive backtracking.
	 * 
	 * This method does not perform forward checking; it assigns values,
     * checks constraints only when a complete assignment is reached, and backtracks if the assignment 
     * does not satisfy all constraints.
	 * @return true if a complete satisfying assignment is found, otherwise false
	 */
    
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
					ArrayList<Domain> temp = new ArrayList<>();
					for(Variable v : variables){
						temp.add(v.getDomain().copy());
					}
					if(!variable.getDomain().contains(value)){
						continue;
					}
					variable.assign(value);
					forwardCheck();
					if (solve()) {
						return true;
					} else {
						for(int i=0;i<temp.size();i++){
							Variable v = variables.get(i);
							Domain newDomain = temp.get(i);
							v.setDomain(newDomain);
						}
						variable.getDomain().removeValue(value);
						variable.unassign();
					}
				}
				return false;
			}
		}
	}
	

}

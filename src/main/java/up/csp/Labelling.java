package up.csp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Labelling 
{
	public static final int VAR_FIRST_UNASSIGNED = 0;
	public static final int VAR_MIN = 1;
	public static final int VAR_RANDOM = 2;

	public static final int VAL_IN_ORDER = 0;
	public static final int VAL_RANDOM = 1;

	private int varStrategy = VAR_FIRST_UNASSIGNED; // Default variable selection strategy but can be changed to VAR_MIN or VAR_RANDOM
	private int valStrategy = VAL_IN_ORDER; // Default value selection strategy but can be changed to VAL_RANDOM

	private final Random random = new Random();

	/**
	 * Sets the variable selection strategy.
	 *
	 * @param strategy strategy to use
	 */
	public void setVarStrategy(int strategy) 
	{
    	this.varStrategy = strategy;
	}

	/**
	 * Sets the value selection strategy.
	 *
	 * @param strategy strategy to use
	 */
	public void setValStrategy(int strategy)
	{
    	this.valStrategy = strategy;
	}

	/**
	 * Selects the next variable to assign according to the current strategy.
	 *
	 * @param csp CSP problem that contains variables and constraints
	 * @return 
	 */
	public Variable selectVariable(CSP csp) 
	{
		List<Variable> v_unassigned = new ArrayList<>();
		for (Variable variable : csp.getVariables()) {
			if (!variable.isAssigned()) 
			{
				v_unassigned.add(variable);
			}
		}

		if (v_unassigned.isEmpty()) 
		{
			return null;
		}

		if (varStrategy == VAR_FIRST_UNASSIGNED) 
		{
			return v_unassigned.get(0);
		}

		if (varStrategy == VAR_MIN) {
			//find the variable with the min domain selected variable + compaire with the precedent et le suivant 
			return //la variable ;
		}

		if (varStrategy == VAR_RANDOM) 
		{
			//return unassigned.get(random ...);
		}

		return v_unassigned.get(0);
	}

	/**
	 * Selects the next value to try for a given variable.
	 *
	 * @param variable variable for which a value must be selected
	 * @return 
	 */
	public int selectValue(Variable variable) 
	{
		if (variable == null || variable.getDomain() == null) {
			return -1;
		}
		//avoir un domain 
		Domain domain = variable.getDomain();

		}

		if (//domain.isempty) 
		{
			return -1;
		}

		if (valStrategy == VAL_IN_ORDER) 
			{
			return //retourne la premiere valeur ! faut il agir sur le domaine avant mettre en ordre ? 
		}

		if (valStrategy == VAL_RANDOM) {
			return //prendre les valeurs du domain + random 
		}

		return availableValues.get(0);
	}

}

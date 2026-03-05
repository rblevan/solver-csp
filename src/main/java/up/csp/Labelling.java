package up.csp;

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
		if (varStrategy == VAR_FIRST_UNASSIGNED) {
			//code to select the first unassigned variable
			return null;
		}
		if (varStrategy == VAR_MIN) {
			//code to select the variable with the smallest domain
			return null;
		}
		if (varStrategy == VAR_RANDOM) {
			//code to select a random unassigned variable
			return null;
		}
		return null;
	}

	/**
	 * Selects the next value to try for a given variable.
	 *
	 * @param variable variable for which a value must be selected
	 * @return 
	 */
	public int selectValue(Variable variable) 
	{
		if (valStrategy == VAL_IN_ORDER) {
			//code to select the next value in order
			return 0;
		}
		if (valStrategy == VAL_RANDOM) {
			//code to select a random value 
			return 0;
		}
		return -1;
	}

}

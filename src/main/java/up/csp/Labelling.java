package up.csp;

import java.util.ArrayList;
import java.util.Collections;
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

	public void setVarStrategy(int strategy) 
	{
		switch (strategy) {
			case VAR_FIRST_UNASSIGNED:
			case VAR_MIN:
			case VAR_RANDOM:
				this.varStrategy = strategy;
				break;
			default:
				throw new IllegalArgumentException("Unknown variable strategy: " + strategy);
		}
	}

	public void setValStrategy(int strategy)
	{	switch (strategy) {
			case VAL_IN_ORDER:
			case VAL_RANDOM:
				this.valStrategy = strategy;
				break;
			default:
				throw new IllegalArgumentException("Unknown value strategy: " + strategy);
		}
	}

	public Variable selectVariable(CSP csp) 
	{
		if (csp == null) {
			return null;
		}

		List<Variable> v_unassigned =new ArrayList<>();
		for (Variable variable : csp.getVariables()) {
			if (!variable.isAssigned()) 
			{
				v_unassigned.add(variable);
			}
		}
		if (v_unassigned.isEmpty()) 
		{return null;}

		if (varStrategy == VAR_FIRST_UNASSIGNED) 
		{
			return v_unassigned.get(0);	}

		if (varStrategy == VAR_MIN) {
			Variable best= v_unassigned.get(0);
			for (Variable curr : v_unassigned) {
				if (curr.getDomain().size() < best.getDomain().size()) {
					best = curr;
				}
			}return best;
		}
		if (varStrategy ==VAR_RANDOM) {
			return v_unassigned.get(random.nextInt(v_unassigned.size()));
		}

		return v_unassigned.get(0);
	}


	public List<Integer> orderValues(Variable variable)
	{
		List<Integer> availableValues = new ArrayList<>();
		if (variable == null || variable.getDomain() == null) {
			return availableValues;
		}
		Domain domain = variable.getDomain();
		for (int value =domain.getMin(); value <= domain.getMax(); value++) {
			if (domain.contains(value)) {
				availableValues.add(value);
			}
		}

		if (valStrategy == VAL_RANDOM) {
			Collections.shuffle(availableValues, random);
		}

		return availableValues;
	}

}

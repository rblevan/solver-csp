package up.csp;

import java.util.Random;

public class Labelling {

	public enum VarStrategy 
	{
    	FIRST_UNASSIGNED,  // première variable non assignée
    	MIN_REMAINING,     // plus petit domaine (MRV)
    	RANDOM             // aléatoire
	}

	public enum ValStrategy 
	{
   		IN_ORDER,   // ordre croissant
    	RANDOM      // aléatoire
	}

	private VarStrategy varStrategy = VarStrategy.FIRST_UNASSIGNED;
	private ValStrategy valStrategy = ValStrategy.IN_ORDER;
	private final Random random = new Random();

	public void setVarStrategy(VarStrategy strategy) 
	{
    	this.varStrategy = strategy;
	}

	public void setValStrategy(ValStrategy strategy)
	{
    	this.valStrategy = strategy;
	}

	
	


}
package up.csp;

/**
 * Provides functionality to create and manage backtracking stack elements
 * <p>
 * Each stack elements is composed of a {@link Variable}, an integer {@link #value} and a {@link #reason}.
 * </p>
 * @author Antoine GIRET
 */
public class BacktrackStep {

	private final Variable var;
	private final int value;
	private final String reason;

	/**
	 * Constructor for BacktrackStep class
	 * @param var modified Variable
	 * @param val tested value
	 * @param reason reason for adding this step to the stack
	 */
	public BacktrackStep(Variable var, int val, String reason) {
        this.var = var;
        this.value = val;
        this.reason = reason;
	}

    public Variable getVar(){
        return this.var;
    }

    public int getValue(){
        return  this.value;
    }

    public String getReason(){
        return this.reason;
    }
}
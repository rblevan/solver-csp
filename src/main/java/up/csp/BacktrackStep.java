package up.csp;

public class BacktrackStep {

	private final Variable var;
	private final int value;
	private final String reason;

	/**
	 * 
	 * @param var
	 * @param val
	 * @param reason
	 */

	public BacktrackStep(Variable var, int val, String reason) {
        this.var = var;
        this.value = val;
        this.reason = reason;
	}

}
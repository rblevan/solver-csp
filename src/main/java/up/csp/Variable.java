package up.csp;

/**
 * Represents a CSP variable identified by a unique name.
 * <p>
 * A variable holds a reference to a {@link Domain} containing its possible values
 * and maintains its current assignment status. In this solver, assigned values
 * are handled as primitive integers
 * </p>
 * @author Nicolas ITEY
 */
public class Variable {

    private String name;
    private Domain domain;
    private Integer value;

    /**
     * Constructor for the Variable class
     * @param name unique name for the Variable
     * @param domain the domain must be enumerable,so it must be a sequence
     * @param value must be null if unassigned. this is the assigned value you are trying to find
     */
    public Variable(String name, Domain domain) {
        this.name = name;
        this.domain = domain;

    }

    /**
     * Verify if the value has been assigned or not, return true if it has and false if it hasn't
     * @return boolean
     */
    public boolean isAssigned() {
        return value != null;
    }

    /**
     * Assign the value searched to the Variable
     * @param value the value of the Variable 
     * @throws IllegalArgumentException if the parameter is invalid
     */
    public void assign(int value) {
        if (!domain.contains(value)) {
            throw new IllegalArgumentException(
                    "Value " + value + " not in domain"
            );
        }
        this.value = value;
    }

    /**
     * Unassign the value of the Variable and turn it into null
     */
    public void unassign() {
        if (isAssigned()) {
            this.value = null;
        }
    }

    /**
     * Get the name
     */
    public String getName() {

        return this.name;
    }

    /**
     * Get the domain
     */
    public Domain getDomain() {

        return this.domain;
    }

    /**
     * Get the Value
     */
    public Integer getValue() {

        return this.value;

    }
}

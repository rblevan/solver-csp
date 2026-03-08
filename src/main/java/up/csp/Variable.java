package up.csp;

public class Variable {

    private String name; // Unique name for the Variable
    private Domain domain; // The domain must be enumerable,so it must be a sequence 
    private Integer value; // must be null if unassigned. this is the assigned value you are trying to find    

    /**
     * @author Nicolas ITEY This is the constructor for the Variable class
     * @param name
     * @param domain
     * @param value
     * Constructor of the class Variable 
     */
    public Variable(String name, Domain domain) {
        this.name = name;
        this.domain = domain;

    }

    /**
     * @author Nicolas ITEY
     * @return  a boolean 
     * The function verify if the value has been assigned or not,return true if it has and false if it hasn't.
     */
    public boolean isAssigned() {
        return value != null;
    }

    /**
     * @author Nicolas ITEY
     * @param value the value of the Variable 
     * @throws IllegalArgumentException if the parameter is invalid
     * the function will assign the value searched to the Variable.
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
     * @author Nicolas ITEY
     * this function will unassign the value of the Variable and turn it into null
     */
    public void unassign() {
        if (isAssigned()) {
            this.value = null;
        }
    }

    /**
     * @author Nicolas ITEY 
     * Get the name
     */
    public String getName() {

        return this.name;
    }

    /**
     * @author Nicolas ITEY
     * Get the domain
     */
    public Domain getDomain() {

        return this.domain;
    }

    /**
     * @author Nicolas ITEY
     * Get the Value
     */
    public Integer getValue() {

        return this.value;

    }
}

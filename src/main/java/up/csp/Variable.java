package up.csp;

;

public class Variable {

    private String name; // Unique name for the Variable
    private Domain domain; // The domain must be enumerable,so it must be a sequence 
    private Integer value; // must be null if unassigned. this is the assigned value you are trying to find    

    /**
     * @author Nicolas ITEY This is the constructor for the Variable class
     * @param name
     * @param domain
     * @param value
     * @return A FAIRE
     */

    //peut etre rajouté un idvalutaion pour trouver la position dans le tableau
    public Variable(String name, Domain domain) {
        this.name = name;
        this.domain = domain;

    }

    public boolean isAssigned() {
        return value != null;
    }

    public void assign(int value) {
        if (!domain.contains(value)) {
            throw new IllegalArgumentException(
                    "Value " + value + " not in domain"
            );
        }
        this.value = value;
    }

    public void unassign() {
    if (isAssigned()) {
        this.value = null;
    }
}

    public String getName() {

        return this.name;
    }

    public Domain getDomain() {

        return this.domain;
    }

    public Integer getValue() {

        return this.value;

    }
}

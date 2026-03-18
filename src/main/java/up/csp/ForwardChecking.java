package up.csp;

import java.util.List;

public class ForwardChecking {

    private List<Variable> variable;

    public ForwardChecking(List<Variable> variable) {
        this.variable = variable;

    }

    public boolean forwardCheck(Variable var) {
        int value = var.getValue();

        for (Variable thevar : variable) {
            
            if (!thevar.isAssigned() && thevar != var) {
                
                Domain domain = thevar.getDomain();
                
                for (int v = domain.getMin(); v <= domain.getMax(); v++) {
                    
                    if (domain.contains(v) && v == value) {
                    
                        domain.removeValue(v);
                    }
                } if (domain.size() == 0) {
                    return false; // backtracking ? 
                }

            }
        }
        return true;

    }
}

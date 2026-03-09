package up.csp;

import up.csp.constraint.Constraint;

public class ForwardChecking {
// manque le fait de l'utiliser dans le constraint 
    private CSP csp;

    public ForwardChecking(CSP csp) {
        this.csp = csp;

    }
//check pour chaque value de variable si elle fait partie du domain,si oui  alors on la supp de domain,si domaine vide on backtrack
    public boolean forwardCheck(Variable var) {
        int value = var.getValue();

        for (Constraint constraint : csp.getConstraints()) {
            return false;
        }/* 
            if (!thevar.isAssigned() && thevar != var) {
                
                Domain domain = thevar.getDomain();
                
                for (int v = domain.getMin(); v <= domain.getMax(); v++) {
                    
                    if (domain.contains(v) && v == value) {
                    
                        domain.removeValue(v);
                    }
                } if (domain.size() == 0) {
                    return false; // backtracking ? 
                }

            }*/
        return true;

    }
}

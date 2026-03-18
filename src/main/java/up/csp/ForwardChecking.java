package up.csp;

import java.util.List;
//mettre dans la doc fait par  chloe et nicolas
public class ForwardChecking {
// manque le fait de l'utiliser dans le constraint 
    private List<Variable> variable;

    public ForwardChecking(List<Variable> variable) {
        this.variable = variable;

    }
//check pour chaque value de variable si elle fait partie du domain,si oui  alors on la supp de domain,si domaine vide on backtrack
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

package up.csp.constraint;


import java.util.List;
import java.util.Objects;

import up.csp.Variable;

/**
 * Implementation of Alldifferents constraint
 * @author Chloé Lemaire
 */
public class AllDifferent {
    private final List<Variable> variables;
    
    /**
    * @param differentVariables list of variables that needs to be different
    */
    protected AllDifferent(List<Variable> differentVariables){
        variables=differentVariables;
    }

    public boolean check(){
        boolean isDifferent = true;
        for(int i=0;i<variables.size()-1 && isDifferent;i++){
            for(int j=i+1;j<variables.size() && isDifferent;j++){
                isDifferent=!Objects.equals(variables.get(i).getValue(), variables.get(j).getValue());
            }
        }
        return isDifferent;
    }
}
package up.csp.constraint;


import java.util.List;
import java.util.Objects;

import up.csp.Variable;
public class AllDifferent extends Constraint {
    private final List<Variable> variables;
    
    /**@author Chloé Lemaire
    @param differentVariables list of variables that needs to be different
    */
    protected AllDifferent(List<Variable> differentVariables){
        variables=differentVariables;
    }

    @Override
    public boolean check(){
        boolean isDifferent = true;
        for(int i=0;i<variables.size()-1 && isDifferent;i++){
            for(int j=i+1;j<variables.size() && isDifferent;j++){
                isDifferent=!Objects.equals(variables.get(i).getValue(), variables.get(j).getValue());
            }
        }
        return isDifferent;
    }

    @Override
    public void set(){
        
    }
}
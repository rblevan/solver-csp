package up.csp.constaint;


import up.csp.Variable;
import java.util.List;
public class AllDifferent {
    private List<Variable> variables;
    /**@author Chloé Lemaire
    @param differentVariables liste de variables qui doivent tous être différents
    */
    protected AllDifferent(List<Variable> differentVariables){
        variables=differentVariables;
    }

    public boolean check(){
        boolean isDifferent = true;
        for(int i=0;i<variables.size()-1 && isDifferent;i++){
            for(int j=i+1;j<variables.size() && isDifferent;j++){
                isDifferent=variables.get(i).getValue()!=variables.get(j).getValue();
            }
        }
        return isDifferent;
    }
}
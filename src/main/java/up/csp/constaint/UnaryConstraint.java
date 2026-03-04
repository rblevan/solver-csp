package up.csp.constaint;

import up.csp.Variable;
public class UnaryConstraint extends Constraint{

    private Variable var ;
    private boolean equals ;
    private int value;

    /**@author Chloé Lemaire
    @param v la variable à comparer
    @param value la valeur à comparer
    @param isEqual fait la différence entre la contrainte d'égalité et d'inégalité
    */
    protected UnaryConstraint(Variable v,int value,boolean isEqual){
        var = v;
        equals = isEqual;
        this.value =value; 
    }

    public boolean check(){
        if(equals){
            return var.getValue()==value;
        }else{
            return var.getValue()!=value;
        }
    }
}
package up.csp.constraint;

import up.csp.Variable;
public class UnaryConstraint extends Constraint{

    private final Variable var ;
    private final boolean equals ;
    private final int value;

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

    @Override
    public boolean check(){
        if(equals){
            if(var.isAssigned()){
                return var.getDomain().contains(value);
            }
        }else{
            if(var.isAssigned()){
                return !var.getDomain().contains(value);
            }
        }
        return false;
    }

    @Override
    public void set(){
        if(equals){
            if (var.getDomain().contains(value)){
                var.assign(value);
            }
        }else{
            if(var.getDomain().contains(value)){
                var.getDomain().removeValue(value);
            }
        }
    }
}
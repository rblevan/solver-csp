package up.csp.constraint;

import up.csp.Variable;

/**
 * Implementation of BinaryConstraint constraint
 * @author Chloé Lemaire
 */
public class BinaryConstraint extends Constraint{
    private final Variable varA ;
    private final Variable varB ;
    private final int constant ;
    private final char mode;

    /**@author Chloé Lemaire
    @param a left variable in : a=b,a!=b+c and a<b+c
    @param b right variable in :  a=b,a!=b+c and a<b+c
    @param c constant in : a=b,a!=b+c and a<b+c
    @param mode character describing how to compare the variables e for equals d for different and u for under
    */
    protected BinaryConstraint(Variable a,Variable b,int constant,char mode){
        varA=a;
        varB=b;
        this.constant = constant;
        String allModes = "edu";
        if(allModes.indexOf(mode)!=-1){
            this.mode = mode;
        }else{
            this.mode = ' ';
        }
    }

    @Override
    public boolean check() {
        boolean res = false;
        switch (mode){
            case 'e' -> {
                    if(varA.isAssigned() &&varB.isAssigned()){
                        res= varA.getValue()== varB.getValue()+constant;
                    }
                }
            case 'd' -> {
                    if(varA.isAssigned() &&varB.isAssigned()){
                        res= varA.getValue()!=varB.getValue()+constant;
                    }
                }
            case 'u' -> {
                    if(varA.isAssigned() &&varB.isAssigned()){
                        res= varA.getValue()<varB.getValue()+constant;
                    }
                }
        }
        return res;
    }

}
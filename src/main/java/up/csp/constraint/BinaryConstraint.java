package up.csp.constraint;

import up.csp.Variable;

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
                    for(int i=varA.getDomain().getMin();i<varA.getDomain().getMax();i++){
                        if(varA.getDomain().contains(i)!=varB.getDomain().contains(i)){
                            return false;
                        }
                        
                    }
                    return true;
                }
            case 'd' -> {
                    for(int i=varA.getDomain().getMin();i<varA.getDomain().getMax();i++){
                        if(varA.getDomain().contains(i)==varB.getDomain().contains(i+constant)){
                            return false;
                        }
                    }
                    return true;
                }
            case 'u' -> {
                    for(int i=varB.getDomain().getMin();i<varA.getDomain().getMax();i++){
                        if(varA.getDomain().contains(i)){
                            return false;
                        }
                    }
                }
        }
        return res;
    }

    @Override 
    public void set(){
        switch(mode){
            case 'e' ->{varA.getDomain().intersection(varB.getDomain());}
            case 'd' ->{if(varA.isAssigned()){
                            varB.getDomain().removeValue(varA.getValue()-constant);
                        }
                        if(varB.isAssigned()){
                            varA.getDomain().removeValue(varB.getValue()+constant);
                        }
                    }
            case 'u' ->{
                if(varA.isAssigned()){
                    for(int i=varB.getDomain().getMin();i<varA.getValue()-constant;i++){
                        varB.getDomain().removeValue(i-constant);
                    }
                }
                if(varB.isAssigned()){
                    for(int i = varA.getDomain().getMax();i>=varB.getValue()+constant;i--){
                        varA.getDomain().removeValue(i);
                    }
                }

            }
        }
    }

}
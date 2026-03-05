package up.csp.constaint;

import java.util.Objects;

import up.csp.Variable;

public class BinaryConstraint extends Constraint{
    private final Variable varA ;
    private final Variable varB ;
    private final int constant ;
    private final char mode;

    /**@author Chloé Lemaire
    @param a variable à gauche de la contrainte dans a=b,a!=b+c et a<b+c
    @param b variable à droite de la contrainte dans a=b,a!=b+c et a<b+c
    @param c constante de la contrainte dans a=b,a!=b+c et a<b+c
    @param mode charactere représentant quel opération calculer sur les variables
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
            case 'e' -> res= Objects.equals(varA.getValue(), varB.getValue());
            case 'd' -> res= varA.getValue()!=varB.getValue()+constant;
            case 'u' -> res= varA.getValue()<varB.getValue()+constant;
        }
        return res;
    }

}
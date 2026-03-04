package up.csp.constaint;

import java.util.*;
import up.csp.Variable;
public abstract class Constraint {


	public abstract boolean check();

	/** @author Chloé lemaire
	 * @param var la variable à vérifier l'égalité
	 * @param i la valeur sur le quel vérifier l'égalité
	 * @return une contrainte unaire représentant l'égalité var = i
	 */
	public static UnaryConstraint equal(Variable var,int i){
		return new UnaryConstraint(var, i, true);
	} 

	/** @author Chloé lemaire
	 * @param var la variable à vérifier l'inégalité
	 * @param i la valeur sur le quel vérifier l'inégalité
	 * @return une contrainte unaire représentant l'inégalité var = i
	 */
	public static UnaryConstraint different(Variable var,int i){
		return new UnaryConstraint(var, i, false);
	} 
	
	/**@author Chloé lemaire
	 * @param a première variable sur le quel il faut vérifier l'égalité
	 * @param b deuxième variable sur le quel il faut vérifier l'égalité
	 * @return contrainte binaire représentant l'égalité a=b
	 */
	public static BinaryConstraint equal(Variable a,Variable b){
		return new BinaryConstraint(a, b, 0, 'e');
	}
	
	/**@author Chloé lemaire
	 * @param a première variable sur le quel il faut vérifier l'inégalité
	 * @param b deuxième variable sur le quel il faut vérifier l'inégalité
	 * @param c la constante utilisé dans l'inégalité
	 * @return contrainte binaire représentant l'inégalité a!=b+c
	 */
	public static BinaryConstraint different(Variable a,Variable b,int c){
		return new BinaryConstraint(a, b, c, 'd');
	}

	/**@author Chloé lemaire
	 * @param a première variable sur le quel il faut vérifier l'infériorité
	 * @param b deuxième variable sur le quel il faut vérifier l'infériorité
	 * @param c la constante utilisé dans l'infériorité
	 * @return contrainte binaire représentant l'infériorité a<b+c
	 */
	public static BinaryConstraint under(Variable a,Variable b,int c){
		return new BinaryConstraint(a, b, c, 'u');
	}

	/**
	 * 
	 * @param v liste de variable sur les quels on vérifie qu'ils sont tous différent
	 * @return une contrainte représentant le fait que toute les variables de la liste soit différent
	 */
	public static AllDifferent allDifferent(ArrayList<Variable> v){
		return new AllDifferent(v);
	}
}
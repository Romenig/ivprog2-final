/** 
 * Instituto de Matemática e Estatística da Universidade de São Paulo (IME-USP)
 * iVProg is a open source and free software of Laboratório de Informática na 
 * Educação (LInE) licensed under GNU GPL2.0 license.
 * Prof. Dr. Leônidas de Oliveira Brandão - leo@ime.usp.br
 * Romenig da Silva Ribeiro - romenig@ime.usp.br | romenig@gmail.com
 * @author Romenig
 */
package usp.ime.line.ivprog.interpreter.execution.expressions.value;

import usp.ime.line.ivprog.interpreter.execution.Context;

public class IVPBoolean extends IVPValue {

	/**
	 * Updates the boolean value to the given value inside the given context.
	 * @param context
	 * @param bool
	 */
	public void updateValue(Context context, Boolean bool) {
		context.updateBoolean(getUniqueID(), bool);
	}

}

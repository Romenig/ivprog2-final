/** 
 * Instituto de Matem�tica e Estat�stica da Universidade de S�o Paulo (IME-USP)
 * iVProg is a open source and free software of Laborat�rio de Inform�tica na 
 * Educa��o (LInE) licensed under GNU GPL2.0 license.
 * Prof. Dr. Le�nidas de Oliveira Brand�o - leo@ime.usp.br
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

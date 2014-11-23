/** 
 * Instituto de Matem�tica e Estat�stica da Universidade de S�o Paulo (IME-USP)
 * iVProg is a open source and free software of Laborat�rio de Inform�tica na 
 * Educa��o (LInE) licensed under GNU GPL2.0 license.
 * Prof. Dr. Le�nidas de Oliveira Brand�o - leo@ime.usp.br
 * Romenig da Silva Ribeiro - romenig@ime.usp.br | romenig@gmail.com
 * @author Romenig
 */
package usp.ime.line.ivprog.interpreter.execution.code;

import java.util.HashMap;

import usp.ime.line.ivprog.interpreter.DataFactory;
import usp.ime.line.ivprog.interpreter.DataObject;
import usp.ime.line.ivprog.interpreter.execution.Context;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPValue;

public class Return extends DataObject {
	
	private String returnable;

	/* (non-Javadoc)
	 * @see usp.ime.line.ivprog.interpreter.DataObject#evaluate(usp.ime.line.ivprog.interpreter.execution.Context, java.util.HashMap, usp.ime.line.ivprog.interpreter.DataFactory)
	 */
	public Object evaluate(Context c, HashMap map, DataFactory factory) {
		DataObject value = (DataObject) ((DataObject)map.get(returnable)).evaluate(c, map, factory);
		return value;
	}

	/**
	 * @return the returnable
	 */
    public String getReturnable() {
	    return returnable;
    }

	/**
	 * @param returnable the returnable to set
	 */
    public void setReturnable(String returnable) {
	    this.returnable = returnable;
    }

}

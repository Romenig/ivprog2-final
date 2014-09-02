/** 
 * Instituto de Matem�tica e Estat�stica da Universidade de S�o Paulo (IME-USP)
 * iVProg is a open source and free software of Laborat�rio de Inform�tica na 
 * Educa��o (LInE) licensed under GNU GPL2.0 license.
 * Prof. Dr. Le�nidas de Oliveira Brand�o - leo@ime.usp.br
 * Romenig da Silva Ribeiro - romenig@ime.usp.br | romenig@gmail.com
 * @author Romenig
 */
package usp.ime.line.ivprog.interpreter.execution.expressions.value;

import java.util.HashMap;

import usp.ime.line.ivprog.interpreter.DataFactory;
import usp.ime.line.ivprog.interpreter.DataObject;
import usp.ime.line.ivprog.interpreter.execution.Context;

public class IVPString extends IVPValue {

	/**
	 * Updates the strings' value to the given value inside the given context.
	 * 
	 * @param context
	 * @param string
	 */
	public void updateValue(Context context, String string) {
		context.updateString(getUniqueID(), string);
	}

	/* (non-Javadoc)
	 * @see usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPValue#ivpEqualTo(usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPValue, usp.ime.line.ivprog.interpreter.execution.Context, java.util.HashMap, usp.ime.line.ivprog.interpreter.DataFactory)
	 */
    @Override
    public IVPBoolean ivpEqualTo(IVPValue v, Context c, HashMap<String, DataObject> map, DataFactory factory) {
    	IVPBoolean result = factory.createIVPBoolean();
		Boolean booleanResult = new Boolean(c.getString(getUniqueID()).equals(c.getString(v.getUniqueID())));
		c.addBoolean(result.getUniqueID(), booleanResult);
		return result;
    }

	/* (non-Javadoc)
	 * @see usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPValue#ivpNotEqualTo(usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPValue, usp.ime.line.ivprog.interpreter.execution.Context, java.util.HashMap, usp.ime.line.ivprog.interpreter.DataFactory)
	 */
    @Override
    public IVPBoolean ivpNotEqualTo(IVPValue v, Context c, HashMap<String, DataObject> map, DataFactory factory) {
    	IVPBoolean result = factory.createIVPBoolean();
		Boolean booleanResult = new Boolean(!c.getString(getUniqueID()).equals(c.getString(v.getUniqueID())));
		c.addBoolean(result.getUniqueID(), booleanResult);
		return result;
    }
    
}

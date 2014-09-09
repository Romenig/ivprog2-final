/** 
 * Instituto de Matemática e Estatística da Universidade de São Paulo (IME-USP)
 * iVProg is a open source and free software of Laboratório de Informática na 
 * Educação (LInE) licensed under GNU GPL2.0 license.
 * Prof. Dr. Leônidas de Oliveira Brandão - leo@ime.usp.br
 * Romenig da Silva Ribeiro - romenig@ime.usp.br | romenig@gmail.com
 * @author Romenig
 */
package usp.ime.line.ivprog.interpreter.execution.code;

import java.math.BigDecimal;
import java.util.HashMap;

import usp.ime.line.ivprog.interpreter.DataFactory;
import usp.ime.line.ivprog.interpreter.DataObject;
import usp.ime.line.ivprog.interpreter.execution.Context;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPBoolean;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPNumber;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPValue;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPVariable;

/**
 * @author Romenig
 *
 */
public class AttributionLine extends CodeComponent {
	
	private String variableID;
	private String expressionID;

	/* (non-Javadoc)
	 * @see usp.ime.line.ivprog.interpreter.DataObject#evaluate(usp.ime.line.ivprog.interpreter.execution.Context, java.util.HashMap, usp.ime.line.ivprog.interpreter.DataFactory)
	 */
    @Override
    public Object evaluate(Context c, HashMap<String, DataObject> map, DataFactory factory) {
    	IVPVariable variable = (IVPVariable) map.get(variableID);
    	IVPValue value = (IVPValue) map.get(expressionID).evaluate(c, map, factory);
    	IVPValue copyOfValue = createCopy(value, c, map, factory);
    	variable.setValueID(copyOfValue.getUniqueID());
	    return null;
    }

    private IVPValue createCopy(IVPValue value, Context c, HashMap<String, DataObject> map, DataFactory factory) {
    	IVPValue copy = null;
    	if(value instanceof IVPNumber){
    		copy = factory.createIVPNumber();
    		c.addBigDecimal(copy.getUniqueID(), new BigDecimal(c.getBigDecimal(value.getUniqueID()).toString()));
    	}else if(value instanceof IVPBoolean){
    		copy = factory.createIVPNumber();
    		c.addBoolean(copy.getUniqueID(), new Boolean(c.getBoolean(value.getUniqueID()).toString()));
    	}else{
    		copy = factory.createIVPString();
    		c.addString(copy.getUniqueID(), new String(c.getString(value.getUniqueID()).toString()));
    	}
    	copy.setValueType(value.getValueType());
    	map.put(copy.getUniqueID(), copy);
    	
	    return copy;
    }

	/**
	 * Set the left member of this attribution line.
	 * attribution line:= variable = expression
	 * @param uniqueID
	 */
    public void setVariable(String uniqueID) {
    	variableID = uniqueID;
    }

	/**
	 * Set the right member of this attribution line.
	 * attribution line:= variable = expression
	 * @param uniqueID
	 */
    public void setExpression(String uniqueID) {
    	expressionID = uniqueID;
    }

}

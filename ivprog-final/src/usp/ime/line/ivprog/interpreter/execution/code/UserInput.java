/** 
 * Instituto de Matem�tica e Estat�stica da Universidade de S�o Paulo (IME-USP)
 * iVProg is a open source and free software of Laborat�rio de Inform�tica na 
 * Educa��o (LInE) licensed under GNU GPL2.0 license.
 * Prof. Dr. Le�nidas de Oliveira Brand�o - leo@ime.usp.br
 * Romenig da Silva Ribeiro - romenig@ime.usp.br | romenig@gmail.com
 * @author Romenig
 */
package usp.ime.line.ivprog.interpreter.execution.code;

import java.math.BigDecimal;
import java.util.HashMap;

import usp.ime.line.ivprog.interpreter.DataFactory;
import usp.ime.line.ivprog.interpreter.DataObject;
import usp.ime.line.ivprog.interpreter.execution.Context;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPNumber;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPValue;
import usp.ime.line.ivprog.interpreter.gui.JDialogReadInteger;

public class UserInput extends DataObject {
	
	private String type;
	private String valueID;

	/* (non-Javadoc)
	 * @see usp.ime.line.ivprog.interpreter.DataObject#evaluate(usp.ime.line.ivprog.interpreter.execution.Context, java.util.HashMap, usp.ime.line.ivprog.interpreter.DataFactory)
	 */
    @Override
    public Object evaluate(Context c, HashMap<String, DataObject> map, DataFactory factory) {
    	String theValue = IVPValue.NULL;
    	if(type.equals(IVPValue.INTEGER_TYPE)){
    		
    		JDialogReadInteger.getInstance().setVisible(true);
    		
    		theValue = JDialogReadInteger.getInstance().getValue();
    		IVPNumber number = (IVPNumber) map.get(valueID);
    		number.updateValue(c, new BigDecimal(theValue));
    	}else if(type.equals(IVPValue.DOUBLE_TYPE)){
    		
    	}else if(type.equals(IVPValue.STRING_TYPE)){
    		
    	}else if(type.equals(IVPValue.BOOLEAN_TYPE)){
    		
    	}
	    return null;
    }

	/**
	 * Set the value type to read.
	 * @param integerType
	 */
    public void setType(String integerType) {
    	type = integerType;
    }

    /**
     * Get the value type that is going to be read.
     * @return
     */
    public String getType(){
    	return type;
    }

	/**
	 * @param argument
	 */
    public void setValueID(String argument) {
	    valueID = argument;
    }

}

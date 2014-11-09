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
import java.util.Vector;

import javax.jws.soap.SOAPBinding.ParameterStyle;

import usp.ime.line.ivprog.interpreter.DataFactory;
import usp.ime.line.ivprog.interpreter.DataObject;
import usp.ime.line.ivprog.interpreter.execution.Context;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPBoolean;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPNumber;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPString;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPValue;

public class RecursiveCall extends DataObject {
	
	private String functionID;
	private Vector<String> argumentsTypes;
	private Vector<String> arguments;
	
	public RecursiveCall(){
		argumentsTypes = new Vector<String>();
		arguments = new Vector<String>();
	}

	/* (non-Javadoc)
	 * @see usp.ime.line.ivprog.interpreter.DataObject#evaluate(usp.ime.line.ivprog.interpreter.execution.Context, java.util.HashMap, usp.ime.line.ivprog.interpreter.DataFactory)
	 */
	@Override
	public Object evaluate(Context c, HashMap<String, DataObject> map, DataFactory factory) {
		Context updated = (Context) c.clone();
		updated.setFunctionID(c.getFunctionID());
		Function function = (Function) map.get(functionID);
		for(int i = 0; i < arguments.size(); i++){
			IVPValue value = (IVPValue) map.get(arguments.get(i)).evaluate(updated, map, factory);
			IVPValue argument = (IVPValue) map.get(function.getArgument(i));
			if(argument.getValueType().equals(IVPValue.INTEGER_TYPE) || argument.getValueType().equals(IVPValue.DOUBLE_TYPE)){
				((IVPNumber)argument).updateValue(updated, updated.getBigDecimal(value.getUniqueID()));
			}
			map.put(value.getUniqueID(), value);
		}
		IVPValue returningValue = (IVPValue) map.get(functionID).evaluate(updated, map, factory);
		if(returningValue.getValueType().equals(IVPValue.INTEGER_TYPE) || returningValue.equals(IVPValue.DOUBLE_TYPE)){
			c.addBigDecimal(returningValue.getUniqueID(), updated.getBigDecimal(returningValue.getUniqueID()));
		}
		return returningValue;
	}

	/**
	 * @return the functionID
	 */
    public String getFunctionID() {
	    return functionID;
    }

	/**
	 * @param functionID the functionID to set
	 */
    public void setFunctionID(String functionID) {
	    this.functionID = functionID;
    }

    public String addParameter(int position, String parameter){
    	String lastParameter = IVPValue.NULL;
    	if(arguments.size() >= position && position != 0){
    		lastParameter = arguments.get(position); 
    	}
    	if(arguments.size() <= position && position != 0){
    		arguments.add(position, parameter);	
    	}else if(position == 0){
    		arguments.add(parameter);
    	}
    	return lastParameter;
    }
}
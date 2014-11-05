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

public class Function extends CodeComposite {

	private String functionName;
	private String functionReturnType;

	public Function() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * usp.ime.line.ivprog.interpreter.DataObject#evaluate(usp.ime.line.ivprog
	 * .interpreter.execution.Context, java.util.HashMap,
	 * usp.ime.line.ivprog.interpreter.DataFactory)
	 */
	@Override
	public Object evaluate(Context c, HashMap<String, DataObject> map, DataFactory factory) {
		for (int i = 0; i < children.size(); i += 1) {
			DataObject component = (DataObject) map.get(children.get(i));
			component.evaluate(c, map, factory);
		}
		return null;
	}

	/**
	 * Add a new constant to this function context.
	 * 
	 * @param constant
	 * @param constantValue
	 * @param context
	 * @param map
	 */
	public void addConstant(IVPValue constant, String constantValue, Context context, HashMap<String, DataObject> map) {
		if (constant.getValueType().equals(IVPValue.INTEGER_TYPE) || constant.getValueType().equals(IVPValue.DOUBLE_TYPE)) {
			context.addBigDecimal(constant.getUniqueID(), new BigDecimal(constantValue));
		} else if (constant.getValueType().equals(IVPValue.STRING_TYPE)) {
			context.addString(constant.getUniqueID(), constantValue);
		} else if (constant.getValueType().equals(IVPValue.BOOLEAN_TYPE)) {
			context.addBoolean(constant.getUniqueID(), new Boolean(constantValue));
		}
		map.put(constant.getUniqueID(), constant);
	}

	/**
	 * Add a new variable to this function.
	 * 
	 * @param variable
	 * @param value
	 * @param context
	 * @param map
	 * @param factory
	 */
	public void addVariable(IVPVariable variable, String value, Context context, HashMap<String, DataObject> map, DataFactory factory) {
		IVPValue varValue = null;
		if (variable.getVariableType().equals(IVPValue.INTEGER_TYPE) || variable.getVariableType().equals(IVPValue.DOUBLE_TYPE)) {
			varValue = factory.createIVPNumber();
			context.addBigDecimal(varValue.getUniqueID(), new BigDecimal(value));
		} else if (variable.getVariableType().equals(IVPValue.STRING_TYPE)) {
			varValue = factory.createIVPString();
			context.addString(varValue.getUniqueID(), value);
		} else if (variable.getVariableType().equals(IVPValue.BOOLEAN_TYPE)) {
			varValue = factory.createIVPBoolean();
			context.addBoolean(varValue.getUniqueID(), new Boolean(value));
		}
		varValue.setValueType(variable.getVariableType());
		variable.setValueID(varValue.getUniqueID());
		map.put(variable.getUniqueID(), variable);
		map.put(varValue.getUniqueID(), varValue);
	}

	/**
	 * Get the function name.
	 * 
	 * @return the functionName
	 */
	public String getFunctionName() {
		return functionName;
	}

	/**
	 * Set the function name.
	 * 
	 * @param functionName
	 *            the functionName to set
	 */
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	/**
	 * Get the function returning type.
	 * 
	 * @return the functionReturnType
	 */
	public String getFunctionReturnType() {
		return functionReturnType;
	}

	/**
	 * Set the function return type.
	 * 
	 * @param functionReturnType
	 *            the functionReturnType to set
	 */
	public void setFunctionReturnType(String functionReturnType) {
		this.functionReturnType = functionReturnType;
	}

}

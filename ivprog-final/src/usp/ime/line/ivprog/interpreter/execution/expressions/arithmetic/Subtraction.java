/** 
 * Instituto de Matem�tica e Estat�stica da Universidade de S�o Paulo (IME-USP)
 * iVProg is a open source and free software of Laborat�rio de Inform�tica na 
 * Educa��o (LInE) licensed under GNU GPL2.0 license.
 * Prof. Dr. Le�nidas de Oliveira Brand�o - leo@ime.usp.br
 * Romenig da Silva Ribeiro - romenig@ime.usp.br | romenig@gmail.com
 * @author Romenig
 */
package usp.ime.line.ivprog.interpreter.execution.expressions.arithmetic;

import java.util.HashMap;

import usp.ime.line.ivprog.interpreter.DataFactory;
import usp.ime.line.ivprog.interpreter.DataObject;
import usp.ime.line.ivprog.interpreter.execution.Context;
import usp.ime.line.ivprog.interpreter.execution.expressions.Expression;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPNumber;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPValue;

public class Subtraction extends Expression {

	private String expA;
	private String expB;

	/**
	 * Set the left expression of addition. Addition := expressionA -
	 * expressionB
	 * 
	 * @param expressionA
	 */
	public void setExpressionA(String expressionA) {
		expA = expressionA;
	}

	/**
	 * Set the right expression of addition. Addition := expressionA -
	 * expressionB
	 * 
	 * @param expressionB
	 */
	public void setExpressionB(String expressionB) {
		expB = expressionB;
	}

	public Object evaluate(Context c, HashMap map, DataFactory factory) {
		IVPNumber v1 = (IVPNumber) ((DataObject)map.get(expA)).evaluate(c, map, factory);
		IVPNumber v2 = (IVPNumber) ((DataObject)map.get(expB)).evaluate(c, map, factory);
		IVPNumber result = v1.subtract(v2, c, factory, map);
		return result;
	}

}

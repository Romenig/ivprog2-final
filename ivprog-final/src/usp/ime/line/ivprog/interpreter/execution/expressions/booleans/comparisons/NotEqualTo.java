/** 
 * Instituto de Matem�tica e Estat�stica da Universidade de S�o Paulo (IME-USP)
 * iVProg is a open source and free software of Laborat�rio de Inform�tica na 
 * Educa��o (LInE) licensed under GNU GPL2.0 license.
 * Prof. Dr. Le�nidas de Oliveira Brand�o - leo@ime.usp.br
 * Romenig da Silva Ribeiro - romenig@ime.usp.br | romenig@gmail.com
 * @author Romenig
 */
package usp.ime.line.ivprog.interpreter.execution.expressions.booleans.comparisons;

import java.util.HashMap;

import usp.ime.line.ivprog.interpreter.DataFactory;
import usp.ime.line.ivprog.interpreter.DataObject;
import usp.ime.line.ivprog.interpreter.execution.Context;
import usp.ime.line.ivprog.interpreter.execution.expressions.Expression;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPBoolean;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPValue;

public class NotEqualTo extends Expression {
	
	private String expA;
	private String expB;

	/**
	 * Set the left expression of and. EqualTo := expressionA == expressionB
	 * @param expressionA
	 */
	public void setExpressionA(String expressionA) {
		expA = expressionA;
	}

	/**
	 * Set the right expression of and. EqualTo := expressionA == expressionB
	 * @param expressionB
	 */
	public void setExpressionB(String expressionB) {
		expB = expressionB;
	}
	
    @Override
    public Object evaluate(Context c, HashMap<String, DataObject> map, DataFactory factory) {
    	IVPValue expressionA = (IVPValue) map.get(expA).evaluate(c, map, factory);
    	IVPValue expressionB = (IVPValue) map.get(expB).evaluate(c, map, factory);
	    return expressionA.ivpNotEqualTo(expressionB, c, map, factory);
    }

}

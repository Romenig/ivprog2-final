/** 
 * Instituto de Matem�tica e Estat�stica da Universidade de S�o Paulo (IME-USP)
 * iVProg is a open source and free software of Laborat�rio de Inform�tica na 
 * Educa��o (LInE) licensed under GNU GPL2.0 license.
 * Prof. Dr. Le�nidas de Oliveira Brand�o - leo@ime.usp.br
 * Romenig da Silva Ribeiro - romenig@ime.usp.br | romenig@gmail.com
 * @author Romenig
 */
package usp.ime.line.ivprog.interpreter.execution.expressions.strings;

import java.math.BigDecimal;
import java.util.HashMap;

import usp.ime.line.ivprog.interpreter.DataFactory;
import usp.ime.line.ivprog.interpreter.DataObject;
import usp.ime.line.ivprog.interpreter.execution.Context;
import usp.ime.line.ivprog.interpreter.execution.expressions.Expression;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPNumber;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPString;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPValue;

public class Concatenation extends Expression {

	private String expA;
	private String expB;

	/**
	 * Set the left expression of addition. Concatenation := expressionA +
	 * expressionB
	 * 
	 * @param expressionA
	 */
	public void setExpressionA(String expressionA) {
		expA = expressionA;
	}

	/**
	 * Set the right expression of addition. Concatenation := expressionA +
	 * expressionB
	 * 
	 * @param expressionB
	 */
	public void setExpressionB(String expressionB) {
		expB = expressionB;
	}

	public Object evaluate(Context c, HashMap map, DataFactory factory) {
		IVPString str1 = (IVPString) ((DataObject)map.get(expA)).evaluate(c, map, factory);
		IVPString str2 = (IVPString) ((DataObject)map.get(expB)).evaluate(c, map, factory);
		IVPString result = str1.concatenate(str2, c, factory);
		return result;
	}

}

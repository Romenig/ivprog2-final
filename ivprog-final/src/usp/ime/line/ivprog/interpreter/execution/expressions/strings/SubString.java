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

public class SubString extends Expression {

	private String string;
	private String beginIndex;
	private String endIndex;

	/**
	 * Set the string. 
	 * @param str
	 */
	public void setString(String str) {
		string = str;
	}

	
	@Override
	public Object evaluate(Context c, HashMap<String, DataObject> map, DataFactory factory) {
		IVPString str1 = (IVPString) map.get(string).evaluate(c, map, factory);
		IVPString result = str1.substring(beginIndex, endIndex, c, factory);
		return result; 
	}


	/**
	 * Set the begin index to split the IVPString object.
	 * @param bi
	 */
    public void setBeginIndex(String bi) {
	    beginIndex = bi;
    }


	/**
	 * Set the end index to split the IVPString object.
	 * @param ei
	 */
    public void setEndIndex(String ei) {
	    endIndex = ei;
    }
    
    

}

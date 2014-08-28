/** 
 * Instituto de Matemática e Estatística da Universidade de São Paulo (IME-USP)
 * iVProg is a open source and free software of Laboratório de Informática na 
 * Educação (LInE) licensed under GNU GPL2.0 license.
 * Prof. Dr. Leônidas de Oliveira Brandão - leo@ime.usp.br
 * Romenig da Silva Ribeiro - romenig@ime.usp.br | romenig@gmail.com
 * @author Romenig
 */
package usp.ime.line.ivprog.interpreter;

import java.math.BigDecimal;

import usp.ime.line.ivprog.interpreter.execution.Context;
import usp.ime.line.ivprog.interpreter.execution.expressions.arithmetic.Addition;
import usp.ime.line.ivprog.interpreter.execution.expressions.arithmetic.Division;
import usp.ime.line.ivprog.interpreter.execution.expressions.arithmetic.Multiplication;
import usp.ime.line.ivprog.interpreter.execution.expressions.arithmetic.Subtraction;
import usp.ime.line.ivprog.interpreter.execution.expressions.booleans.And;
import usp.ime.line.ivprog.interpreter.execution.expressions.booleans.Or;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPBoolean;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPNumber;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPString;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPValue;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPVariable;
import usp.ime.line.ivprog.language.Messages;

public class DataFactory {

	private int idCount = 0;

	/**
	 * Get a new IVPNumber for a given context.
	 * 
	 * @return
	 */
	public IVPNumber createIVPNumber() {
		IVPNumber number = new IVPNumber();
		number.setUniqueID("" + idCount);
		idCount++;
		return number;
	}

	/**
	 * Get a new IVPString for a given context.
	 * 
	 * @return
	 */
	public IVPString createIVPString() {
		IVPString string = new IVPString();
		string.setUniqueID("" + idCount);
		idCount++;
		return string;
	}

	/**
	 * Get a new IVPBoolean for a given context.
	 * 
	 * @return
	 */
	public IVPBoolean createIVPBoolean() {
		IVPBoolean bool = new IVPBoolean();
		bool.setValueType(IVPValue.BOOLEAN_TYPE);
		bool.setUniqueID("" + idCount);
		idCount++;
		return bool;
	}

	/**
	 * Get a new addition for a given context.
	 * 
	 * @return
	 */
	public Addition createAddition() {
		Addition addition = new Addition();
		addition.setUniqueID("" + idCount);
		idCount++;
		return addition;
	}

	/**
	 * Get a new addition for a given context.
	 * 
	 * @return
	 */
	public Multiplication createMultiplication() {
		Multiplication multiplication = new Multiplication();
		multiplication.setUniqueID("" + idCount);
		idCount++;
		return multiplication;
	}

	/**
	 * Get a new addition for a given context.
	 * 
	 * @return
	 */
	public Subtraction createSubtraction() {
		Subtraction sub = new Subtraction();
		sub.setUniqueID("" + idCount);
		idCount++;
		return sub;
	}

	/**
	 * Get a new division for a given context.
	 * 
	 * @return
	 */
	public Division createDivision() {
		Division div = new Division();
		div.setUniqueID("" + idCount);
		idCount++;
		return div;
	}

	/**
	 * Get a new Variable for a given context.
	 * @return
	 */
    public IVPVariable createIVPVariable() {
	    IVPVariable v = new IVPVariable();
	    v.setUniqueID("" + idCount);
	    idCount++;
	    return v;
    }

    /**
	 * Get a new And for a given context.
	 * @return
	 */
    public And createAnd() {
    	And and = new And();
    	and.setUniqueID("" + idCount);
    	idCount++;
	    return and;
    }

    /**
   	 * Get a new And for a given context.
   	 * @return
   	 */
    public Or createOr() {
    	Or or = new Or();
    	or.setUniqueID("" + idCount);
    	idCount++;
	    return or;
    }

}

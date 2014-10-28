/** 
 * Instituto de Matemática e Estatística da Universidade de São Paulo (IME-USP)
 * iVProg is a open source and free software of Laboratório de Informática na 
 * Educação (LInE) licensed under GNU GPL2.0 license.
 * Prof. Dr. Leônidas de Oliveira Brandão - leo@ime.usp.br
 * Romenig da Silva Ribeiro - romenig@ime.usp.br | romenig@gmail.com
 * @author Romenig
 */
package usp.ime.line.ivprog.interpreter.execution.expressions.value;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;

import usp.ime.line.ivprog.interpreter.DataFactory;
import usp.ime.line.ivprog.interpreter.DataObject;
import usp.ime.line.ivprog.interpreter.execution.Context;

public class IVPNumber extends IVPValue {

	private static MathContext mathContext = MathContext.DECIMAL64;

	/**
	 * Updates the number value to the given value inside the given context.
	 * 
	 * @param context
	 * @param ivpNumber
	 */
	public void updateValue(Context context, BigDecimal number) {
		context.updateBigDecimal(getUniqueID(), number);
	}

	/**
	 * Return the addition of this IVPNumber to the given parameter.
	 * 
	 * @param ivpNumber
	 * @param context
	 * @param factory
	 * @return
	 */
	public IVPNumber add(IVPNumber number, Context context, DataFactory factory) {
		IVPNumber result = factory.createIVPNumber();
		BigDecimal n = context.getBigDecimal(getUniqueID()).add(context.getBigDecimal(number.getUniqueID()), mathContext);
		context.addBigDecimal(result.getUniqueID(), n);
		return result;
	}

	/**
	 * Return the multiplication of this IVPNumber to the given parameter.
	 * 
	 * @param ivpNumber
	 * @param context
	 * @param factory
	 * @return
	 */
	public IVPNumber multiply(IVPNumber number, Context context, DataFactory factory) {
		IVPNumber result = factory.createIVPNumber();
		BigDecimal n = context.getBigDecimal(getUniqueID()).multiply(context.getBigDecimal(number.getUniqueID()), mathContext);
		context.addBigDecimal(result.getUniqueID(), n);
		return result;
	}

	/**
	 * Return the division of this IVPNumber to the given parameter.
	 * 
	 * @param ivpNumber
	 * @param context
	 * @param factory
	 * @return
	 */
	public IVPNumber divide(IVPNumber number, Context context, DataFactory factory) {
		IVPNumber result = factory.createIVPNumber();
		BigDecimal n = context.getBigDecimal(getUniqueID()).divide(context.getBigDecimal(number.getUniqueID()), mathContext);
		context.addBigDecimal(result.getUniqueID(), n);
		return result;
	}

	/**
	 * Return the subtraction of this IVPNumber to the given parameter.
	 * 
	 * @param ivpNumber
	 * @param context
	 * @param factory
	 * @return
	 */
	public IVPNumber subtract(IVPNumber number, Context context, DataFactory factory) {
		IVPNumber result = factory.createIVPNumber();
		BigDecimal n = context.getBigDecimal(getUniqueID()).subtract(context.getBigDecimal(number.getUniqueID()), mathContext);
		context.addBigDecimal(result.getUniqueID(), n);
		return result;
	}

	/**
	 * Return the rest of this IVPNumber divided by the given parameter.
	 * 
	 * @param ivpNumber
	 * @param context
	 * @param factory
	 * @return
	 */
	public IVPNumber remainder(IVPNumber number, Context context, DataFactory factory) {
		IVPNumber result = factory.createIVPNumber();
		BigDecimal n = context.getBigDecimal(getUniqueID()).remainder(context.getBigDecimal(number.getUniqueID()), mathContext);
		context.addBigDecimal(result.getUniqueID(), n);
		return result;
	}

	/**
	 * Verify if this object is less than the given IVPNumber num. This method
	 * returns an IVPBoolean with true or false.
	 * 
	 * @param ivpNumber
	 * @param context
	 * @param factory
	 * @return
	 */
	public IVPBoolean lessThan(IVPNumber num, Context c, HashMap<String, DataObject> map, DataFactory factory) {
		IVPBoolean result = factory.createIVPBoolean();
		Boolean booleanResult = new Boolean(c.getBigDecimal(getUniqueID()).compareTo(c.getBigDecimal(num.getUniqueID())) < 0);
		c.addBoolean(result.getUniqueID(), booleanResult);
		return result;
	}

	/**
	 * Verify if this object is less than or equalt to the given IVPNumber num.
	 * This method returns an IVPBoolean with true or false.
	 * 
	 * @param ivpNumber
	 * @param context
	 * @param factory
	 * @return
	 */
	public IVPBoolean lessThanOrEqualTo(IVPNumber num, Context c, HashMap<String, DataObject> map, DataFactory factory) {
		IVPBoolean result = factory.createIVPBoolean();
		Boolean booleanResult = new Boolean(c.getBigDecimal(getUniqueID()).compareTo(c.getBigDecimal(num.getUniqueID())) <= 0);
		c.addBoolean(result.getUniqueID(), booleanResult);
		return result;
	}

	/**
	 * Verify if this object is greater than the given IVPNumber num. This
	 * method returns an IVPBoolean with true or false.
	 * 
	 * @param ivpNumber
	 * @param context
	 * @param factory
	 * @return
	 */
	public IVPBoolean greaterThan(IVPNumber num, Context c, HashMap<String, DataObject> map, DataFactory factory) {
		IVPBoolean result = factory.createIVPBoolean();
		Boolean booleanResult = new Boolean(c.getBigDecimal(getUniqueID()).compareTo(c.getBigDecimal(num.getUniqueID())) > 0);
		c.addBoolean(result.getUniqueID(), booleanResult);
		return result;
	}

	/**
	 * Verify if this object is greater than or equal to the given IVPNumber
	 * num. This method returns an IVPBoolean with true or false.
	 * 
	 * @param ivpNumber
	 * @param context
	 * @param factory
	 * @return
	 */
	public IVPBoolean greaterThanOrEqualTo(IVPNumber num, Context c, HashMap<String, DataObject> map, DataFactory factory) {
		IVPBoolean result = factory.createIVPBoolean();
		Boolean booleanResult = new Boolean(c.getBigDecimal(getUniqueID()).compareTo(c.getBigDecimal(num.getUniqueID())) >= 0);
		c.addBoolean(result.getUniqueID(), booleanResult);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPValue#
	 * ivpEqualTo
	 * (usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPValue,
	 * usp.ime.line.ivprog.interpreter.execution.Context, java.util.HashMap,
	 * usp.ime.line.ivprog.interpreter.DataFactory)
	 */
	@Override
	public IVPBoolean ivpEqualTo(IVPValue v, Context c, HashMap<String, DataObject> map, DataFactory factory) {
		IVPBoolean result = factory.createIVPBoolean();
		Boolean booleanResult = new Boolean(c.getBigDecimal(getUniqueID()).compareTo(c.getBigDecimal(v.getUniqueID())) == 0);
		c.addBoolean(result.getUniqueID(), booleanResult);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPValue#
	 * ivpNotEqualTo
	 * (usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPValue,
	 * usp.ime.line.ivprog.interpreter.execution.Context, java.util.HashMap,
	 * usp.ime.line.ivprog.interpreter.DataFactory)
	 */
	@Override
	public IVPBoolean ivpNotEqualTo(IVPValue v, Context c, HashMap<String, DataObject> map, DataFactory factory) {
		IVPBoolean result = factory.createIVPBoolean();
		Boolean booleanResult = new Boolean(c.getBigDecimal(getUniqueID()).compareTo(c.getBigDecimal(v.getUniqueID())) != 0);
		c.addBoolean(result.getUniqueID(), booleanResult);
		return result;
	}

}

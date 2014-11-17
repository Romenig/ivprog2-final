/** 
 * Instituto de Matem�tica e Estat�stica da Universidade de S�o Paulo (IME-USP)
 * iVProg is a open source and free software of Laborat�rio de Inform�tica na 
 * Educa��o (LInE) licensed under GNU GPL2.0 license.
 * Prof. Dr. Le�nidas de Oliveira Brand�o - leo@ime.usp.br
 * Romenig da Silva Ribeiro - romenig@ime.usp.br | romenig@gmail.com
 * @author Romenig
 */
package interpreter.expressions.arithmetic;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.HashMap;

import org.junit.Test;

import usp.ime.line.ivprog.interpreter.DataFactory;
import usp.ime.line.ivprog.interpreter.DataObject;
import usp.ime.line.ivprog.interpreter.execution.Context;
import usp.ime.line.ivprog.interpreter.execution.expressions.arithmetic.Division;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPNumber;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPValue;

public class CompleteDivisionTest {

	@Test
	public void verifyIntegerWithMixedExpression() {
		Context context = new Context();
		DataFactory factory = new DataFactory();
		IVPNumber a = factory.createIVPNumber();
		IVPNumber b = factory.createIVPNumber();
		IVPNumber c = factory.createIVPNumber();

		a.setValueType(IVPValue.DOUBLE_TYPE);
		b.setValueType(IVPValue.INTEGER_TYPE);
		c.setValueType(IVPValue.INTEGER_TYPE);

		context.addBigDecimal(a.getUniqueID(), new BigDecimal("3.4313"));
		context.addBigDecimal(b.getUniqueID(), new BigDecimal("10"));
		context.addBigDecimal(c.getUniqueID(), new BigDecimal("2"));

		Division division1 = factory.createDivision();
		division1.setExpressionA(a.getUniqueID());
		division1.setExpressionB(b.getUniqueID());

		Division division2 = factory.createDivision();
		division2.setExpressionA(c.getUniqueID());
		division2.setExpressionB(division1.getUniqueID());

		HashMap map = new HashMap();
		map.put(division1.getUniqueID(), division1);
		map.put(division2.getUniqueID(), division2);
		map.put(a.getUniqueID(), a);
		map.put(b.getUniqueID(), b);
		map.put(c.getUniqueID(), c);
		// division2(c / division1(a / b))
		// c / (a / b)

		IVPNumber result = (IVPNumber) division2.evaluate(context, map, factory);
		assertTrue(result.getValueType().equals(IVPValue.DOUBLE_TYPE));
		assertTrue(context.getBigDecimal(result.getUniqueID()).compareTo(new BigDecimal("5.828694663830035")) == 0);
	}

	@Test
	public void verifyExpressionWithInteger() {
		Context context = new Context();
		DataFactory factory = new DataFactory();
		IVPNumber a = factory.createIVPNumber();
		IVPNumber b = factory.createIVPNumber();
		IVPNumber c = factory.createIVPNumber();

		a.setValueType(IVPValue.INTEGER_TYPE);
		b.setValueType(IVPValue.INTEGER_TYPE);
		c.setValueType(IVPValue.INTEGER_TYPE);

		context.addBigDecimal(a.getUniqueID(), new BigDecimal("7"));
		context.addBigDecimal(b.getUniqueID(), new BigDecimal("10"));
		context.addBigDecimal(c.getUniqueID(), new BigDecimal("2"));

		Division division1 = factory.createDivision();
		division1.setExpressionA(a.getUniqueID());
		division1.setExpressionB(b.getUniqueID());

		Division division2 = factory.createDivision();
		division2.setExpressionA(c.getUniqueID());
		division2.setExpressionB(division1.getUniqueID());

		HashMap map = new HashMap();
		map.put(division1.getUniqueID(), division1);
		map.put(division2.getUniqueID(), division2);
		map.put(a.getUniqueID(), a);
		map.put(b.getUniqueID(), b);
		map.put(c.getUniqueID(), c);
		// division2(c / division1(a / b))
		// c / (a / b)
		IVPNumber result = (IVPNumber) division2.evaluate(context, map, factory);
		assertTrue(result.getValueType().equals(IVPValue.DOUBLE_TYPE));
		assertTrue(context.getBigDecimal(result.getUniqueID()).compareTo(new BigDecimal("2.857142857142857")) == 0);
	}

	@Test
	public void verifyExpressionWithExpression() {
		Context context = new Context();
		DataFactory factory = new DataFactory();
		IVPNumber a = factory.createIVPNumber();
		IVPNumber b = factory.createIVPNumber();
		IVPNumber c = factory.createIVPNumber();
		IVPNumber d = factory.createIVPNumber();

		a.setValueType(IVPValue.INTEGER_TYPE);
		b.setValueType(IVPValue.INTEGER_TYPE);
		c.setValueType(IVPValue.INTEGER_TYPE);
		d.setValueType(IVPValue.INTEGER_TYPE);

		context.addBigDecimal(a.getUniqueID(), new BigDecimal("7"));
		context.addBigDecimal(b.getUniqueID(), new BigDecimal("10"));
		context.addBigDecimal(c.getUniqueID(), new BigDecimal("2"));
		context.addBigDecimal(d.getUniqueID(), new BigDecimal("2"));

		Division division1 = factory.createDivision();
		division1.setExpressionA(a.getUniqueID());
		division1.setExpressionB(b.getUniqueID());

		Division division2 = factory.createDivision();
		division2.setExpressionA(c.getUniqueID());
		division2.setExpressionB(d.getUniqueID());

		Division division3 = factory.createDivision();
		division3.setExpressionA(division1.getUniqueID());
		division3.setExpressionB(division2.getUniqueID());

		HashMap map = new HashMap();
		map.put(division1.getUniqueID(), division1);
		map.put(division2.getUniqueID(), division2);
		map.put(division3.getUniqueID(), division3);
		map.put(a.getUniqueID(), a);
		map.put(b.getUniqueID(), b);
		map.put(c.getUniqueID(), c);
		map.put(d.getUniqueID(), d);
		// division3(division1(a / b) / division2(c / d))
		// ((a / b) / (c / d))
		IVPNumber result = (IVPNumber) division3.evaluate(context, map, factory);
		assertTrue(result.getValueType().equals(IVPValue.DOUBLE_TYPE));
		assertTrue(context.getBigDecimal(result.getUniqueID()).compareTo(new BigDecimal("0.7")) == 0);
	}

}

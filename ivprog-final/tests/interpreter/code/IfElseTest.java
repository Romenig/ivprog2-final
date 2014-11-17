/** 
 * Instituto de Matem�tica e Estat�stica da Universidade de S�o Paulo (IME-USP)
 * iVProg is a open source and free software of Laborat�rio de Inform�tica na 
 * Educa��o (LInE) licensed under GNU GPL2.0 license.
 * Prof. Dr. Le�nidas de Oliveira Brand�o - leo@ime.usp.br
 * Romenig da Silva Ribeiro - romenig@ime.usp.br | romenig@gmail.com
 * @author Romenig
 */
package interpreter.code;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.HashMap;

import org.junit.Test;

import usp.ime.line.ivprog.interpreter.DataFactory;
import usp.ime.line.ivprog.interpreter.DataObject;
import usp.ime.line.ivprog.interpreter.execution.Context;
import usp.ime.line.ivprog.interpreter.execution.code.AttributionLine;
import usp.ime.line.ivprog.interpreter.execution.code.Function;
import usp.ime.line.ivprog.interpreter.execution.code.IfElse;
import usp.ime.line.ivprog.interpreter.execution.expressions.booleans.comparisons.LessThanOrEqualTo;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPNumber;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPValue;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPVariable;

public class IfElseTest {

	@Test
	public void flowTest() {
		DataFactory factory = new DataFactory();
		Context context = new Context();
		Function f = factory.createFunction();

		IfElse ifElse = factory.createIfElse();

		IVPNumber leftValue = factory.createIVPNumber();
		leftValue.setValueType(IVPValue.INTEGER_TYPE);
		context.addBigDecimal(leftValue.getUniqueID(), new BigDecimal(0));

		IVPNumber comparisonValue = factory.createIVPNumber();
		comparisonValue.setValueType(IVPValue.INTEGER_TYPE);
		context.addBigDecimal(comparisonValue.getUniqueID(), new BigDecimal(10));

		IVPNumber value1 = factory.createIVPNumber();
		value1.setValueType(IVPValue.INTEGER_TYPE);
		context.addBigDecimal(value1.getUniqueID(), new BigDecimal(1));

		IVPNumber value2 = factory.createIVPNumber();
		value2.setValueType(IVPValue.INTEGER_TYPE);
		context.addBigDecimal(value2.getUniqueID(), new BigDecimal(2));

		IVPVariable v = factory.createIVPVariable();
		v.setVariableType(IVPValue.INTEGER_TYPE);
		v.setValueID(leftValue.getUniqueID());

		LessThanOrEqualTo leq = factory.createLessThanOrEqualTo();
		leq.setExpressionA(leftValue.getUniqueID());
		leq.setExpressionB(comparisonValue.getUniqueID());

		AttributionLine attLine1 = factory.createAttributionLine();
		attLine1.setVariable(v.getUniqueID());
		attLine1.setExpression(value1.getUniqueID());

		AttributionLine attLine2 = factory.createAttributionLine();
		attLine2.setVariable(v.getUniqueID());
		attLine2.setExpression(value2.getUniqueID());

		HashMap map = new HashMap();

		map.put(leftValue.getUniqueID(), leftValue);
		map.put(value1.getUniqueID(), value1);
		map.put(value2.getUniqueID(), value2);
		map.put(v.getUniqueID(), v);
		map.put(leq.getUniqueID(), leq);
		map.put(attLine1.getUniqueID(), attLine1);
		map.put(attLine2.getUniqueID(), attLine2);
		map.put(comparisonValue.getUniqueID(), comparisonValue);
		map.put(f.getUniqueID(), f);
		context.setFunctionID(f.getUniqueID());

		ifElse.setFlowCondition(leq.getUniqueID());
		ifElse.addIfChild(attLine1.getUniqueID());
		ifElse.addElseChild(attLine2.getUniqueID());

		ifElse.evaluate(context, map, factory);

		IVPNumber result = (IVPNumber) v.evaluate(context, map, factory);
		assertTrue(context.getBigDecimal(result.getUniqueID()).compareTo(new BigDecimal(1)) == 0);

		leftValue.updateValue(context, new BigDecimal(20));
		ifElse.evaluate(context, map, factory);

		result = (IVPNumber) v.evaluate(context, map, factory);
		assertTrue(context.getBigDecimal(result.getUniqueID()).compareTo(new BigDecimal(2)) == 0);

	}

	@Test
	public void remotionTest() {
		DataFactory factory = new DataFactory();
		Context context = new Context();
		Function f = factory.createFunction();
		IfElse ifElse = factory.createIfElse();

		IVPNumber leftValue = factory.createIVPNumber();
		leftValue.setValueType(IVPValue.INTEGER_TYPE);
		context.addBigDecimal(leftValue.getUniqueID(), new BigDecimal(0));

		IVPNumber comparisonValue = factory.createIVPNumber();
		comparisonValue.setValueType(IVPValue.INTEGER_TYPE);
		context.addBigDecimal(comparisonValue.getUniqueID(), new BigDecimal(10));

		IVPNumber value1 = factory.createIVPNumber();
		value1.setValueType(IVPValue.INTEGER_TYPE);
		context.addBigDecimal(value1.getUniqueID(), new BigDecimal(1));

		IVPNumber value2 = factory.createIVPNumber();
		value2.setValueType(IVPValue.INTEGER_TYPE);
		context.addBigDecimal(value2.getUniqueID(), new BigDecimal(2));

		IVPVariable v = factory.createIVPVariable();
		v.setVariableType(IVPValue.INTEGER_TYPE);
		v.setValueID(leftValue.getUniqueID());

		LessThanOrEqualTo leq = factory.createLessThanOrEqualTo();
		leq.setExpressionA(leftValue.getUniqueID());
		leq.setExpressionB(comparisonValue.getUniqueID());

		AttributionLine attLine1 = factory.createAttributionLine();
		attLine1.setVariable(v.getUniqueID());
		attLine1.setExpression(value1.getUniqueID());

		AttributionLine attLine2 = factory.createAttributionLine();
		attLine2.setVariable(v.getUniqueID());
		attLine2.setExpression(value2.getUniqueID());

		HashMap map = new HashMap();

		map.put(leftValue.getUniqueID(), leftValue);
		map.put(value1.getUniqueID(), value1);
		map.put(value2.getUniqueID(), value2);
		map.put(v.getUniqueID(), v);
		map.put(leq.getUniqueID(), leq);
		map.put(attLine1.getUniqueID(), attLine1);
		map.put(attLine2.getUniqueID(), attLine2);
		map.put(comparisonValue.getUniqueID(), comparisonValue);
		map.put(f.getUniqueID(), f);
		context.setFunctionID(f.getUniqueID());

		ifElse.setFlowCondition(leq.getUniqueID());
		ifElse.addIfChild(attLine1.getUniqueID());
		ifElse.addIfChild(attLine2.getUniqueID());
		ifElse.removeIfChildAtIndex(new BigDecimal(1));

		ifElse.evaluate(context, map, factory);

		IVPNumber result = (IVPNumber) v.evaluate(context, map, factory);
		// After removing the attLine1, the result must be 2.
		assertTrue(context.getBigDecimal(result.getUniqueID()).compareTo(new BigDecimal(1)) == 0);

	}

	@Test
	public void remotionTest2() {
		DataFactory factory = new DataFactory();
		Context context = new Context();
		Function f = factory.createFunction();
		IfElse ifElse = factory.createIfElse();

		IVPNumber leftValue = factory.createIVPNumber();
		leftValue.setValueType(IVPValue.INTEGER_TYPE);
		context.addBigDecimal(leftValue.getUniqueID(), new BigDecimal(0));

		IVPNumber comparisonValue = factory.createIVPNumber();
		comparisonValue.setValueType(IVPValue.INTEGER_TYPE);
		context.addBigDecimal(comparisonValue.getUniqueID(), new BigDecimal(10));

		IVPNumber value1 = factory.createIVPNumber();
		value1.setValueType(IVPValue.INTEGER_TYPE);
		context.addBigDecimal(value1.getUniqueID(), new BigDecimal(1));

		IVPNumber value2 = factory.createIVPNumber();
		value2.setValueType(IVPValue.INTEGER_TYPE);
		context.addBigDecimal(value2.getUniqueID(), new BigDecimal(2));

		IVPVariable v = factory.createIVPVariable();
		v.setVariableType(IVPValue.INTEGER_TYPE);
		v.setValueID(leftValue.getUniqueID());

		LessThanOrEqualTo leq = factory.createLessThanOrEqualTo();
		leq.setExpressionA(leftValue.getUniqueID());
		leq.setExpressionB(comparisonValue.getUniqueID());

		AttributionLine attLine1 = factory.createAttributionLine();
		attLine1.setVariable(v.getUniqueID());
		attLine1.setExpression(value1.getUniqueID());

		AttributionLine attLine2 = factory.createAttributionLine();
		attLine2.setVariable(v.getUniqueID());
		attLine2.setExpression(value2.getUniqueID());

		HashMap map = new HashMap();

		map.put(leftValue.getUniqueID(), leftValue);
		map.put(value1.getUniqueID(), value1);
		map.put(value2.getUniqueID(), value2);
		map.put(v.getUniqueID(), v);
		map.put(leq.getUniqueID(), leq);
		map.put(attLine1.getUniqueID(), attLine1);
		map.put(attLine2.getUniqueID(), attLine2);
		map.put(comparisonValue.getUniqueID(), comparisonValue);
		map.put(f.getUniqueID(), f);
		context.setFunctionID(f.getUniqueID());

		ifElse.setFlowCondition(leq.getUniqueID());
		ifElse.addIfChild(attLine2.getUniqueID());
		ifElse.addIfChild(attLine1.getUniqueID());
		ifElse.removeIfChild(attLine1.getUniqueID());
		ifElse.evaluate(context, map, factory);

		IVPNumber result = (IVPNumber) v.evaluate(context, map, factory);

		// After removing the attLine1, the result must be 2.
		assertTrue(context.getBigDecimal(result.getUniqueID()).compareTo(new BigDecimal(2)) == 0);

	}

	@Test
	public void remotionTest3() {
		DataFactory factory = new DataFactory();
		Context context = new Context();
		Function f = factory.createFunction();
		IfElse ifElse = factory.createIfElse();

		IVPNumber leftValue = factory.createIVPNumber();
		leftValue.setValueType(IVPValue.INTEGER_TYPE);
		context.addBigDecimal(leftValue.getUniqueID(), new BigDecimal(20));

		IVPNumber comparisonValue = factory.createIVPNumber();
		comparisonValue.setValueType(IVPValue.INTEGER_TYPE);
		context.addBigDecimal(comparisonValue.getUniqueID(), new BigDecimal(10));

		IVPNumber value1 = factory.createIVPNumber();
		value1.setValueType(IVPValue.INTEGER_TYPE);
		context.addBigDecimal(value1.getUniqueID(), new BigDecimal(1));

		IVPNumber value2 = factory.createIVPNumber();
		value2.setValueType(IVPValue.INTEGER_TYPE);
		context.addBigDecimal(value2.getUniqueID(), new BigDecimal(2));

		IVPVariable v = factory.createIVPVariable();
		v.setVariableType(IVPValue.INTEGER_TYPE);
		v.setValueID(leftValue.getUniqueID());

		LessThanOrEqualTo leq = factory.createLessThanOrEqualTo();
		leq.setExpressionA(leftValue.getUniqueID());
		leq.setExpressionB(comparisonValue.getUniqueID());

		AttributionLine attLine1 = factory.createAttributionLine();
		attLine1.setVariable(v.getUniqueID());
		attLine1.setExpression(value1.getUniqueID());

		AttributionLine attLine2 = factory.createAttributionLine();
		attLine2.setVariable(v.getUniqueID());
		attLine2.setExpression(value2.getUniqueID());

		HashMap map = new HashMap();

		map.put(leftValue.getUniqueID(), leftValue);
		map.put(value1.getUniqueID(), value1);
		map.put(value2.getUniqueID(), value2);
		map.put(v.getUniqueID(), v);
		map.put(leq.getUniqueID(), leq);
		map.put(attLine1.getUniqueID(), attLine1);
		map.put(attLine2.getUniqueID(), attLine2);
		map.put(comparisonValue.getUniqueID(), comparisonValue);
		map.put(f.getUniqueID(), f);
		context.setFunctionID(f.getUniqueID());

		ifElse.setFlowCondition(leq.getUniqueID());
		ifElse.addElseChild(attLine2.getUniqueID());
		ifElse.addElseChild(attLine1.getUniqueID());

		ifElse.removeElseChild(attLine1.getUniqueID());

		ifElse.evaluate(context, map, factory);

		IVPNumber result = (IVPNumber) v.evaluate(context, map, factory);

		// After removing the attLine1, the result must be 2.
		assertTrue(context.getBigDecimal(result.getUniqueID()).compareTo(new BigDecimal(2)) == 0);

	}

}

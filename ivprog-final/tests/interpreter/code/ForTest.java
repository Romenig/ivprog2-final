/** 
 * Instituto de Matemática e Estatística da Universidade de São Paulo (IME-USP)
 * iVProg is a open source and free software of Laboratório de Informática na 
 * Educação (LInE) licensed under GNU GPL2.0 license.
 * Prof. Dr. Leônidas de Oliveira Brandão - leo@ime.usp.br
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
import usp.ime.line.ivprog.interpreter.execution.code.For;
import usp.ime.line.ivprog.interpreter.execution.expressions.arithmetic.Addition;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPNumber;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPValue;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPVariable;

public class ForTest {

	@Test
	public void forNTimesTest() {
		DataFactory factory = new DataFactory();
		Context context = new Context();
		For f = factory.createFor();
		
		IVPValue startingValue = factory.createIVPNumber();
		startingValue.setValueType(IVPValue.INTEGER_TYPE);
		context.addBigDecimal(startingValue.getUniqueID(), new BigDecimal(0));
		
		IVPValue one = factory.createIVPNumber();
		one.setValueType(IVPValue.INTEGER_TYPE);
		context.addBigDecimal(one.getUniqueID(), new BigDecimal(1));
		
		IVPValue n_times = factory.createIVPNumber();
		n_times.setValueType(IVPValue.INTEGER_TYPE);
		context.addBigDecimal(n_times.getUniqueID(), new BigDecimal(5));
		
		IVPVariable v = factory.createIVPVariable();
		v.setVariableType(IVPValue.INTEGER_TYPE);
		v.setValueID(startingValue.getUniqueID());
		
		Addition add = factory.createAddition();
		add.setExpressionA(v.getUniqueID());
		add.setExpressionB(one.getUniqueID());

		AttributionLine attLine = factory.createAttributionLine();
		attLine.setVariable(v.getUniqueID());
		attLine.setExpression(add.getUniqueID());
		
		HashMap<String, DataObject> map = new HashMap<String, DataObject>();
		map.put(startingValue.getUniqueID(), startingValue);
		map.put(one.getUniqueID(), one);
		map.put(v.getUniqueID(), v);
		map.put(add.getUniqueID(), add);
		map.put(attLine.getUniqueID(), attLine);
		map.put(n_times.getUniqueID(), n_times);
		
		f.setExecutionMethod(For.FOR_N_TIMES);
		f.setUpperBound(n_times.getUniqueID());
		f.addChild(attLine.getUniqueID());
		f.evaluate(context, map, factory);
		
		IVPNumber result = (IVPNumber) v.evaluate(context, map, factory);
		assertTrue(context.getBigDecimal(result.getUniqueID()).compareTo(new BigDecimal(5)) == 0);
	}
	
	@Test
	public void forNTimesWithIndex() {
		DataFactory factory = new DataFactory();
		Context context = new Context();
		For f = factory.createFor();
		
		IVPValue startingValue = factory.createIVPNumber();
		startingValue.setValueType(IVPValue.INTEGER_TYPE);
		context.addBigDecimal(startingValue.getUniqueID(), new BigDecimal(0));
		
		IVPValue one = factory.createIVPNumber();
		one.setValueType(IVPValue.INTEGER_TYPE);
		context.addBigDecimal(one.getUniqueID(), new BigDecimal(1));
		
		IVPValue indexValue = factory.createIVPNumber();
		indexValue.setValueType(IVPValue.INTEGER_TYPE);
		context.addBigDecimal(indexValue.getUniqueID(), new BigDecimal(1));
		
		IVPValue n_times = factory.createIVPNumber();
		n_times.setValueType(IVPValue.INTEGER_TYPE);
		context.addBigDecimal(n_times.getUniqueID(), new BigDecimal(5));
		
		IVPVariable v = factory.createIVPVariable();
		v.setVariableType(IVPValue.INTEGER_TYPE);
		v.setValueID(startingValue.getUniqueID());
		
		IVPVariable indexVar = factory.createIVPVariable();
		indexVar.setVariableType(IVPValue.INTEGER_TYPE);
		indexVar.setValueID(indexValue.getUniqueID());
		
		Addition add = factory.createAddition();
		add.setExpressionA(v.getUniqueID());
		add.setExpressionB(one.getUniqueID());

		AttributionLine attLine = factory.createAttributionLine();
		attLine.setVariable(v.getUniqueID());
		attLine.setExpression(add.getUniqueID());
		
		HashMap<String, DataObject> map = new HashMap<String, DataObject>();
		map.put(startingValue.getUniqueID(), startingValue);
		map.put(one.getUniqueID(), one);
		map.put(indexValue.getUniqueID(), indexValue);
		map.put(v.getUniqueID(), v);
		map.put(indexVar.getUniqueID(), indexVar);
		map.put(add.getUniqueID(), add);
		map.put(attLine.getUniqueID(), attLine);
		map.put(n_times.getUniqueID(), n_times);
		
		f.setExecutionMethod(For.FOR_N_TIMES_WITH_INDEX);
		f.setIndex(indexVar.getUniqueID());
		f.setUpperBound(n_times.getUniqueID());
		f.addChild(attLine.getUniqueID());
		f.evaluate(context, map, factory);
		
		IVPNumber result = (IVPNumber) v.evaluate(context, map, factory);
		assertTrue(context.getBigDecimal(result.getUniqueID()).compareTo(new BigDecimal(5)) == 0);
		result = (IVPNumber) indexVar.evaluate(context, map, factory);
		assertTrue(context.getBigDecimal(result.getUniqueID()).compareTo(new BigDecimal(6)) == 0);
	}

	@Test
	public void forComplete() {
		DataFactory factory = new DataFactory();
		Context context = new Context();
		For f = factory.createFor();
		
		IVPValue lowerBound = factory.createIVPNumber();
		lowerBound.setValueType(IVPValue.INTEGER_TYPE);
		context.addBigDecimal(lowerBound.getUniqueID(), new BigDecimal(0));
		
		IVPValue upperBound = factory.createIVPNumber();
		upperBound.setValueType(IVPValue.INTEGER_TYPE);
		context.addBigDecimal(upperBound.getUniqueID(), new BigDecimal(5));
		
		IVPValue increment = factory.createIVPNumber();
		increment.setValueType(IVPValue.INTEGER_TYPE);
		context.addBigDecimal(increment.getUniqueID(), new BigDecimal(1));
		
		IVPValue indexStartingValue = factory.createIVPNumber();
		indexStartingValue.setValueType(IVPValue.INTEGER_TYPE);
		context.addBigDecimal(indexStartingValue.getUniqueID(), new BigDecimal(0));
		
		IVPValue one = factory.createIVPNumber();
		one.setValueType(IVPValue.INTEGER_TYPE);
		context.addBigDecimal(one.getUniqueID(), new BigDecimal(1));
		
		IVPVariable v = factory.createIVPVariable();
		v.setVariableType(IVPValue.INTEGER_TYPE);
		v.setValueID(one.getUniqueID());
		
		IVPVariable indexVar = factory.createIVPVariable();
		indexVar.setVariableType(IVPValue.INTEGER_TYPE);
		indexVar.setValueID(indexStartingValue.getUniqueID());
		
		Addition add = factory.createAddition();
		add.setExpressionA(v.getUniqueID());
		add.setExpressionB(one.getUniqueID());

		AttributionLine attLine = factory.createAttributionLine();
		attLine.setVariable(v.getUniqueID());
		attLine.setExpression(add.getUniqueID());
		
		HashMap<String, DataObject> map = new HashMap<String, DataObject>();
		map.put(lowerBound.getUniqueID(), lowerBound);
		map.put(upperBound.getUniqueID(), upperBound);
		map.put(indexStartingValue.getUniqueID(), indexStartingValue);
		map.put(v.getUniqueID(), v);
		map.put(indexVar.getUniqueID(), indexVar);
		map.put(add.getUniqueID(), add);
		map.put(attLine.getUniqueID(), attLine);
		map.put(one.getUniqueID(), one);
		
		f.setExecutionMethod(For.FOR_N_TIMES_WITH_INDEX);
		f.setIndex(indexVar.getUniqueID());
		f.setUpperBound(upperBound.getUniqueID());
		f.setLowerBound(lowerBound.getUniqueID());
		f.setIncrement(increment.getUniqueID());
		f.addChild(attLine.getUniqueID());
		f.evaluate(context, map, factory);
		
		IVPNumber result = (IVPNumber) v.evaluate(context, map, factory);
		assertTrue(context.getBigDecimal(result.getUniqueID()).compareTo(new BigDecimal(6)) == 0);
		result = (IVPNumber) indexVar.evaluate(context, map, factory);
		assertTrue(context.getBigDecimal(result.getUniqueID()).compareTo(new BigDecimal(5)) == 0);
	}
	
}

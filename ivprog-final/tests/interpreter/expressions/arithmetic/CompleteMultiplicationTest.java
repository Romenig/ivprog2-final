/** 
 * Instituto de Matemática e Estatística da Universidade de São Paulo (IME-USP)
 * iVProg is a open source and free software of Laboratório de Informática na 
 * Educação (LInE) licensed under GNU GPL2.0 license.
 * Prof. Dr. Leônidas de Oliveira Brandão - leo@ime.usp.br
 * Romenig da Silva Ribeiro - romenig@ime.usp.br | romenig@gmail.com
 * @author Romenig
 */
package interpreter.expressions.arithmetic;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.HashMap;

import org.junit.Test;

import usp.ime.line.ivprog.interpreter.DataFactory;
import usp.ime.line.ivprog.interpreter.DataObject;
import usp.ime.line.ivprog.interpreter.execution.Context;
import usp.ime.line.ivprog.interpreter.execution.expressions.arithmetic.Multiplication;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPNumber;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPValue;

public class CompleteMultiplicationTest {

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
		
		Multiplication multiplication1 = factory.createMultiplication();
		multiplication1.setExpressionA(a.getUniqueID());
		multiplication1.setExpressionB(b.getUniqueID());
		
		Multiplication multiplication2 = factory.createMultiplication();
		multiplication2.setExpressionA(c.getUniqueID());
		multiplication2.setExpressionB(multiplication1.getUniqueID());
		
		HashMap<String, DataObject> map = new HashMap<String, DataObject>();
		map.put(multiplication1.getUniqueID(), multiplication1);
		map.put(multiplication2.getUniqueID(), multiplication2);
		map.put(a.getUniqueID(), a);
		map.put(b.getUniqueID(), b);
		map.put(c.getUniqueID(), c);
		//multiplication2(c * multiplication1(a * b))
		//c * (a * b)
		BigDecimal result =  context.getBigDecimal(((DataObject) multiplication2.evaluate(context, map, factory)).getUniqueID());
		assertTrue(result.compareTo(new BigDecimal("68.626")) == 0);
	
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
		
		Multiplication multiplication1 = factory.createMultiplication();
		multiplication1.setExpressionA(a.getUniqueID());
		multiplication1.setExpressionB(b.getUniqueID());
		
		Multiplication multiplication2 = factory.createMultiplication();
		multiplication2.setExpressionA(c.getUniqueID());
		multiplication2.setExpressionB(multiplication1.getUniqueID());
		
		HashMap<String, DataObject> map = new HashMap<String, DataObject>();
		map.put(multiplication1.getUniqueID(), multiplication1);
		map.put(multiplication2.getUniqueID(), multiplication2);
		map.put(a.getUniqueID(), a);
		map.put(b.getUniqueID(), b);
		map.put(c.getUniqueID(), c);
		//multiplication2(c * multiplication1(a * b))
		//c * (a * b)
		BigDecimal result =  context.getBigDecimal(((DataObject) multiplication2.evaluate(context, map, factory)).getUniqueID());
		assertTrue(result.compareTo(new BigDecimal("140")) == 0);
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
		
		Multiplication multiplication1 = factory.createMultiplication();
		multiplication1.setExpressionA(a.getUniqueID());
		multiplication1.setExpressionB(b.getUniqueID());
		
		Multiplication multiplication2 = factory.createMultiplication();
		multiplication2.setExpressionA(c.getUniqueID());
		multiplication2.setExpressionB(d.getUniqueID());
		
		Multiplication multiplication3 = factory.createMultiplication();
		multiplication3.setExpressionA(multiplication1.getUniqueID());
		multiplication3.setExpressionB(multiplication2.getUniqueID());
		
		HashMap<String, DataObject> map = new HashMap<String, DataObject>();
		map.put(multiplication1.getUniqueID(), multiplication1);
		map.put(multiplication2.getUniqueID(), multiplication2);
		map.put(multiplication3.getUniqueID(), multiplication3);
		map.put(a.getUniqueID(), a);
		map.put(b.getUniqueID(), b);
		map.put(c.getUniqueID(), c);
		map.put(d.getUniqueID(), d);
		//multiplication3(multiplication1(a * b) * multiplication2(c * d))
		//((a * b) * (c * d)) 
		BigDecimal result =  context.getBigDecimal(((DataObject) multiplication3.evaluate(context, map, factory)).getUniqueID());
		assertTrue(result.compareTo(new BigDecimal("280")) == 0);
	}

}

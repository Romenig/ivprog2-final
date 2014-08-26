/** 
 * Instituto de Matem�tica e Estat�stica da Universidade de S�o Paulo (IME-USP)
 * iVProg is a open source and free software of Laborat�rio de Inform�tica na 
 * Educa��o (LInE) licensed under GNU GPL2.0 license.
 * Prof. Dr. Le�nidas de Oliveira Brand�o - leo@ime.usp.br
 * Romenig da Silva Ribeiro - romenig@ime.usp.br | romenig@gmail.com
 * @author Romenig
 */
package interpreter.expressions.arithmetic;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import usp.ime.line.ivprog.interpreter.DataFactory;
import usp.ime.line.ivprog.interpreter.DataObject;
import usp.ime.line.ivprog.interpreter.error.IVPError;
import usp.ime.line.ivprog.interpreter.execution.Context;
import usp.ime.line.ivprog.interpreter.execution.expressions.arithmetic.Addition;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPNumber;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPValue;

public class CompleteAdditionTest {

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
		
		Addition addition1 = factory.createAddition();
		addition1.setExpressionA(a.getUniqueID());
		addition1.setExpressionB(b.getUniqueID());
		
		Addition addition2 = factory.createAddition();
		addition2.setExpressionA(c.getUniqueID());
		addition2.setExpressionB(addition1.getUniqueID());
		
		HashMap<String, DataObject> map = new HashMap<String, DataObject>();
		map.put(addition1.getUniqueID(), addition1);
		map.put(addition2.getUniqueID(), addition2);
		map.put(a.getUniqueID(), a);
		map.put(b.getUniqueID(), b);
		map.put(c.getUniqueID(), c);
		//addition2(c + addition1(a + b))
		//c + (a + b)
		BigDecimal result =  context.getBigDecimal(((DataObject) addition2.evaluate(context, map, factory)).getUniqueID());
		assertTrue(result.compareTo(new BigDecimal("15.4313")) == 0);
	
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
		
		Addition addition1 = factory.createAddition();
		addition1.setExpressionA(a.getUniqueID());
		addition1.setExpressionB(b.getUniqueID());
		
		Addition addition2 = factory.createAddition();
		addition2.setExpressionA(c.getUniqueID());
		addition2.setExpressionB(addition1.getUniqueID());
		
		HashMap<String, DataObject> map = new HashMap<String, DataObject>();
		map.put(addition1.getUniqueID(), addition1);
		map.put(addition2.getUniqueID(), addition2);
		map.put(a.getUniqueID(), a);
		map.put(b.getUniqueID(), b);
		map.put(c.getUniqueID(), c);
		//addition2(c + addition1(a + b))
		//c + (a + b)
		BigDecimal result =  context.getBigDecimal(((DataObject) addition2.evaluate(context, map, factory)).getUniqueID());
		assertTrue(result.compareTo(new BigDecimal("19")) == 0);
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
		
		Addition addition1 = factory.createAddition();
		addition1.setExpressionA(a.getUniqueID());
		addition1.setExpressionB(b.getUniqueID());
		
		Addition addition2 = factory.createAddition();
		addition2.setExpressionA(c.getUniqueID());
		addition2.setExpressionB(d.getUniqueID());
		
		Addition addition3 = factory.createAddition();
		addition3.setExpressionA(addition1.getUniqueID());
		addition3.setExpressionB(addition2.getUniqueID());
		
		HashMap<String, DataObject> map = new HashMap<String, DataObject>();
		map.put(addition1.getUniqueID(), addition1);
		map.put(addition2.getUniqueID(), addition2);
		map.put(addition3.getUniqueID(), addition3);
		map.put(a.getUniqueID(), a);
		map.put(b.getUniqueID(), b);
		map.put(c.getUniqueID(), c);
		map.put(d.getUniqueID(), d);
		//addition3(addition1(a + b) + addition2(c + d))
		//((a + b) + (c + d)) 
		BigDecimal result =  context.getBigDecimal(((DataObject) addition3.evaluate(context, map, factory)).getUniqueID());
		assertTrue(result.compareTo(new BigDecimal("21")) == 0);
	}

}

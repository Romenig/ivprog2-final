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
import usp.ime.line.ivprog.interpreter.error.IVPError;
import usp.ime.line.ivprog.interpreter.execution.Context;
import usp.ime.line.ivprog.interpreter.execution.expressions.arithmetic.Division;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPNumber;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPValue;

public class SimpleDivisionTest {

	@Test
	public void divideIntToInt() {
		Context c = new Context();
		DataFactory factory = new DataFactory();
		IVPNumber a = factory.createIVPNumber();
		IVPNumber b = factory.createIVPNumber();
		
		a.setValueType(IVPValue.INTEGER_TYPE);
		b.setValueType(IVPValue.INTEGER_TYPE);
		
		c.addBigDecimal(a.getUniqueID(), new BigDecimal(10));
		c.addBigDecimal(b.getUniqueID(), new BigDecimal(2));
				
		Division division = factory.createDivision();
		division.setExpressionA(a.getUniqueID());
		division.setExpressionB(b.getUniqueID());
		
		HashMap<String, DataObject> map = new HashMap<String, DataObject>();
		map.put(division.getUniqueID(), division);
		map.put(a.getUniqueID(), a);
		map.put(b.getUniqueID(), b);
		
		IVPNumber result = (IVPNumber) division.evaluate(c,map,factory);
		
		assertTrue( c.getBigDecimal(result.getUniqueID()).compareTo(new BigDecimal("5")) == 0);
	}

	@Test
	public void divideIntToDouble() {
		Context c = new Context();
		DataFactory factory = new DataFactory();
		IVPNumber a = factory.createIVPNumber();
		IVPNumber b = factory.createIVPNumber();
		
		a.setValueType(IVPValue.INTEGER_TYPE);
		b.setValueType(IVPValue.DOUBLE_TYPE);
		
		c.addBigDecimal(a.getUniqueID(), new BigDecimal("6"));
		c.addBigDecimal(b.getUniqueID(), new BigDecimal("1.5"));
		
		Division division = factory.createDivision();
		division.setExpressionA(a.getUniqueID());
		division.setExpressionB(b.getUniqueID());
		
		HashMap<String, DataObject> map = new HashMap<String, DataObject>();
		map.put(division.getUniqueID(), division);
		map.put(a.getUniqueID(), a);
		map.put(b.getUniqueID(), b);
		
		
		IVPNumber result = (IVPNumber) division.evaluate(c,map,factory);
		assertTrue( c.getBigDecimal(result.getUniqueID()).compareTo(new BigDecimal("4")) == 0);

	}
	
	@Test
	public void divideDoubleToInt() {
		Context c = new Context();
		DataFactory factory = new DataFactory();
		IVPNumber a = factory.createIVPNumber();
		IVPNumber b = factory.createIVPNumber();
		
		b.setValueType(IVPValue.INTEGER_TYPE);
		a.setValueType(IVPValue.DOUBLE_TYPE);
		
		c.addBigDecimal(a.getUniqueID(), new BigDecimal("1.5"));
		c.addBigDecimal(b.getUniqueID(), new BigDecimal(2));
		

		Division division = factory.createDivision();
		division.setExpressionA(a.getUniqueID());
		division.setExpressionB(b.getUniqueID());
		
		HashMap<String, DataObject> map = new HashMap<String, DataObject>();
		map.put(division.getUniqueID(), division);
		map.put(a.getUniqueID(), a);
		map.put(b.getUniqueID(), b);
		
		IVPNumber result = (IVPNumber) division.evaluate(c,map,factory);
		assertTrue( c.getBigDecimal(result.getUniqueID()).compareTo(new BigDecimal("0.75")) == 0);
	}
	
	@Test
	public void divideDoubleToDouble() {
		Context c = new Context();
		DataFactory factory = new DataFactory();
		IVPNumber a = factory.createIVPNumber();
		IVPNumber b = factory.createIVPNumber();
		
		b.setValueType(IVPValue.DOUBLE_TYPE);
		a.setValueType(IVPValue.DOUBLE_TYPE);
		
		c.addBigDecimal(a.getUniqueID(), new BigDecimal("2.5"));
		c.addBigDecimal(b.getUniqueID(), new BigDecimal("0.25"));
		
		Division division = factory.createDivision();
		division.setExpressionA(a.getUniqueID());
		division.setExpressionB(b.getUniqueID());
		
		HashMap<String, DataObject> map = new HashMap<String, DataObject>();
		map.put(division.getUniqueID(), division);
		map.put(a.getUniqueID(), a);
		map.put(b.getUniqueID(), b);
		
		IVPNumber result = (IVPNumber) division.evaluate(c,map,factory);
		assertTrue( c.getBigDecimal(result.getUniqueID()).compareTo(new BigDecimal("10")) == 0);
		
	}
}

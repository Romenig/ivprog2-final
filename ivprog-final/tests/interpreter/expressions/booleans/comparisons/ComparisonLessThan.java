/** 
 * Instituto de Matem�tica e Estat�stica da Universidade de S�o Paulo (IME-USP)
 * iVProg is a open source and free software of Laborat�rio de Inform�tica na 
 * Educa��o (LInE) licensed under GNU GPL2.0 license.
 * Prof. Dr. Le�nidas de Oliveira Brand�o - leo@ime.usp.br
 * Romenig da Silva Ribeiro - romenig@ime.usp.br | romenig@gmail.com
 * @author Romenig
 */
package interpreter.expressions.booleans.comparisons;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.HashMap;

import org.junit.Test;

import usp.ime.line.ivprog.interpreter.DataFactory;
import usp.ime.line.ivprog.interpreter.DataObject;
import usp.ime.line.ivprog.interpreter.execution.Context;
import usp.ime.line.ivprog.interpreter.execution.expressions.booleans.comparisons.LessThan;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPBoolean;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPNumber;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPString;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPValue;

public class ComparisonLessThan {

	@Test
	public void testLessThanForInteger() {
		Context c = new Context();
		DataFactory factory = new DataFactory();
		IVPNumber a = factory.createIVPNumber();
		IVPNumber b = factory.createIVPNumber();
		LessThan lt = factory.createLessThan();
		lt.setExpressionA(a.getUniqueID());
		lt.setExpressionB(b.getUniqueID());

		a.setValueType(IVPValue.INTEGER_TYPE);
		b.setValueType(IVPValue.INTEGER_TYPE);

		c.addInt(a.getUniqueID(), 3);
		c.addInt(b.getUniqueID(), 3);

		HashMap map = new HashMap();
		map.put(a.getUniqueID(), a);
		map.put(b.getUniqueID(), b);
		map.put(lt.getUniqueID(), lt);

		IVPBoolean result = (IVPBoolean) lt.evaluate(c, map, factory);
		assertFalse(c.getBoolean(result.getUniqueID()));
	}

	@Test
	public void testLessThanForDoubleNumbers() {
		Context c = new Context();
		DataFactory factory = new DataFactory();
		IVPNumber a = factory.createIVPNumber();
		IVPNumber b = factory.createIVPNumber();
		LessThan lt = factory.createLessThan();
		lt.setExpressionA(a.getUniqueID());
		lt.setExpressionB(b.getUniqueID());

		a.setValueType(IVPValue.DOUBLE_TYPE);
		b.setValueType(IVPValue.DOUBLE_TYPE);

		c.addDouble(a.getUniqueID(), 3.0001);
		c.addDouble(b.getUniqueID(), 3.0002);

		HashMap map = new HashMap();
		map.put(a.getUniqueID(), a);
		map.put(b.getUniqueID(), b);
		map.put(lt.getUniqueID(), lt);

		IVPBoolean result = (IVPBoolean) lt.evaluate(c, map, factory);
		assertTrue(c.getBoolean(result.getUniqueID()));
	}

	@Test
	public void testLessThanForIntAndDouble() {
		Context c = new Context();
		DataFactory factory = new DataFactory();
		IVPNumber a = factory.createIVPNumber();
		IVPNumber b = factory.createIVPNumber();
		LessThan lt = factory.createLessThan();
		lt.setExpressionA(a.getUniqueID());
		lt.setExpressionB(b.getUniqueID());

		a.setValueType(IVPValue.DOUBLE_TYPE);
		b.setValueType(IVPValue.INTEGER_TYPE);

		c.addDouble(a.getUniqueID(), 3.0001);
		c.addInt(b.getUniqueID(), 3);

		HashMap map = new HashMap();
		map.put(a.getUniqueID(), a);
		map.put(b.getUniqueID(), b);
		map.put(lt.getUniqueID(), lt);

		IVPBoolean result = (IVPBoolean) lt.evaluate(c, map, factory);
		assertFalse(c.getBoolean(result.getUniqueID()));
	}

}

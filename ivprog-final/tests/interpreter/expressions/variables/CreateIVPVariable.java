/** 
 * Instituto de Matem�tica e Estat�stica da Universidade de S�o Paulo (IME-USP)
 * iVProg is a open source and free software of Laborat�rio de Inform�tica na 
 * Educa��o (LInE) licensed under GNU GPL2.0 license.
 * Prof. Dr. Le�nidas de Oliveira Brand�o - leo@ime.usp.br
 * Romenig da Silva Ribeiro - romenig@ime.usp.br | romenig@gmail.com
 * @author Romenig
 */
package interpreter.expressions.variables;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.HashMap;

import org.junit.Test;

import usp.ime.line.ivprog.interpreter.DataFactory;
import usp.ime.line.ivprog.interpreter.execution.Context;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPNumber;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPValue;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPVariable;

/**
 * @author Romenig
 * 
 */
public class CreateIVPVariable {

	@Test
	public void creatingIntVariable() {
		Context c = new Context();
		DataFactory factory = new DataFactory();

		IVPNumber n = factory.createIVPNumber();
		n.setValueType(IVPValue.INTEGER_TYPE);
		c.addBigDecimal(n.getUniqueID(), new BigDecimal("10"));

		IVPVariable v = factory.createIVPVariable();
		v.setVariableType(IVPValue.INTEGER_TYPE);
		v.setValueID(n.getUniqueID());

		HashMap map = new HashMap();
		map.put(v.getUniqueID(), v);
		map.put(n.getUniqueID(), n);

		IVPNumber result = (IVPNumber) v.evaluate(c, map, factory);
		assertTrue(c.getBigDecimal(result.getUniqueID()).compareTo(new BigDecimal("10")) == 0);
	}

	@Test
	public void creatingDoubleVariable() {
		Context c = new Context();
		DataFactory factory = new DataFactory();

		IVPNumber n = factory.createIVPNumber();
		n.setValueType(IVPValue.DOUBLE_TYPE);
		c.addBigDecimal(n.getUniqueID(), new BigDecimal("10.5"));

		IVPVariable v = factory.createIVPVariable();
		v.setVariableType(IVPValue.DOUBLE_TYPE);
		v.setValueID(n.getUniqueID());

		HashMap map = new HashMap();
		map.put(v.getUniqueID(), v);
		map.put(n.getUniqueID(), n);

		IVPNumber result = (IVPNumber) v.evaluate(c, map, factory);
		assertTrue(c.getBigDecimal(result.getUniqueID()).compareTo(new BigDecimal("10.5")) == 0);
	}

	@Test
	public void creatingStringVariable() {
		Context c = new Context();
		DataFactory factory = new DataFactory();

		IVPNumber n = factory.createIVPNumber();
		n.setValueType(IVPValue.STRING_TYPE);
		c.addString(n.getUniqueID(), "Hello, world");

		IVPVariable v = factory.createIVPVariable();
		v.setVariableType(IVPValue.STRING_TYPE);
		v.setValueID(n.getUniqueID());

		HashMap map = new HashMap();
		map.put(v.getUniqueID(), v);
		map.put(n.getUniqueID(), n);

		IVPNumber result = (IVPNumber) v.evaluate(c, map, factory);
		assertTrue(c.getString(result.getUniqueID()).equals("Hello, world"));
	}

	@Test
	public void creatingBooleanVariable() {
		Context c = new Context();
		DataFactory factory = new DataFactory();

		IVPNumber n = factory.createIVPNumber();
		n.setValueType(IVPValue.BOOLEAN_TYPE);
		c.addBoolean(n.getUniqueID(), new Boolean(true));

		IVPVariable v = factory.createIVPVariable();
		v.setVariableType(IVPValue.BOOLEAN_TYPE);
		v.setValueID(n.getUniqueID());

		HashMap map = new HashMap();
		map.put(v.getUniqueID(), v);
		map.put(n.getUniqueID(), n);

		IVPNumber result = (IVPNumber) v.evaluate(c, map, factory);
		assertTrue(c.getBoolean(result.getUniqueID()));
	}

}

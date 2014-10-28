/** 
 * Instituto de Matem�tica e Estat�stica da Universidade de S�o Paulo (IME-USP)
 * iVProg is a open source and free software of Laborat�rio de Inform�tica na 
 * Educa��o (LInE) licensed under GNU GPL2.0 license.
 * Prof. Dr. Le�nidas de Oliveira Brand�o - leo@ime.usp.br
 * Romenig da Silva Ribeiro - romenig@ime.usp.br | romenig@gmail.com
 * @author Romenig
 */
package interpreter.utils.vector;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.HashMap;

import org.junit.Test;

import usp.ime.line.ivprog.interpreter.DataFactory;
import usp.ime.line.ivprog.interpreter.DataObject;
import usp.ime.line.ivprog.interpreter.execution.Context;
import usp.ime.line.ivprog.interpreter.execution.code.AttributionLine;
import usp.ime.line.ivprog.interpreter.execution.expressions.arithmetic.Addition;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPNumber;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPValue;
import usp.ime.line.ivprog.interpreter.execution.utils.IVPVector;

public class IVPVectorTests {

	@Test
	public void createAVectorWithSizeX() {
		DataFactory factory = new DataFactory();
		Context context = new Context();

		IVPVector vect = factory.createIVPVector();
		IVPNumber size = factory.createIVPNumber();

		size.setValueType(IVPValue.INTEGER_TYPE);
		vect.setType(IVPValue.INTEGER_TYPE);

		context.addBigDecimal(size.getUniqueID(), new BigDecimal("3"));

		HashMap<String, DataObject> map = new HashMap<String, DataObject>();
		map.put(vect.getUniqueID(), vect);
		map.put(size.getUniqueID(), size);

		vect.setSize(size.getUniqueID(), context);

		assertTrue(vect.getType().equals(IVPValue.INTEGER_TYPE));
		assertTrue(context.getBigDecimal(vect.getSize()).intValue() == 3);
		assertTrue(context.getBoolean(vect.isEmpty(factory, context, map)));
	}

	@Test
	public void createAVectorAndPopulateWithInteger() {
		Context context = new Context();
		DataFactory factory = new DataFactory();
		IVPNumber a = factory.createIVPNumber();
		IVPNumber b = factory.createIVPNumber();
		IVPNumber c = factory.createIVPNumber();
		IVPVector vect = factory.createIVPVector();
		IVPNumber size = factory.createIVPNumber();

		size.setValueType(IVPValue.INTEGER_TYPE);
		a.setValueType(IVPValue.INTEGER_TYPE);
		b.setValueType(IVPValue.INTEGER_TYPE);
		c.setValueType(IVPValue.INTEGER_TYPE);
		context.addBigDecimal(a.getUniqueID(), new BigDecimal("3"));
		context.addBigDecimal(b.getUniqueID(), new BigDecimal("10"));
		context.addBigDecimal(c.getUniqueID(), new BigDecimal("2"));
		context.addBigDecimal(size.getUniqueID(), new BigDecimal("10"));

		vect.setSize(size.getUniqueID(), context);

		vect.setType(IVPValue.INTEGER_TYPE);

		vect.add(new BigDecimal(0), a.getUniqueID());
		vect.add(new BigDecimal(1), b.getUniqueID());
		vect.add(new BigDecimal(2), c.getUniqueID());

		HashMap<String, DataObject> map = new HashMap<String, DataObject>();
		map.put(a.getUniqueID(), a);
		map.put(b.getUniqueID(), b);
		map.put(c.getUniqueID(), c);
		map.put(vect.getUniqueID(), vect);

		assertTrue(vect.getType().equals(IVPValue.INTEGER_TYPE));
		assertTrue(context.getBigDecimal(vect.getSize()).intValue() == 10);
		assertFalse(context.getBoolean(vect.isEmpty(factory, context, map)));

		IVPNumber result1 = (IVPNumber) map.get(vect.get(new BigDecimal(0)));
		IVPNumber result2 = (IVPNumber) map.get(vect.get(new BigDecimal(1)));
		IVPNumber result3 = (IVPNumber) map.get(vect.get(new BigDecimal(2)));

		assertTrue(context.getBigDecimal(result1.getUniqueID()).compareTo(new BigDecimal("3")) == 0);
		assertTrue(context.getBigDecimal(result2.getUniqueID()).compareTo(new BigDecimal("10")) == 0);
		assertTrue(context.getBigDecimal(result3.getUniqueID()).compareTo(new BigDecimal("2")) == 0);

	}

	@Test
	public void removeFromAPopulatedVector() {
		Context context = new Context();
		DataFactory factory = new DataFactory();
		IVPNumber a = factory.createIVPNumber();
		IVPNumber b = factory.createIVPNumber();
		IVPNumber c = factory.createIVPNumber();
		IVPVector vect = factory.createIVPVector();
		IVPNumber size = factory.createIVPNumber();

		a.setValueType(IVPValue.INTEGER_TYPE);
		b.setValueType(IVPValue.INTEGER_TYPE);
		c.setValueType(IVPValue.INTEGER_TYPE);
		size.setValueType(IVPValue.INTEGER_TYPE);
		context.addBigDecimal(a.getUniqueID(), new BigDecimal("3"));
		context.addBigDecimal(b.getUniqueID(), new BigDecimal("10"));
		context.addBigDecimal(c.getUniqueID(), new BigDecimal("2"));
		context.addBigDecimal(size.getUniqueID(), new BigDecimal("10"));

		vect.setSize(size.getUniqueID(), context);
		vect.setType(IVPValue.INTEGER_TYPE);

		vect.add(new BigDecimal(0), a.getUniqueID());
		vect.add(new BigDecimal(1), b.getUniqueID());
		vect.add(new BigDecimal(2), c.getUniqueID());

		HashMap<String, DataObject> map = new HashMap<String, DataObject>();
		map.put(a.getUniqueID(), a);
		map.put(b.getUniqueID(), b);
		map.put(c.getUniqueID(), c);
		map.put(vect.getUniqueID(), vect);

		assertTrue(vect.getType().equals(IVPValue.INTEGER_TYPE));
		assertTrue(context.getBigDecimal(vect.getSize()).intValue() == 10);
		assertFalse(context.getBoolean(vect.isEmpty(factory, context, map)));

		IVPNumber result1 = (IVPNumber) map.get(vect.get(new BigDecimal(0)));
		IVPNumber result2 = (IVPNumber) map.get(vect.get(new BigDecimal(1)));
		IVPNumber result3 = (IVPNumber) map.get(vect.get(new BigDecimal(2)));

		assertTrue(context.getBigDecimal(result1.getUniqueID()).compareTo(new BigDecimal("3")) == 0);
		assertTrue(context.getBigDecimal(result2.getUniqueID()).compareTo(new BigDecimal("10")) == 0);
		assertTrue(context.getBigDecimal(result3.getUniqueID()).compareTo(new BigDecimal("2")) == 0);

		String removed = vect.remove(new BigDecimal(1));

		assertTrue(removed.equals(b.getUniqueID()));
		assertTrue(vect.get(new BigDecimal(1)).equals(IVPValue.NULL));
	}

}

/** 
 * Instituto de Matemática e Estatística da Universidade de São Paulo (IME-USP)
 * iVProg is a open source and free software of Laboratório de Informática na 
 * Educação (LInE) licensed under GNU GPL2.0 license.
 * Prof. Dr. Leônidas de Oliveira Brandão - leo@ime.usp.br
 * Romenig da Silva Ribeiro - romenig@ime.usp.br | romenig@gmail.com
 * @author Romenig
 */
package interpreter.utils.matrix;

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
import usp.ime.line.ivprog.interpreter.execution.utils.IVPMatrix;

public class IVPMatrixTests {

	@Test
	public void createAMatrixWithSizeX() {
		DataFactory factory = new DataFactory();
		Context context = new Context();

		IVPNumber size = factory.createIVPNumber();
		size.setValueType(IVPValue.INTEGER_TYPE);
		context.addBigDecimal(size.getUniqueID(), new BigDecimal("3"));

		IVPMatrix matrix = factory.createIVPMatrix();
		matrix.setType(IVPValue.INTEGER_TYPE);

		HashMap map = new HashMap();
		map.put(matrix.getUniqueID(), matrix);
		map.put(size.getUniqueID(), size);

		matrix.setSize(size.getUniqueID(), size.getUniqueID(), context);

		assertTrue(matrix.getType().equals(IVPValue.INTEGER_TYPE));
		assertTrue(context.getBigDecimal(matrix.getNColID()).intValue() == 3);
		assertTrue(context.getBigDecimal(matrix.getNLinID()).intValue() == 3);
		assertTrue(context.getBoolean(matrix.isEmpty(factory, context, map)));
	}

	@Test
	public void createAMatrixAndPopulateWithInteger() {
		Context context = new Context();
		DataFactory factory = new DataFactory();
		IVPNumber a = factory.createIVPNumber();
		IVPNumber b = factory.createIVPNumber();
		IVPNumber c = factory.createIVPNumber();
		IVPMatrix matrix = factory.createIVPMatrix();
		IVPNumber size = factory.createIVPNumber();
		IVPNumber line = factory.createIVPNumber();
		IVPNumber column = factory.createIVPNumber();

		size.setValueType(IVPValue.INTEGER_TYPE);
		a.setValueType(IVPValue.INTEGER_TYPE);
		b.setValueType(IVPValue.INTEGER_TYPE);
		c.setValueType(IVPValue.INTEGER_TYPE);
		line.setValueType(IVPValue.INTEGER_TYPE);
		column.setValueType(IVPValue.INTEGER_TYPE);
		context.addBigDecimal(line.getUniqueID(), new BigDecimal("0"));
		context.addBigDecimal(column.getUniqueID(), new BigDecimal("0"));
		context.addBigDecimal(a.getUniqueID(), new BigDecimal("3"));
		context.addBigDecimal(b.getUniqueID(), new BigDecimal("10"));
		context.addBigDecimal(c.getUniqueID(), new BigDecimal("2"));
		context.addBigDecimal(size.getUniqueID(), new BigDecimal("3"));

		matrix.setSize(size.getUniqueID(), size.getUniqueID(), context);

		matrix.setType(IVPValue.INTEGER_TYPE);

		matrix.addElement(line.getUniqueID(), column.getUniqueID(), context, a.getUniqueID());
		line.updateValue(context, new BigDecimal(1));
		column.updateValue(context, new BigDecimal(1));
		matrix.addElement(line.getUniqueID(), column.getUniqueID(), context, b.getUniqueID());
		line.updateValue(context, new BigDecimal(2));
		column.updateValue(context, new BigDecimal(2));
		matrix.addElement(line.getUniqueID(), column.getUniqueID(), context, c.getUniqueID());

		HashMap map = new HashMap();
		map.put(a.getUniqueID(), a);
		map.put(b.getUniqueID(), b);
		map.put(c.getUniqueID(), c);
		map.put(line.getUniqueID(), line);
		map.put(column.getUniqueID(), column);
		map.put(size.getUniqueID(), size);
		map.put(matrix.getUniqueID(), matrix);

		assertTrue(matrix.getType().equals(IVPValue.INTEGER_TYPE));
		assertTrue(context.getBigDecimal(matrix.getNColID()).intValue() == 3);
		assertTrue(context.getBigDecimal(matrix.getNLinID()).intValue() == 3);
		assertFalse(context.getBoolean(matrix.isEmpty(factory, context, map)));

		line.updateValue(context, new BigDecimal(0));
		column.updateValue(context, new BigDecimal(0));
		IVPNumber result1 = (IVPNumber) map.get(matrix.getElement(line.getUniqueID(), column.getUniqueID(), context));
		line.updateValue(context, new BigDecimal(1));
		column.updateValue(context, new BigDecimal(1));
		IVPNumber result2 = (IVPNumber) map.get(matrix.getElement(line.getUniqueID(), column.getUniqueID(), context));
		line.updateValue(context, new BigDecimal(2));
		column.updateValue(context, new BigDecimal(2));
		IVPNumber result3 = (IVPNumber) map.get(matrix.getElement(line.getUniqueID(), column.getUniqueID(), context));

		assertTrue(context.getBigDecimal(result1.getUniqueID()).compareTo(new BigDecimal("3")) == 0);
		assertTrue(context.getBigDecimal(result2.getUniqueID()).compareTo(new BigDecimal("10")) == 0);
		assertTrue(context.getBigDecimal(result3.getUniqueID()).compareTo(new BigDecimal("2")) == 0);

	}

	@Test
	public void removeFromAPopulatedMatrix() {
		Context context = new Context();
		DataFactory factory = new DataFactory();
		IVPNumber a = factory.createIVPNumber();
		IVPNumber b = factory.createIVPNumber();
		IVPNumber c = factory.createIVPNumber();
		IVPNumber line = factory.createIVPNumber();
		IVPNumber column = factory.createIVPNumber();
		IVPMatrix matrix = factory.createIVPMatrix();
		IVPNumber size = factory.createIVPNumber();

		line.setValueType(IVPValue.INTEGER_TYPE);
		column.setValueType(IVPValue.INTEGER_TYPE);

		a.setValueType(IVPValue.INTEGER_TYPE);
		b.setValueType(IVPValue.INTEGER_TYPE);
		c.setValueType(IVPValue.INTEGER_TYPE);
		size.setValueType(IVPValue.INTEGER_TYPE);
		context.addBigDecimal(a.getUniqueID(), new BigDecimal("3"));
		context.addBigDecimal(b.getUniqueID(), new BigDecimal("10"));
		context.addBigDecimal(c.getUniqueID(), new BigDecimal("2"));
		context.addBigDecimal(size.getUniqueID(), new BigDecimal("3"));
		context.addBigDecimal(line.getUniqueID(), new BigDecimal("0"));
		context.addBigDecimal(column.getUniqueID(), new BigDecimal("0"));

		matrix.setSize(size.getUniqueID(), size.getUniqueID(), context);
		matrix.setType(IVPValue.INTEGER_TYPE);

		matrix.addElement(line.getUniqueID(), column.getUniqueID(), context, a.getUniqueID());
		line.updateValue(context, new BigDecimal(1));
		column.updateValue(context, new BigDecimal(1));
		matrix.addElement(line.getUniqueID(), column.getUniqueID(), context, b.getUniqueID());
		line.updateValue(context, new BigDecimal(2));
		column.updateValue(context, new BigDecimal(2));
		matrix.addElement(line.getUniqueID(), column.getUniqueID(), context, c.getUniqueID());

		HashMap map = new HashMap();
		map.put(a.getUniqueID(), a);
		map.put(b.getUniqueID(), b);
		map.put(c.getUniqueID(), c);
		map.put(matrix.getUniqueID(), matrix);
		map.put(line.getUniqueID(), line);
		map.put(column.getUniqueID(), column);

		assertTrue(matrix.getType().equals(IVPValue.INTEGER_TYPE));
		assertTrue(context.getBigDecimal(matrix.getNColID()).intValue() == 3);
		assertTrue(context.getBigDecimal(matrix.getNLinID()).intValue() == 3);
		assertFalse(context.getBoolean(matrix.isEmpty(factory, context, map)));

		line.updateValue(context, new BigDecimal(0));
		column.updateValue(context, new BigDecimal(0));
		IVPNumber result1 = (IVPNumber) map.get(matrix.getElement(line.getUniqueID(), column.getUniqueID(), context));
		line.updateValue(context, new BigDecimal(1));
		column.updateValue(context, new BigDecimal(1));
		IVPNumber result2 = (IVPNumber) map.get(matrix.getElement(line.getUniqueID(), column.getUniqueID(), context));
		line.updateValue(context, new BigDecimal(2));
		column.updateValue(context, new BigDecimal(2));
		IVPNumber result3 = (IVPNumber) map.get(matrix.getElement(line.getUniqueID(), column.getUniqueID(), context));

		assertTrue(context.getBigDecimal(result1.getUniqueID()).compareTo(new BigDecimal("3")) == 0);
		assertTrue(context.getBigDecimal(result2.getUniqueID()).compareTo(new BigDecimal("10")) == 0);
		assertTrue(context.getBigDecimal(result3.getUniqueID()).compareTo(new BigDecimal("2")) == 0);

		line.updateValue(context, new BigDecimal(1));
		column.updateValue(context, new BigDecimal(1));
		String removed = matrix.removeElement(line.getUniqueID(), column.getUniqueID(), context);

		assertTrue(removed.equals(b.getUniqueID()));
		assertTrue(matrix.getElement(line.getUniqueID(), column.getUniqueID(), context).equals(IVPValue.NULL));
	}

}

/** 
 * Instituto de Matemática e Estatística da Universidade de São Paulo (IME-USP)
 * iVProg is a open source and free software of Laboratório de Informática na 
 * Educação (LInE) licensed under GNU GPL2.0 license.
 * Prof. Dr. Leônidas de Oliveira Brandão - leo@ime.usp.br
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
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPNumber;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPValue;
import usp.ime.line.ivprog.interpreter.utils.IVPVector;

public class IVPVectorTests {

	@Test
	public void createAVectorWithSizeX() {
		DataFactory factory = new DataFactory();
		
		IVPVector vect = factory.createIVPVector();
		
		vect.setSize("3");
		vect.setType(IVPValue.INTEGER_TYPE);
		
		assertTrue(vect.getType().equals(IVPValue.INTEGER_TYPE));
		assertTrue(vect.getSize().equals("3"));
		assertTrue(vect.isEmpty());
		
	}
	
	@Test
	public void createAVectorAndPopulateWithInteger() {
		Context context = new Context();
		DataFactory factory = new DataFactory();
		IVPNumber a = factory.createIVPNumber();
		IVPNumber b = factory.createIVPNumber();
		IVPNumber c = factory.createIVPNumber();
		IVPVector vect = factory.createIVPVector();
		
		a.setValueType(IVPValue.INTEGER_TYPE);
		b.setValueType(IVPValue.INTEGER_TYPE);
		c.setValueType(IVPValue.INTEGER_TYPE);
		context.addBigDecimal(a.getUniqueID(), new BigDecimal("3"));
		context.addBigDecimal(b.getUniqueID(), new BigDecimal("10"));
		context.addBigDecimal(c.getUniqueID(), new BigDecimal("2"));
		
		vect.setSize("10");
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
		assertTrue(vect.getSize().equals("10"));
		assertFalse(vect.isEmpty());
		
		IVPNumber result1 = (IVPNumber) map.get(vect.get(new BigDecimal(0)));
		IVPNumber result2 = (IVPNumber) map.get(vect.get(new BigDecimal(1)));
		IVPNumber result3 = (IVPNumber) map.get(vect.get(new BigDecimal(2)));
		
		assertTrue(context.getBigDecimal(result1.getUniqueID()).compareTo(new BigDecimal("3")) == 0);
		assertTrue(context.getBigDecimal(result2.getUniqueID()).compareTo(new BigDecimal("10")) == 0);
		assertTrue(context.getBigDecimal(result3.getUniqueID()).compareTo(new BigDecimal("2")) == 0);
		
	}

}

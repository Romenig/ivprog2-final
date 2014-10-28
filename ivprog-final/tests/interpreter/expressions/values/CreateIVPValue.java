/** 
 * Instituto de Matem�tica e Estat�stica da Universidade de S�o Paulo (IME-USP)
 * iVProg is a open source and free software of Laborat�rio de Inform�tica na 
 * Educa��o (LInE) licensed under GNU GPL2.0 license.
 * Prof. Dr. Le�nidas de Oliveira Brand�o - leo@ime.usp.br
 * Romenig da Silva Ribeiro - romenig@ime.usp.br | romenig@gmail.com
 * @author Romenig
 */
package interpreter.expressions.values;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import usp.ime.line.ivprog.interpreter.DataFactory;
import usp.ime.line.ivprog.interpreter.DataObject;
import usp.ime.line.ivprog.interpreter.execution.Context;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPBoolean;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPNumber;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPString;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPValue;

public class CreateIVPValue {

	@Test
	public void createIntBigDecimalValue() {
		Context context = new Context();
		DataFactory factory = new DataFactory();
		IVPNumber number = factory.createIVPNumber();
		context.addBigDecimal(number.getUniqueID(), new BigDecimal("1"));
		number.setValueType(IVPValue.INTEGER_TYPE);
		number.updateValue(context, new BigDecimal(5));

		assertTrue(number instanceof IVPValue && number instanceof IVPNumber);
		assertTrue(number.getValueType().equals(IVPValue.INTEGER_TYPE));
		assertTrue(context.getBigDecimal(number.getUniqueID()).compareTo(new BigDecimal(5)) == 0);
	}

	@Test
	public void createDoubleBigDecimalValue() {
		Context context = new Context();
		DataFactory factory = new DataFactory();
		IVPNumber number = factory.createIVPNumber();
		context.addBigDecimal(number.getUniqueID(), new BigDecimal("1"));
		number.setValueType(IVPValue.DOUBLE_TYPE);
		number.updateValue(context, new BigDecimal(5.0));

		assertTrue(number instanceof IVPValue && number instanceof IVPNumber);
		assertTrue(number.getValueType().equals(IVPValue.DOUBLE_TYPE));
		assertTrue(context.getBigDecimal(number.getUniqueID()).compareTo(new BigDecimal(5.0)) == 0);
	}

	@Test
	public void createBooleanValue() {
		Context context = new Context();
		DataFactory factory = new DataFactory();
		IVPBoolean bool = factory.createIVPBoolean();
		context.addBoolean(bool.getUniqueID(), new Boolean("false"));
		bool.setValueType(IVPValue.BOOLEAN_TYPE);
		context.addBoolean(bool.getUniqueID(), new Boolean("true"));
		bool.updateValue(context, new Boolean("false"));

		assertTrue(bool instanceof IVPValue && bool instanceof IVPBoolean);
		assertTrue(bool.getValueType().equals(IVPValue.BOOLEAN_TYPE));
		assertTrue(context.getBoolean(bool.getUniqueID()).equals(new Boolean("false")));
	}

	@Test
	public void createStringValue() {
		Context context = new Context();
		DataFactory factory = new DataFactory();
		IVPString string = factory.createIVPString();

		context.addString(string.getUniqueID(), "Init value");
		string.setValueType(IVPValue.STRING_TYPE);
		string.updateValue(context, "Alterando o valor da String aqui.");

		assertTrue(string instanceof IVPValue && string instanceof IVPString);
		assertTrue(string.getValueType().equals(IVPValue.STRING_TYPE));
		assertTrue(context.getString(string.getUniqueID()).equals("Alterando o valor da String aqui."));
	}

}
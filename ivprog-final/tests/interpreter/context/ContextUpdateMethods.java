/** 
 * Instituto de Matem�tica e Estat�stica da Universidade de S�o Paulo (IME-USP)
 * iVProg is a open source and free software of Laborat�rio de Inform�tica na 
 * Educa��o (LInE) licensed under GNU GPL2.0 license.
 * Prof. Dr. Le�nidas de Oliveira Brand�o - leo@ime.usp.br
 * Romenig da Silva Ribeiro - romenig@ime.usp.br | romenig@gmail.com
 * @author Romenig
 */
package interpreter.context;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import usp.ime.line.ivprog.interpreter.error.IVPError;
import usp.ime.line.ivprog.interpreter.execution.Context;

public class ContextUpdateMethods {

	@Test
	public void verifyUpdateNumber() {
		Context c = new Context();
		IVPError e1 = c.addInt("key1", 4);
		IVPError e2 = c.updateInt("key1", 5);
		assertTrue(c.getInt("key1") == 5);
	}

	@Test
	public void verifyUpdateString() {
		Context c = new Context();
		IVPError e1 = c.addString("key1", "Hello, world!");
		IVPError e2 = c.updateString("key1", "Update string value.");
		assertTrue(c.getString("key1").equals("Update string value."));
	}

	@Test
	public void verifyUpdateBoolean() {
		Context c = new Context();
		IVPError e1 = c.addBoolean("key1", new Boolean("true"));
		IVPError e2 = c.updateBoolean("key1", new Boolean("false"));
		assertTrue(c.getBoolean("key1") && false);
	}

}

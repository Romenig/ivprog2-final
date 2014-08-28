/** 
 * Instituto de Matemática e Estatística da Universidade de São Paulo (IME-USP)
 * iVProg is a open source and free software of Laboratório de Informática na 
 * Educação (LInE) licensed under GNU GPL2.0 license.
 * Prof. Dr. Leônidas de Oliveira Brandão - leo@ime.usp.br
 * Romenig da Silva Ribeiro - romenig@ime.usp.br | romenig@gmail.com
 * @author Romenig
 */
package interpreter.context;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import usp.ime.line.ivprog.interpreter.error.IVPError;
import usp.ime.line.ivprog.interpreter.execution.Context;
import usp.ime.line.ivprog.language.Messages;

public class ContextCreateAndCloneMethods {

	@Test
	public void verifyValues() {
		Context c = new Context();

		IVPError e1 = c.addBigDecimal("key1", new BigDecimal(10));
		IVPError e2 = c.addBigDecimal("key2", new BigDecimal(11));
		IVPError e3 = c.addString("key3", "Hello, world!");
		IVPError e4 = c.addBoolean("key4", new Boolean("true"));

		assertTrue((new BigDecimal(10)).equals(c.getBigDecimal("key1")) && (new BigDecimal(11)).equals(c.getBigDecimal("key2"))
		        && "Hello, world!".equals(c.getString("key3")) && c.getBoolean("key4"));

	}

	@Test
	public void verifyClonedContext() {
		Context c = new Context();
		IVPError e1 = c.addBoolean("key1", new Boolean("true"));
		IVPError e2 = c.addString("key2", "Hello, world 2!");
		IVPError e3 = c.addBigDecimal("key3", new BigDecimal("4"));
		Context c2 = (Context) c.clone();
		assertTrue(c.getBoolean("key1").equals(c2.getBoolean("key1")));
		assertTrue(c.getString("key2").equals(c2.getString("key2")));
		assertTrue(c.getBigDecimal("key3").equals(c2.getBigDecimal("key3")));
	}

}

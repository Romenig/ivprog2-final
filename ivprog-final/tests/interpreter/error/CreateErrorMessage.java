/** 
 * Instituto de Matem�tica e Estat�stica da Universidade de S�o Paulo (IME-USP)
 * iVProg is a open source and free software of Laborat�rio de Inform�tica na 
 * Educa��o (LInE) licensed under GNU GPL2.0 license.
 * Prof. Dr. Le�nidas de Oliveira Brand�o - leo@ime.usp.br
 * Romenig da Silva Ribeiro - romenig@ime.usp.br | romenig@gmail.com
 * @author Romenig
 */
package interpreter.error;

import static org.junit.Assert.*;

import org.junit.Test;

import usp.ime.line.ivprog.interpreter.error.IVPError;

public class CreateErrorMessage {

	@Test
	public void setAndGetErrorMessage() {
		IVPError e = new IVPError();
		e.setErrorMessage("An error message");
		assertTrue("An error message".equals(e.getErrorMessage()));
	}

}

/** 
 * Instituto de Matem�tica e Estat�stica da Universidade de S�o Paulo (IME-USP)
 * iVProg is a open source and free software of Laborat�rio de Inform�tica na 
 * Educa��o (LInE) licensed under GNU GPL2.0 license.
 * Prof. Dr. Le�nidas de Oliveira Brand�o - leo@ime.usp.br
 * Romenig da Silva Ribeiro - romenig@ime.usp.br | romenig@gmail.com
 * @author Romenig
 */
package usp.ime.line.ivprog.interpreter.error;

import java.util.HashMap;

import usp.ime.line.ivprog.interpreter.DataFactory;
import usp.ime.line.ivprog.interpreter.DataObject;
import usp.ime.line.ivprog.interpreter.execution.Context;

public class IVPError extends DataObject {

	private String message;

	public IVPError() {
	}

	public IVPError(String error) {
		message = error;
	}

	public String getErrorMessage() {
		return message;
	}

	public void setErrorMessage(String m) {
		message = m;
	}

	public Object evaluate(Context c, HashMap map, DataFactory factory) {
		return this;
	}

}

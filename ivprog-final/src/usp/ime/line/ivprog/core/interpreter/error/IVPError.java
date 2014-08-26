/** 
 * Instituto de Matemática e Estatística da Universidade de São Paulo (IME-USP)
 * iVProg is a open source and free software of Laboratório de Informática na 
 * Educação (LInE) licensed under GNU GPL2.0 license.
 * Prof. Dr. Leônidas de Oliveira Brandão - leo@ime.usp.br
 * Romenig da Silva Ribeiro - romenig@ime.usp.br | romenig@gmail.com
 * @author Romenig
 */
package usp.ime.line.ivprog.core.interpreter.error;

public class IVPError {

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

}

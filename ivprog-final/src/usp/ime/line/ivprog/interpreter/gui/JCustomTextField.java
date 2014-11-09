package usp.ime.line.ivprog.interpreter.gui;
/** 
 * Instituto de Matemática e Estatística da Universidade de São Paulo (IME-USP)
 * iVProg is a open source and free software of Laboratório de Informática na 
 * Educação (LInE) licensed under GNU GPL2.0 license.
 * Prof. Dr. Leônidas de Oliveira Brandão - leo@ime.usp.br
 * Romenig da Silva Ribeiro - romenig@ime.usp.br | romenig@gmail.com
 * @author Romenig
 */

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

public class JCustomTextField extends JTextField {

	private int maxLength = -1;
	private boolean isBlocked = false;

	private String currentRegex = "";

	public static String INTEGER = "^[-]?[0-9]*$";
	public static String DOUBLE = "^[-]?[0-9]*$";
	public static String VARIABLE_NAME = "^[a-zA-Z_][a-zA-Z0-9_]*$";

	public JCustomTextField() {
		super();
	}

	public JCustomTextField(int cols) {
		super(cols);
	}

	public JCustomTextField(int cols, int maxLength) {
		super(cols);
		setMaximumLength(maxLength);
	}

	@Override
	protected Document createDefaultModel() {
		return new RegexDocument(this);
	}

	public int getMaximumLength() {
		return maxLength;
	}

	public void setMaximumLength(int max) {
		maxLength = max;
	}

	public String getRegexFilter() {
		return String.valueOf(currentRegex);
	}

	public void setRegexFilter(String regex) {
		currentRegex = regex;
	}

	public boolean isBlocked() {
		return isBlocked;
	}

	public void setBlocked(boolean bool) {
		isBlocked = bool;
	}

	/**
	 * @return the currentRegex
	 */
	public String getCurrentRegex() {
		return currentRegex;
	}

	/**
	 * Set the regex that will validate de user input.
	 * Choose onde value from:
	 * JCustomTextField.INTEGER
	 * JCustomTextField.DOUBLE
	 * JCustomTextField.VARIABLE_NAME
	 * @param currentRegex
	 *            the currentRegex to set
	 */
	public void setCurrentRegex(String currentRegex) {
		this.currentRegex = currentRegex;
	}

	private final class RegexDocument extends PlainDocument {

		private JCustomTextField textField;

		public RegexDocument(JCustomTextField jCustomTextField) {
			textField = jCustomTextField;
		}

		@Override
		public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
			if (str == null) {
				return;
			}
			if (maxLength < 0) {
				if (!isBlocked) {
					super.insertString(offs, str, a);
				}
			} else {
				System.out.println("Atingiu o limite.");
			}

			String formedString = textField.getText();

			if (formedString.matches(currentRegex)) {
				return;
			} else {
				textField.setText(formedString.substring(0, formedString.length() - 1));
				System.out.println("Tentou inserir merda...");
				return;
			}
		}
	}
}

/** 
 * Instituto de Matem�tica e Estat�stica da Universidade de S�o Paulo (IME-USP)
 * iVProg is a open source and free software of Laborat�rio de Inform�tica na 
 * Educa��o (LInE) licensed under GNU GPL2.0 license.
 * Prof. Dr. Le�nidas de Oliveira Brand�o - leo@ime.usp.br
 * Romenig da Silva Ribeiro - romenig@ime.usp.br | romenig@gmail.com
 * @author Romenig
 */
package usp.ime.line.ivprog.language;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages {

	private static Messages instance; // Singleton instance
	private ResourceBundle RESOURCE_BUNDLE;

	private String BUNDLE_NAME = "usp.ime.line.ivprog.language.";
	private String currentLanguage = PORTUGUESE_BR;

	public static final String PORTUGUESE_BR = "pt_br"; // default
	public static final String ENGLISH = "eng";

	private Messages() {
		RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME + currentLanguage);
	}

	/**
	 * This method is used to get a string in the current iVProg language.
	 * 
	 * @param key
	 * @return a string for the given key
	 */
	public static String getString(String key) {
		if (instance == null) {
			instance = new Messages();
		}
		return instance.getMessage(key);
	}

	private String getMessage(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}

	/**
	 * Defines the iVProg current language. Currently available
	 * Messages.PORTUGUESE_BR or Messages.PORTUGUESE_ENG.
	 * 
	 * @param lang
	 */
	public void setLanguage(String lang) {
		currentLanguage = lang;
		RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME + currentLanguage);
	}

}

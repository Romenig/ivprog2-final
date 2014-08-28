/** 
 * Instituto de Matemática e Estatística da Universidade de São Paulo (IME-USP)
 * iVProg is a open source and free software of Laboratório de Informática na 
 * Educação (LInE) licensed under GNU GPL2.0 license.
 * Prof. Dr. Leônidas de Oliveira Brandão - leo@ime.usp.br
 * Romenig da Silva Ribeiro - romenig@ime.usp.br | romenig@gmail.com
 * @author Romenig
 */
package usp.ime.line.ivprog.interpreter.execution;

import java.math.BigDecimal;
import java.util.HashMap;

import usp.ime.line.ivprog.interpreter.error.IVPError;
import usp.ime.line.ivprog.language.Messages;

public class Context implements Cloneable {

	private HashMap<String, BigDecimal> bigDecimalMap;
	private HashMap<String, String> stringMap;
	private HashMap<String, Boolean> booleanMap;

	public Context() {
		bigDecimalMap = new HashMap<String, BigDecimal>();
		stringMap = new HashMap<String, String>();
		booleanMap = new HashMap<String, Boolean>();
	}

	private Context(HashMap<String, BigDecimal> nMap, HashMap<String, String> sMap, HashMap<String, Boolean> bMap) {
		bigDecimalMap = nMap;
		stringMap = sMap;
		booleanMap = bMap;
	}

	/**
	 * Add a BigDecimal to the hashmap of bigDecimals.
	 * 
	 * @param key
	 * @param bigDecimal
	 * @return IVPError
	 */
	public IVPError addBigDecimal(String key, BigDecimal bigDecimal) {
		IVPError e = null;
		if (!bigDecimalMap.containsKey(key)) {
			bigDecimalMap.put(key, bigDecimal);
		} else {
			e = new IVPError(Messages.getString("Context.keyExists"));
		}

		return e;
	}

	/**
	 * Get a bigDecimal object (integer or real) from the hashmap of
	 * bigDecimals.
	 * 
	 * @param key
	 * @return IVPError
	 */
	public BigDecimal getBigDecimal(String key) {
		return bigDecimalMap.get(key);
	}

	/**
	 * Update the bigDecimal (integer or real) with the specified key.
	 * 
	 * @param key
	 * @param bigDecimal
	 * @return IVPError
	 */
	public IVPError updateBigDecimal(String key, BigDecimal bigDecimal) {
		IVPError e = null;
		if (bigDecimalMap.containsKey(key)) {
			bigDecimalMap.put(key, bigDecimal);
		} else {
			e = new IVPError(Messages.getString("Context.keyDoesNotExists"));
		}
		return e;
	}

	/**
	 * Add a string object to the hashmap of strings.
	 * 
	 * @param key
	 * @param string
	 * @return IVPError
	 */
	public IVPError addString(String key, String string) {
		IVPError e = null;
		if (!stringMap.containsKey(key)) {
			stringMap.put(key, string);
		} else {
			e = new IVPError(Messages.getString("Context.keyExists"));
		}
		return e;
	}

	/**
	 * Get a String object from the hashmap of strings.
	 * 
	 * @param key
	 * @return IVPError
	 */
	public String getString(String key) {
		return stringMap.get(key);
	}

	/**
	 * Update the string with the specified key.
	 * 
	 * @param key
	 * @param string
	 * @return IVPError
	 */
	public IVPError updateString(String key, String string) {
		IVPError e = null;
		if (stringMap.containsKey(key)) {
			stringMap.put(key, string);
		} else {
			e = new IVPError(Messages.getString("Context.keyDoesNotExists"));
		}
		return e;
	}

	/**
	 * Add a Boolean object to the hashmap of booleans.
	 * 
	 * @param key
	 * @param b
	 * @return IVPError
	 */
	public IVPError addBoolean(String key, Boolean b) {
		IVPError e = null;
		if (!booleanMap.containsKey(key)) {
			booleanMap.put(key, b);
		} else {
			e = new IVPError(Messages.getString("Context.keyExists"));
		}
		return e;
	}

	/**
	 * Get a Boolean object from the hashmap of booleans.
	 * 
	 * @param key
	 * @return IVPError
	 */
	public Boolean getBoolean(String key) {
		return booleanMap.get(key);
	}

	/**
	 * Update the boolean with the specified key.
	 * 
	 * @param key
	 * @param b
	 * @return IVPError
	 */
	public IVPError updateBoolean(String key, Boolean b) {
		IVPError e = null;
		if (booleanMap.containsKey(key)) {
			booleanMap.put(key, b);
		} else {
			e = new IVPError(Messages.getString("Context.keyDoesNotExists"));
		}
		return e;
	}

	/**
	 * The clone method will be used only during a recursive call.
	 */
	public Object clone() {
		Context c = new Context((HashMap<String, BigDecimal>) bigDecimalMap.clone(), (HashMap<String, String>) stringMap.clone(),
		        (HashMap<String, Boolean>) booleanMap.clone());
		return c;
	}

}

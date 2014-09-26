/** 
 * Instituto de Matemática e Estatística da Universidade de São Paulo (IME-USP)
 * iVProg is a open source and free software of Laboratório de Informática na 
 * Educação (LInE) licensed under GNU GPL2.0 license.
 * Prof. Dr. Leônidas de Oliveira Brandão - leo@ime.usp.br
 * Romenig da Silva Ribeiro - romenig@ime.usp.br | romenig@gmail.com
 * @author Romenig
 */
package usp.ime.line.ivprog.interpreter.utils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Vector;

import usp.ime.line.ivprog.interpreter.DataFactory;
import usp.ime.line.ivprog.interpreter.DataObject;
import usp.ime.line.ivprog.interpreter.execution.Context;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPValue;

/**
 * @author Romenig
 *
 */
public class IVPVector extends DataObject {

	private String size;
	private String primitiveType;
	private Vector<String> vectorRepresentation;
	
	/* (non-Javadoc)
	 * @see usp.ime.line.ivprog.interpreter.DataObject#evaluate(usp.ime.line.ivprog.interpreter.execution.Context, java.util.HashMap, usp.ime.line.ivprog.interpreter.DataFactory)
	 */
	@Override
	public Object evaluate(Context c, HashMap<String, DataObject> map, DataFactory factory) {
		return this;
	}

	/**
	 * Set the IVPVector size.
	 * 
	 * @param s
	 */
    public void setSize(String s) {
	    size = s;
	    vectorRepresentation = new Vector <String>(new Integer(size).intValue()) ;
    }

	/**
	 * Set the primitive type.
	 * 
	 * @param integerType
	 */
    public void setType(String t) {
	    primitiveType = t;
    }

	/**
	 * Get the primitive type.
	 * 
	 * @return
	 */
    public Object getType() {
	    return primitiveType;
    }

	/**
	 * Get the IVPVector size.
	 * 
	 * @return
	 */
    public Object getSize() {
	    return size;
    }

	/**
	 * @return
	 */
    public boolean isEmpty() {
	    return vectorRepresentation.isEmpty();
    }

	/**
	 * Add element to the specified position.
	 * @param bigDecimal
	 * @param uniqueID
	 */
    public Object add(BigDecimal bigDecimal, String uniqueID) {
    	vectorRepresentation.add(bigDecimal.intValue(), uniqueID);
    	return null;
    }

	/**
	 * Get the element in the specified position.
	 * @param bigDecimal
	 * @return
	 */
    public Object get(BigDecimal bigDecimal) {
	    return vectorRepresentation.get(bigDecimal.intValue());
    }

}

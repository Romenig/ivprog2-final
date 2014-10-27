/** 
 * Instituto de Matemática e Estatística da Universidade de São Paulo (IME-USP)
 * iVProg is a open source and free software of Laboratório de Informática na 
 * Educação (LInE) licensed under GNU GPL2.0 license.
 * Prof. Dr. Leônidas de Oliveira Brandão - leo@ime.usp.br
 * Romenig da Silva Ribeiro - romenig@ime.usp.br | romenig@gmail.com
 * @author Romenig
 */
package usp.ime.line.ivprog.interpreter.execution.utils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Vector;

import usp.ime.line.ivprog.interpreter.DataFactory;
import usp.ime.line.ivprog.interpreter.DataObject;
import usp.ime.line.ivprog.interpreter.execution.Context;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPBoolean;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPValue;

public class IVPVector extends DataObject {

	private String sizeID;
	private String primitiveTypeID;
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
	 * @param sizeID
	 * @param c
	 */
    public void setSize(String sizeID, Context c) {
    	this.sizeID = sizeID;
	    vectorRepresentation = new Vector <String>() ;
	    for(int i = 0; i < c.getBigDecimal(sizeID).intValue(); i++){
	    	vectorRepresentation.add(i, null);
	    }
    }

	/**
	 * Set the primitive type.
	 * @param integerType
	 */
    public void setType(String t) {
    	primitiveTypeID = t;
    }

	/**
	 * Get the primitive type.
	 * @return
	 */
    public Object getType() {
	    return primitiveTypeID;
    }
    

	/**
	 * Get the IVPVector sizeID.
	 * @return
	 */
    public String getSize() {
	    return sizeID;
    }

	/**
	 * If there is no element in the vector, it returns IVPBoolean false. 
	 * Returns IVPBoolean true otherwise.
	 * @return
	 */
    public String isEmpty(DataFactory factory, Context c, HashMap<String, DataObject> map) {
    	IVPBoolean isEmpty = factory.createIVPBoolean();
    	boolean test = true;
    	for(int i = 0; i < vectorRepresentation.size(); i += 1){
    		if(vectorRepresentation.get(i) != null){ 
    			test = false;
    		}
    		break;
    	}
    	c.addBoolean(isEmpty.getUniqueID(), new Boolean(test));
	    return isEmpty.getUniqueID();
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
    public Object get(BigDecimal bigDecimal){
	    return vectorRepresentation.get(bigDecimal.intValue());
    }

	/**
	 * 
	 * @param bigDecimal
	 * @return
	 */
    public String remove(BigDecimal bigDecimal) {
    	String removed = vectorRepresentation.get(bigDecimal.intValue());
    	vectorRepresentation.add(bigDecimal.intValue(), IVPValue.NULL);
	    return removed;
    }

	/**
	 * @param bigDecimal
	 * @param copyOfValue
	 */
    public void addToIndex(BigDecimal bigDecimal, IVPValue copyOfValue) {
	    
    }

}

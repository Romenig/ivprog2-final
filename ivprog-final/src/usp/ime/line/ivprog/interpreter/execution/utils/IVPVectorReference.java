/** 
 * Instituto de Matem�tica e Estat�stica da Universidade de S�o Paulo (IME-USP)
 * iVProg is a open source and free software of Laborat�rio de Inform�tica na 
 * Educa��o (LInE) licensed under GNU GPL2.0 license.
 * Prof. Dr. Le�nidas de Oliveira Brand�o - leo@ime.usp.br
 * Romenig da Silva Ribeiro - romenig@ime.usp.br | romenig@gmail.com
 * @author Romenig
 */
package usp.ime.line.ivprog.interpreter.execution.utils;

import java.util.HashMap;

import usp.ime.line.ivprog.interpreter.DataFactory;
import usp.ime.line.ivprog.interpreter.DataObject;
import usp.ime.line.ivprog.interpreter.execution.Context;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPValue;

public class IVPVectorReference extends DataObject{

	private String vectorID;
	private String positionID;
	
	/* (non-Javadoc)
	 * @see usp.ime.line.ivprog.interpreter.DataObject#evaluate(usp.ime.line.ivprog.interpreter.execution.Context, java.util.HashMap, usp.ime.line.ivprog.interpreter.DataFactory)
	 */
    @Override
    public Object evaluate(Context c, HashMap<String, DataObject> map, DataFactory factory) {
    	IVPValue value = (IVPValue) map.get(((IVPVector)map.get(vectorID)).get(c.getBigDecimal(positionID)));
	    return value;
    }

	/**
	 * @return the vectorID
	 */
    public String getVectorID() {
	    return vectorID;
    }

	/**
	 * @param vectorID the vectorID to set
	 */
    public void setVectorID(String vectorID) {
	    this.vectorID = vectorID;
    }
	
    public IVPValue getElementFromVector(Context c, HashMap<String, DataObject> map, DataFactory factory){
    	IVPValue value = (IVPValue) map.get(((IVPVector)map.get(vectorID)).get(c.getBigDecimal(positionID)));
	    return value;
    }

    public Object setElementIntoVector(String valueID, Context c, HashMap<String,DataObject> map, DataFactory factory){
    	IVPVector v = (IVPVector) map.get(vectorID);
    	v.add(c.getBigDecimal(positionID), valueID);
    	return null;
    }

	/**
	 * @return the positionID
	 */
    public String getPositionID() {
	    return positionID;
    }

	/**
	 * @param positionID the positionID to set
	 */
    public void setPositionID(String positionID) {
	    this.positionID = positionID;
    }
}

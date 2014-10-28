/** 
 * Instituto de Matemática e Estatística da Universidade de São Paulo (IME-USP)
 * iVProg is a open source and free software of Laboratório de Informática na 
 * Educação (LInE) licensed under GNU GPL2.0 license.
 * Prof. Dr. Leônidas de Oliveira Brandão - leo@ime.usp.br
 * Romenig da Silva Ribeiro - romenig@ime.usp.br | romenig@gmail.com
 * @author Romenig
 */
package usp.ime.line.ivprog.interpreter.execution.code;

import java.util.HashMap;

import usp.ime.line.ivprog.interpreter.DataFactory;
import usp.ime.line.ivprog.interpreter.DataObject;
import usp.ime.line.ivprog.interpreter.execution.Context;
import usp.ime.line.ivprog.interpreter.execution.expressions.value.IVPBoolean;

public class While extends CodeComposite {

	private String loopConditionID;

	/**
	 * @param uniqueID
	 */
	public void addChild(String uniqueID) {
		children.add(uniqueID);
	}

	/**
	 * @param uniqueID
	 */
	public void setLoopCondition(String uniqueID) {
		loopConditionID = uniqueID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * usp.ime.line.ivprog.interpreter.DataObject#evaluate(usp.ime.line.ivprog
	 * .interpreter.execution.Context, java.util.HashMap,
	 * usp.ime.line.ivprog.interpreter.DataFactory)
	 */
	@Override
	public Object evaluate(Context c, HashMap<String, DataObject> map, DataFactory factory) {
		IVPBoolean b = (IVPBoolean) map.get(loopConditionID).evaluate(c, map, factory);
		while (c.getBoolean(b.getUniqueID())) {
			for (int i = 0; i < children.size(); i += 1) {
				DataObject component = (DataObject) map.get(children.get(i));
				component.evaluate(c, map, factory);
			}
			b = (IVPBoolean) map.get(loopConditionID).evaluate(c, map, factory);
		}
		return null;
	}

}

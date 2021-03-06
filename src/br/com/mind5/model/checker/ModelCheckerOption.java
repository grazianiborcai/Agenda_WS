package br.com.mind5.model.checker;

import java.sql.Connection;

public final class ModelCheckerOption implements Cloneable {
	public final static boolean EXIST_ON_DB = true;
	public final static boolean NOT_FOUND = false;
	public final static boolean SUCCESS = true;
	public final static boolean FAILED = false;
	
	public Connection conn;
	public boolean expectedResult;
	public String schemaName;
	
	
	public ModelCheckerOption() {
		clear();
	}
	
	
	
	public void clear() {
		conn = null;
		expectedResult = true;
		schemaName = null;
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		ModelCheckerOption deepCopy = new ModelCheckerOption();
		
		deepCopy.conn = conn;
		deepCopy.expectedResult = expectedResult;
		deepCopy.schemaName = schemaName;
		
		return deepCopy;
	}
}

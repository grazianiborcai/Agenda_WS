package br.com.gda.model.checker;

import java.sql.Connection;

public final class ModelCheckerOption {
	public final static boolean EXIST_ON_DB = true;
	public final static boolean RETURN_TRUE = true;
	
	public Connection conn;
	public boolean expectedResult;
	public String schemaName;
	
	
	public ModelCheckerOption() {
		conn = null;
		expectedResult = true;
		schemaName = null;
	}
}

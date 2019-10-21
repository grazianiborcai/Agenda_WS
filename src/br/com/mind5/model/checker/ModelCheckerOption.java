package br.com.mind5.model.checker;

import java.sql.Connection;

public final class ModelCheckerOption {
	public final static boolean EXIST_ON_DB = true;
	public final static boolean NOT_FOUND = false;
	public final static boolean SUCCESS = true;
	public final static boolean FAILED = false;
	
	public Connection conn;
	public boolean expectedResult;
	public String schemaName;
	
	
	public ModelCheckerOption() {
		conn = null;
		expectedResult = true;
		schemaName = null;
	}
}

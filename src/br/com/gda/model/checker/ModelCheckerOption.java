package br.com.gda.model.checker;

import java.sql.Connection;

public final class ModelCheckerOption {
	public Connection conn;
	public boolean expectedResult;
	public String schemaName;
	
	
	public ModelCheckerOption() {
		conn = null;
		expectedResult = true;
		schemaName = null;
	}
}

package br.com.gda.model.checker;

import java.sql.Connection;

public final class ModelCheckerOption {
	public Connection conn;
	public boolean expectedResult;
	public String schemaName;
	
	
	public ModelCheckerOption() {
		this.conn = null;
		this.expectedResult = true;
		this.schemaName = null;
	}
}

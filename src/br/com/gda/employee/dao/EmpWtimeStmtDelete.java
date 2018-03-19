package br.com.gda.employee.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

final class EmpWtimeStmtDelete extends EmpWtimeStmtAbstract {

	public EmpWtimeStmtDelete(EmpStmtOption option) {
		super(option);
	}
	
	
	
	@Override protected String buildStmtSkeletonHook() {
		EmpWtimeBuilderDelete builder = new EmpWtimeBuilderDelete(option.schemaName, option.workingTime);
		return builder.generateStatement();
	}
	
	
	
	@Override protected ResultSet executeStmtHook() throws SQLException {
		this.statement.executeUpdate();
		return null;
	}
}

package br.com.gda.employee.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

final class EmpWtimeStmtSelect extends EmpWtimeStmtAbstract {
	
	public EmpWtimeStmtSelect(EmpStmtOption option) {
		super(option);
	}
	
	
	
	@Override protected String buildStmtSkeletonHook() {
		EmpWtimeBuilderSelect builder = new EmpWtimeBuilderSelect(option.schemaName, option.workingTime);
		return builder.generateStatement();
	}
	
	
	
	@Override protected ResultSet executeStmtHook() throws SQLException {
		return this.statement.executeQuery();
	}
}
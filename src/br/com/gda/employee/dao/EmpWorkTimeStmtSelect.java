package br.com.gda.employee.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

final class EmpWorkTimeStmtSelect extends EmpWorkTimeStmtAbstract {
	
	public EmpWorkTimeStmtSelect(EmpStmtOption option) {
		super(option);
	}
	
	
	
	@Override protected String buildStmtSkeletonHook() {
		EmpWorkTimeBuilderSelect builder = new EmpWorkTimeBuilderSelect(option.schemaName, option.workingTime);
		return builder.generateStatement();
	}
	
	
	
	@Override protected ResultSet executeStmtHook() throws SQLException {
		return this.statement.executeQuery();
	}
}
package br.com.gda.employee.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

final class EmpWorkTimeStmtDelete extends EmpWorkTimeStmtAbstract {

	public EmpWorkTimeStmtDelete(EmpStmtOption option) {
		super(option);
	}
	
	
	
	@Override protected String buildStmtSkeletonHook() {
		EmpWorkTimeBuilderDelete builder = new EmpWorkTimeBuilderDelete(option.schemaName, option.workingTime);
		return builder.generateStatement();
	}
	
	
	
	@Override protected ResultSet executeStmtHook() throws SQLException {
		this.statement.executeUpdate();
		return null;
	}
}

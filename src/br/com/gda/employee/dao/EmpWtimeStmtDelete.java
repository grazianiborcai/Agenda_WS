package br.com.gda.employee.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.gda.employee.info.EmpWTimeInfo;

final class EmpWtimeStmtDelete extends EmpWtimeStmtAbstract {

	public EmpWtimeStmtDelete(EmpStmtOption<EmpWTimeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected String buildStmtSkeletonHook() {
		EmpWtimeBuilderDelete builder = new EmpWtimeBuilderDelete(option.schemaName, option.recordInfo);
		return builder.generateStatement();
	}
	
	
	
	@Override protected ResultSet executeStmtHook() throws SQLException {
		this.statement.executeUpdate();
		return null;
	}
}

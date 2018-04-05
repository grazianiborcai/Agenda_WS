package br.com.gda.employee.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.gda.employee.info.EmpWTimeInfo;
import br.com.gda.sql.SqlStmtOption;

final class EmpWtimeStmtDelete extends EmpWtimeStmtAbstract {

	public EmpWtimeStmtDelete(SqlStmtOption<EmpWTimeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected String buildStmtSkeletonHook() {
		EmpWtimeBuilderDelete builder = new EmpWtimeBuilderDelete(option.schemaName, option.recordInfo);
		return builder.generateStatement();
	}
	
	
	
	@Override protected ResultSet executeStmtHook() throws SQLException {
		this.stmt.executeUpdate();
		return null;
	}
}

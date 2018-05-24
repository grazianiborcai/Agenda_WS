package br.com.gda.business.employee.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employee.info.EmpWTimeInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.sql.SqlStmt;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecHelper;
import br.com.gda.sql.SqlStmtExecOption;

public final class EmpWtimeDeleteExec implements SqlStmtExec<EmpWTimeInfo> {
	private List<SqlStmt<EmpWTimeInfo>> sqlStatements;
	private SqlStmtExec<EmpWTimeInfo> helper;
	
	public EmpWtimeDeleteExec(List<SqlStmtExecOption<EmpWTimeInfo>> options) {
		if (options == null) 
			throw new NullPointerException("options" + SystemMessage.NULL_ARGUMENT);
		
		if (options.isEmpty())
			throw new IllegalArgumentException("options" + SystemMessage.EMPTY_ARGUMENT);
		
		prepareStatement(options);
		buildHelper();
	}
	
	
	
	private void prepareStatement(List<SqlStmtExecOption<EmpWTimeInfo>> options) {
		sqlStatements = new ArrayList<>();
		
		for (SqlStmtExecOption<EmpWTimeInfo> eachOption : options) {
			SqlStmt<EmpWTimeInfo> sqlStatement = new EmpWtimeDelete(eachOption.conn, eachOption.recordInfo, eachOption.schemaName);
			sqlStatements.add(sqlStatement);
		}
	}
	
	
	
	private void buildHelper() {
		helper = new SqlStmtExecHelper<>(sqlStatements);
	}
	

	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<EmpWTimeInfo> getResultset() {
		return helper.getResultset();
	}
}

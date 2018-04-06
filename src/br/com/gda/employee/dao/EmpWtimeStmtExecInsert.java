package br.com.gda.employee.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.common.SystemMessage;
import br.com.gda.employee.info.EmpWTimeInfo;
import br.com.gda.sql.SqlStmt;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecHelper;
import br.com.gda.sql.SqlStmtExecOption;

public final class EmpWtimeStmtExecInsert implements SqlStmtExec<EmpWTimeInfo> {	
	private List<SqlStmt<EmpWTimeInfo>> sqlStatements;
	private SqlStmtExec<EmpWTimeInfo> helper;
	
	public EmpWtimeStmtExecInsert(List<SqlStmtExecOption<EmpWTimeInfo>> options) {
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
			SqlStmt<EmpWTimeInfo> sqlStatement = new EmpWtimeStmtInsert(eachOption.conn, eachOption.recordInfo, eachOption.schemaName);
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
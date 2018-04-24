package br.com.gda.employee.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.common.SystemMessage;
import br.com.gda.employee.info.EmpInfo;
import br.com.gda.sql.SqlStmt;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecHelper;
import br.com.gda.sql.SqlStmtExecOption;

public final class EmpStmtExecUpdate implements SqlStmtExec<EmpInfo> {
	private List<SqlStmt<EmpInfo>> sqlStatements;
	private SqlStmtExec<EmpInfo> helper;
	
	public EmpStmtExecUpdate(List<SqlStmtExecOption<EmpInfo>> options) {
		if (options == null) 
			throw new NullPointerException("options" + SystemMessage.NULL_ARGUMENT);
		
		if (options.isEmpty())
			throw new IllegalArgumentException("options" + SystemMessage.EMPTY_ARGUMENT);
		
		prepareStatement(options);
		buildHelper();
	}
	
	
	
	private void prepareStatement(List<SqlStmtExecOption<EmpInfo>> options) {
		sqlStatements = new ArrayList<>();
		
		for (SqlStmtExecOption<EmpInfo> eachOption : options) {
			SqlStmt<EmpInfo> sqlStatement = new EmpStmtUpdate(eachOption.conn, eachOption.recordInfo, eachOption.schemaName);
			sqlStatements.add(sqlStatement);
		}
	}
	
	
	
	private void buildHelper() {
		helper = new SqlStmtExecHelper<>(sqlStatements);
	}
	

	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<EmpInfo> getResultset() {
		return helper.getResultset();
	}
}

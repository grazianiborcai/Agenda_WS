package br.com.gda.business.masterData.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.EmpPositionInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.sql.SqlStmt;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecHelper;
import br.com.gda.sql.SqlStmtExecOption;

public final class EmpPositionStmtExecSelect implements SqlStmtExec<EmpPositionInfo> {
	private List<SqlStmt<EmpPositionInfo>> sqlStatements;
	private SqlStmtExec<EmpPositionInfo> helper;
	
	public EmpPositionStmtExecSelect(List<SqlStmtExecOption<EmpPositionInfo>> options) {
		if (options == null) 
			throw new NullPointerException("options" + SystemMessage.NULL_ARGUMENT);
		
		if (options.isEmpty())
			throw new IllegalArgumentException("options" + SystemMessage.EMPTY_ARGUMENT);
		
		prepareStatement(options);
		buildHelper();
	}
	
	
	
	private void prepareStatement(List<SqlStmtExecOption<EmpPositionInfo>> options) {
		sqlStatements = new ArrayList<>();
		
		for (SqlStmtExecOption<EmpPositionInfo> eachOption : options) {
			SqlStmt<EmpPositionInfo> sqlStatement = new EmpPositionStmtSelect(eachOption.conn, eachOption.recordInfo, eachOption.schemaName);
			sqlStatements.add(sqlStatement);
		}
	}
	
	
	
	private void buildHelper() {
		helper = new SqlStmtExecHelper<>(sqlStatements);
	}
	

	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmpPositionInfo> getResultset() {
		return helper.getResultset();
	}
}

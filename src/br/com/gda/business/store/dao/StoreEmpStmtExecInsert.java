package br.com.gda.business.store.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.store.info.StoreEmpInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.sql.SqlStmt;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecHelper;
import br.com.gda.sql.SqlStmtExecOption;

public final class StoreEmpStmtExecInsert implements SqlStmtExec<StoreEmpInfo> {
	private List<SqlStmt<StoreEmpInfo>> sqlStatements;
	private SqlStmtExec<StoreEmpInfo> helper;
	
	public StoreEmpStmtExecInsert(List<SqlStmtExecOption<StoreEmpInfo>> options) {
		if (options == null) 
			throw new NullPointerException("options" + SystemMessage.NULL_ARGUMENT);
		
		if (options.isEmpty())
			throw new IllegalArgumentException("options" + SystemMessage.EMPTY_ARGUMENT);
		
		prepareStatement(options);
		buildHelper();
	}
	
	
	
	private void prepareStatement(List<SqlStmtExecOption<StoreEmpInfo>> options) {
		sqlStatements = new ArrayList<>();
		
		for (SqlStmtExecOption<StoreEmpInfo> eachOption : options) {
			SqlStmt<StoreEmpInfo> sqlStatement = new StoreEmpStmtInsert(eachOption.conn, eachOption.recordInfo, eachOption.schemaName);
			sqlStatements.add(sqlStatement);
		}
	}
	
	
	
	private void buildHelper() {
		helper = new SqlStmtExecHelper<>(sqlStatements);
	}
	

	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StoreEmpInfo> getResultset() {
		return helper.getResultset();
	}
}

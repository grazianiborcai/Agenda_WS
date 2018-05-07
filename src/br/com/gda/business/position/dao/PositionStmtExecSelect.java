package br.com.gda.business.position.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.position.info.PositionInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.sql.SqlStmt;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecHelper;
import br.com.gda.sql.SqlStmtExecOption;

public final class PositionStmtExecSelect implements SqlStmtExec<PositionInfo> {
	private List<SqlStmt<PositionInfo>> sqlStatements;
	private SqlStmtExec<PositionInfo> helper;
	
	public PositionStmtExecSelect(List<SqlStmtExecOption<PositionInfo>> options) {
		if (options == null) 
			throw new NullPointerException("options" + SystemMessage.NULL_ARGUMENT);
		
		if (options.isEmpty())
			throw new IllegalArgumentException("options" + SystemMessage.EMPTY_ARGUMENT);
		
		prepareStatement(options);
		buildHelper();
	}
	
	
	
	private void prepareStatement(List<SqlStmtExecOption<PositionInfo>> options) {
		sqlStatements = new ArrayList<>();
		
		for (SqlStmtExecOption<PositionInfo> eachOption : options) {
			SqlStmt<PositionInfo> sqlStatement = new PositionStmtSelect(eachOption.conn, eachOption.recordInfo, eachOption.schemaName);
			sqlStatements.add(sqlStatement);
		}
	}
	
	
	
	private void buildHelper() {
		helper = new SqlStmtExecHelper<>(sqlStatements);
	}
	

	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<PositionInfo> getResultset() {
		return helper.getResultset();
	}
}

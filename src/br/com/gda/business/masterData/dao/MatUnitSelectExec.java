package br.com.gda.business.masterData.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.MatUnitInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.sql.SqlStmt;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecHelper;
import br.com.gda.sql.SqlStmtExecOption;

public final class MatUnitSelectExec implements SqlStmtExec<MatUnitInfo> {
	private List<SqlStmt<MatUnitInfo>> sqlStatements;
	private SqlStmtExec<MatUnitInfo> helper;
	
	public MatUnitSelectExec(List<SqlStmtExecOption<MatUnitInfo>> options) {
		if (options == null) 
			throw new NullPointerException("options" + SystemMessage.NULL_ARGUMENT);
		
		if (options.isEmpty())
			throw new IllegalArgumentException("options" + SystemMessage.EMPTY_ARGUMENT);
		
		prepareStatement(options);
		buildHelper();
	}
	
	
	
	private void prepareStatement(List<SqlStmtExecOption<MatUnitInfo>> options) {
		sqlStatements = new ArrayList<>();
		
		for (SqlStmtExecOption<MatUnitInfo> eachOption : options) {
			SqlStmt<MatUnitInfo> sqlStatement = new MatUnitSelect(eachOption.conn, eachOption.recordInfo, eachOption.schemaName);
			sqlStatements.add(sqlStatement);
		}
	}
	
	
	
	private void buildHelper() {
		helper = new SqlStmtExecHelper<>(sqlStatements);
	}
	

	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatUnitInfo> getResultset() {
		return helper.getResultset();
	}
}

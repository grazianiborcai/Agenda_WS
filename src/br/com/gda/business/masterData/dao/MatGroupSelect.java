package br.com.gda.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.masterData.info.MatGroupInfo;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecHelper;
import br.com.gda.sql.SqlStmtExecOption;

public final class MatGroupSelect implements SqlStmtExec<MatGroupInfo> {
	private SqlStmtExec<MatGroupInfo> helper;
	
	
	public MatGroupSelect(List<SqlStmtExecOption<MatGroupInfo>> options) {
		helper = new SqlStmtExecHelper<>(options, MatGroupSelectSingle.class, MatGroupInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<MatGroupInfo> getResultset() {
		return helper.getResultset();
	}
}

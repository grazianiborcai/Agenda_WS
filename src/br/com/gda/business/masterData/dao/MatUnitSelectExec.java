package br.com.gda.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.masterData.info.MatUnitInfo;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecHelper;
import br.com.gda.sql.SqlStmtExecOption;

public final class MatUnitSelectExec implements SqlStmtExec<MatUnitInfo> {
	private SqlStmtExec<MatUnitInfo> helper;
	
	
	public MatUnitSelectExec(List<SqlStmtExecOption<MatUnitInfo>> options) {
		helper = new SqlStmtExecHelper<>(options, MatUnitSelect.class, MatUnitInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<MatUnitInfo> getResultset() {
		return helper.getResultset();
	}
}

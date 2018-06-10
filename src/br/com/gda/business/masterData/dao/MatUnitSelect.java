package br.com.gda.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.masterData.info.MatUnitInfo;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecHelper;
import br.com.gda.sql.SqlStmtExecOption;

public final class MatUnitSelect implements SqlStmtExec<MatUnitInfo> {
	private SqlStmtExec<MatUnitInfo> helper;
	
	
	public MatUnitSelect(List<SqlStmtExecOption<MatUnitInfo>> options) {
		helper = new SqlStmtExecHelper<>(options, MatUnitSelectSingle.class, MatUnitInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<MatUnitInfo> getResultset() {
		return helper.getResultset();
	}
}

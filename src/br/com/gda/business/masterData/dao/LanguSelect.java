package br.com.gda.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.masterData.info.LanguInfo;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecHelper;
import br.com.gda.sql.SqlStmtExecOption;

public final class LanguSelect implements SqlStmtExec<LanguInfo> {
	private SqlStmtExec<LanguInfo> helper;
	
	
	public LanguSelect(List<SqlStmtExecOption<LanguInfo>> options) {
		helper = new SqlStmtExecHelper<>(options, LanguSelectSingle.class, LanguInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<LanguInfo> getResultset() {
		return helper.getResultset();
	}
}

package br.com.gda.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.masterData.info.GenderInfo;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecHelper;
import br.com.gda.sql.SqlStmtExecOption;

public final class GenderSelect implements SqlStmtExec<GenderInfo> {
	private SqlStmtExec<GenderInfo> helper;
	
	
	public GenderSelect(List<SqlStmtExecOption<GenderInfo>> options) {
		helper = new SqlStmtExecHelper<>(options, GenderSelectSingle.class, GenderInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<GenderInfo> getResultset() {
		return helper.getResultset();
	}
}

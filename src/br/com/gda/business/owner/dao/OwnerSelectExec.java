package br.com.gda.business.owner.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecHelper;
import br.com.gda.sql.SqlStmtExecOption;

public final class OwnerSelectExec implements SqlStmtExec<OwnerInfo> {
	private SqlStmtExec<OwnerInfo> helper;
	
	
	public OwnerSelectExec(List<SqlStmtExecOption<OwnerInfo>> options) {
		helper = new SqlStmtExecHelper<>(options, OwnerSelect.class, OwnerInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OwnerInfo> getResultset() {
		return helper.getResultset();
	}
}

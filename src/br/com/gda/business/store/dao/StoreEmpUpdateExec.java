package br.com.gda.business.store.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.store.info.StoreEmpInfo;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecHelper;
import br.com.gda.sql.SqlStmtExecOption;

public final class StoreEmpUpdateExec implements SqlStmtExec<StoreEmpInfo> {
	private SqlStmtExec<StoreEmpInfo> helper;
	
	
	public StoreEmpUpdateExec(List<SqlStmtExecOption<StoreEmpInfo>> options) {
		helper = new SqlStmtExecHelper<>(options, StoreEmpUpdate.class, StoreEmpInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<StoreEmpInfo> getResultset() {
		return helper.getResultset();
	}
}

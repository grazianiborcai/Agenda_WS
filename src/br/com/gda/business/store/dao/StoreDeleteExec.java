package br.com.gda.business.store.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecHelper;
import br.com.gda.sql.SqlStmtExecOption;

public final class StoreDeleteExec implements SqlStmtExec<StoreInfo> {
	private SqlStmtExec<StoreInfo> helper;
	
	
	public StoreDeleteExec(List<SqlStmtExecOption<StoreInfo>> options) {
		helper = new SqlStmtExecHelper<>(options, StoreDelete.class, StoreInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<StoreInfo> getResultset() {
		return helper.getResultset();
	}
}

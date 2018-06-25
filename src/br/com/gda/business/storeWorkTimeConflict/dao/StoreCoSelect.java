package br.com.gda.business.storeWorkTimeConflict.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.storeWorkTimeConflict.info.StoreCoInfo;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecHelper;
import br.com.gda.sql.SqlStmtExecOption;

public final class StoreCoSelect implements SqlStmtExec<StoreCoInfo> {
	private SqlStmtExec<StoreCoInfo> helper;
	
	
	public StoreCoSelect(List<SqlStmtExecOption<StoreCoInfo>> options) {
		helper = new SqlStmtExecHelper<>(options, StoreCoSelectSingle.class, StoreCoInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StoreCoInfo> getResultset() {
		return helper.getResultset();
	}
}

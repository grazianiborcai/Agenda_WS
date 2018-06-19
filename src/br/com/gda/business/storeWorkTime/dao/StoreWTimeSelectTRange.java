package br.com.gda.business.storeWorkTime.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecHelper;
import br.com.gda.sql.SqlStmtExecOption;

public class StoreWTimeSelectTRange implements SqlStmtExec<StoreWTimeInfo> {
	private SqlStmtExec<StoreWTimeInfo> helper;
	
	
	public StoreWTimeSelectTRange(List<SqlStmtExecOption<StoreWTimeInfo>> options) {
		helper = new SqlStmtExecHelper<>(options, StoreWTimeSelectTRangeSingle.class, StoreWTimeInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<StoreWTimeInfo> getResultset() {
		return helper.getResultset();
	}
}

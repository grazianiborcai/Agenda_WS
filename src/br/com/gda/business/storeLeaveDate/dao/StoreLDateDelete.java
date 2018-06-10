package br.com.gda.business.storeLeaveDate.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.storeLeaveDate.info.StoreLDateInfo;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecHelper;
import br.com.gda.sql.SqlStmtExecOption;

public final class StoreLDateDelete implements SqlStmtExec<StoreLDateInfo> {
	private SqlStmtExec<StoreLDateInfo> helper;
	
	
	public StoreLDateDelete(List<SqlStmtExecOption<StoreLDateInfo>> options) {
		helper = new SqlStmtExecHelper<>(options, StoreLDateDeleteSingle.class, StoreLDateInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<StoreLDateInfo> getResultset() {
		return helper.getResultset();
	}
}

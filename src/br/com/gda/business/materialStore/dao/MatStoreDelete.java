package br.com.gda.business.materialStore.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.materialStore.info.MatStoreInfo;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecHelper;
import br.com.gda.sql.SqlStmtExecOption;

public final class MatStoreDelete implements SqlStmtExec<MatStoreInfo> {
	private SqlStmtExec<MatStoreInfo> helper;
	
	
	public MatStoreDelete(List<SqlStmtExecOption<MatStoreInfo>> options) {
		helper = new SqlStmtExecHelper<>(options, MatStoreDeleteSingle.class, MatStoreInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<MatStoreInfo> getResultset() {
		return helper.getResultset();
	}
}

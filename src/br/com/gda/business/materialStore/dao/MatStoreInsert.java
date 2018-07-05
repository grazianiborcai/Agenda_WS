package br.com.gda.business.materialStore.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.materialStore.info.MatStoreInfo;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecHelper;
import br.com.gda.sql.SqlStmtExecOption;

public final class MatStoreInsert implements SqlStmtExec<MatStoreInfo> {
	private SqlStmtExec<MatStoreInfo> helper;
	
	
	public MatStoreInsert(List<SqlStmtExecOption<MatStoreInfo>> options) {
		helper = new SqlStmtExecHelper<>(options, MatStoreInsertSingle.class, MatStoreInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatStoreInfo> getResultset() {
		return helper.getResultset();
	}
}

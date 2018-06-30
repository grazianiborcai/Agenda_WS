package br.com.gda.business.customer.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecHelper;
import br.com.gda.sql.SqlStmtExecOption;

public final class CusInsert implements SqlStmtExec<CusInfo> {
	private SqlStmtExec<CusInfo> helper;
	
	
	public CusInsert(List<SqlStmtExecOption<CusInfo>> options) {
		helper = new SqlStmtExecHelper<>(options, CusInsertSingle.class, CusInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CusInfo> getResultset() {
		return helper.getResultset();
	}
}

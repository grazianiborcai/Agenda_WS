package br.com.gda.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.masterData.info.CurrencyInfo;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecHelper;
import br.com.gda.sql.SqlStmtExecOption;

public final class CurrencySelectExec implements SqlStmtExec<CurrencyInfo> {
	private SqlStmtExec<CurrencyInfo> helper;
	
	
	public CurrencySelectExec(List<SqlStmtExecOption<CurrencyInfo>> options) {
		helper = new SqlStmtExecHelper<>(options, CurrencySelect.class, CurrencyInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CurrencyInfo> getResultset() {
		return helper.getResultset();
	}
}

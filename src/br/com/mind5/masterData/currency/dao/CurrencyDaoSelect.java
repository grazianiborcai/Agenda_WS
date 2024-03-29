package br.com.mind5.masterData.currency.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.currency.info.CurrencyInfo;

public final class CurrencyDaoSelect implements DaoStmtExec<CurrencyInfo> {
	private DaoStmtExec<CurrencyInfo> helper;
	
	
	public CurrencyDaoSelect(List<DaoStmtExecOption<CurrencyInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, CurrencyDaoSelectSingle.class, CurrencyInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CurrencyInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}

package br.com.mind5.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.masterData.info.CurrencyInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class CurrencySelect implements DaoStmtExec<CurrencyInfo> {
	private DaoStmtExec<CurrencyInfo> helper;
	
	
	public CurrencySelect(List<DaoStmtExecOption<CurrencyInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, CurrencySelectSingle.class, CurrencyInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CurrencyInfo> getResultset() {
		return helper.getResultset();
	}
}

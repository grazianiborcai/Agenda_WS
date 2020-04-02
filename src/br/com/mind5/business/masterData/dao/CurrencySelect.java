package br.com.mind5.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.masterData.info.CurrencyInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class CurrencySelect implements DaoStmtExec_<CurrencyInfo> {
	private DaoStmtExec_<CurrencyInfo> helper;
	
	
	public CurrencySelect(List<DaoStmtExecOption<CurrencyInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, CurrencySelectSingle.class, CurrencyInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CurrencyInfo> getResultset() {
		return helper.getResultset();
	}
}

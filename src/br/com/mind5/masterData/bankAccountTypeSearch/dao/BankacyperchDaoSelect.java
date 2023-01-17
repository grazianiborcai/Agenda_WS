package br.com.mind5.masterData.bankAccountTypeSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.masterData.bankAccountTypeSearch.info.BankacyperchInfo;
import br.com.mind5.dao.DaoStmtExec;

public final class BankacyperchDaoSelect implements DaoStmtExec<BankacyperchInfo> {
	private DaoStmtExec<BankacyperchInfo> helper;
	
	
	public BankacyperchDaoSelect(List<DaoStmtExecOption<BankacyperchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, BankacyperchDaoSelectSingle.class, BankacyperchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<BankacyperchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}

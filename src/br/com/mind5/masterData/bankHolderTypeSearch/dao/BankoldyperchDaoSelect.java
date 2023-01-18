package br.com.mind5.masterData.bankHolderTypeSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.masterData.bankHolderTypeSearch.info.BankoldyperchInfo;
import br.com.mind5.dao.DaoStmtExec;

public final class BankoldyperchDaoSelect implements DaoStmtExec<BankoldyperchInfo> {
	private DaoStmtExec<BankoldyperchInfo> helper;
	
	
	public BankoldyperchDaoSelect(List<DaoStmtExecOption<BankoldyperchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, BankoldyperchDaoSelectSingle.class, BankoldyperchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<BankoldyperchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}

package br.com.mind5.masterData.bank.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.bank.info.BankInfo;

public final class BankDaoSelect implements DaoStmtExec<BankInfo> {
	private DaoStmtExec<BankInfo> helper;
	
	
	public BankDaoSelect(List<DaoStmtExecOption<BankInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, BankDaoSelectSingle.class, BankInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<BankInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}

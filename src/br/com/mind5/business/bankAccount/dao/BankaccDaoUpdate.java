package br.com.mind5.business.bankAccount.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.bankAccount.info.BankaccInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class BankaccDaoUpdate implements DaoStmtExec<BankaccInfo> {
	private DaoStmtExec<BankaccInfo> helper;
	
	
	public BankaccDaoUpdate(List<DaoStmtExecOption<BankaccInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, BankaccDaoUpdateSingle.class, BankaccInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<BankaccInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}

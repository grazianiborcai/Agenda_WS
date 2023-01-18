package br.com.mind5.business.bankAccountSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.bankAccountSnapshot.info.BankaccnapInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class BankaccnapDaoInsert implements DaoStmtExec<BankaccnapInfo> {
	private DaoStmtExec<BankaccnapInfo> helper;
	
	
	public BankaccnapDaoInsert(List<DaoStmtExecOption<BankaccnapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, BankaccnapDaoInsertSingle.class, BankaccnapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<BankaccnapInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}

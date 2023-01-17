package br.com.mind5.masterData.bankAccountType.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.masterData.bankAccountType.info.BankacypeInfo;
import br.com.mind5.dao.DaoStmtExec;

public final class BankacypeDaoSelect implements DaoStmtExec<BankacypeInfo> {
	private DaoStmtExec<BankacypeInfo> helper;
	
	
	public BankacypeDaoSelect(List<DaoStmtExecOption<BankacypeInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, BankacypeDaoSelectSingle.class, BankacypeInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<BankacypeInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}

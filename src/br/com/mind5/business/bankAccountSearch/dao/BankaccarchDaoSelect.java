package br.com.mind5.business.bankAccountSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.bankAccountSearch.info.BankaccarchInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class BankaccarchDaoSelect implements DaoStmtExec<BankaccarchInfo> {
	private DaoStmtExec<BankaccarchInfo> helper;
	
	
	public BankaccarchDaoSelect(List<DaoStmtExecOption<BankaccarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, BankaccarchDaoSelectSingle.class, BankaccarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<BankaccarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}

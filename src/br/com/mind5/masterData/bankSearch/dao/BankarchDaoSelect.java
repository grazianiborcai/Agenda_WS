package br.com.mind5.masterData.bankSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.bankSearch.info.BankarchInfo;

public final class BankarchDaoSelect implements DaoStmtExec<BankarchInfo> {
	private DaoStmtExec<BankarchInfo> helper;
	
	
	public BankarchDaoSelect(List<DaoStmtExecOption<BankarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, BankarchDaoSelectSingle.class, BankarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<BankarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}

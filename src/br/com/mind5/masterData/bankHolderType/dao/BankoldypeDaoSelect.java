package br.com.mind5.masterData.bankHolderType.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.masterData.bankHolderType.info.BankoldypeInfo;
import br.com.mind5.dao.DaoStmtExec;

public final class BankoldypeDaoSelect implements DaoStmtExec<BankoldypeInfo> {
	private DaoStmtExec<BankoldypeInfo> helper;
	
	
	public BankoldypeDaoSelect(List<DaoStmtExecOption<BankoldypeInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, BankoldypeDaoSelectSingle.class, BankoldypeInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<BankoldypeInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}

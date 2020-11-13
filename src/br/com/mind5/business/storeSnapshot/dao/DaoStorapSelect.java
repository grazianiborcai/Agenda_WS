package br.com.mind5.business.storeSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoStorapSelect implements DaoStmtExec<StorapInfo> {
	private DaoStmtExec<StorapInfo> helper;
	
	
	public DaoStorapSelect(List<DaoStmtExecOption<StorapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoStorapSelectSingle.class, StorapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StorapInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}

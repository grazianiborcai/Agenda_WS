package br.com.mind5.business.materialStock.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoMatockLock implements DaoStmtExec<MatockInfo> {
	private DaoStmtExec<MatockInfo> helper;
	
	
	public DaoMatockLock(List<DaoStmtExecOption<MatockInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoMatockLockSingle.class, MatockInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatockInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}

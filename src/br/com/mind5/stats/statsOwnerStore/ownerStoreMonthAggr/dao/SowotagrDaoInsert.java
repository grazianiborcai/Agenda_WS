package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.info.SowotagrInfo;

public final class SowotagrDaoInsert implements DaoStmtExec<SowotagrInfo> {
	private DaoStmtExec<SowotagrInfo> helper;
	
	
	public SowotagrDaoInsert(List<DaoStmtExecOption<SowotagrInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, SowotagrDaoInsertSingle.class, SowotagrInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SowotagrInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}

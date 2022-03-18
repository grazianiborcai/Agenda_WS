package br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.info.StefilonagrInfo;

public final class StefilonagrDaoDelete implements DaoStmtExec<StefilonagrInfo> {
	private DaoStmtExec<StefilonagrInfo> helper;
	
	
	public StefilonagrDaoDelete(List<DaoStmtExecOption<StefilonagrInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StefilonagrDaoDeleteSingle.class, StefilonagrInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StefilonagrInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}

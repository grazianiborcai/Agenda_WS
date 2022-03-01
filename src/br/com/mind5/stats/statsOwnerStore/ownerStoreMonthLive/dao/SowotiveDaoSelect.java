package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthLive.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthLive.info.SowotiveInfo;

public final class SowotiveDaoSelect implements DaoStmtExec<SowotiveInfo> {
	private DaoStmtExec<SowotiveInfo> helper;
	
	
	public SowotiveDaoSelect(List<DaoStmtExecOption<SowotiveInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, SowotiveDaoSelectSingle.class, SowotiveInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SowotiveInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}

package br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.info.SteddiveInfo;

public final class DaoSteddiveSelect implements DaoStmtExec<SteddiveInfo> {
	private DaoStmtExec<SteddiveInfo> helper;
	
	
	public DaoSteddiveSelect(List<DaoStmtExecOption<SteddiveInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoSteddiveSelectSingle.class, SteddiveInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SteddiveInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}

package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.info.StedmoniveInfo;

public final class DaoStedmoniveSelect implements DaoStmtExec<StedmoniveInfo> {
	private DaoStmtExec<StedmoniveInfo> helper;
	
	
	public DaoStedmoniveSelect(List<DaoStmtExecOption<StedmoniveInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoStedmoniveSelectSingle.class, StedmoniveInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StedmoniveInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}

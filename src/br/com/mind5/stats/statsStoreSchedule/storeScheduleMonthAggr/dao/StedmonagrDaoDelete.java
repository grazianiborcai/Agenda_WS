package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.info.StedmonagrInfo;

public final class StedmonagrDaoDelete implements DaoStmtExec<StedmonagrInfo> {
	private DaoStmtExec<StedmonagrInfo> helper;
	
	
	public StedmonagrDaoDelete(List<DaoStmtExecOption<StedmonagrInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StedmonagrDaoDeleteSingle.class, StedmonagrInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StedmonagrInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}

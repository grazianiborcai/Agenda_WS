package br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.info.SteddagrInfo;

public final class SteddagrDaoSelect implements DaoStmtExec<SteddagrInfo> {
	private DaoStmtExec<SteddagrInfo> helper;
	
	
	public SteddagrDaoSelect(List<DaoStmtExecOption<SteddagrInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, SteddagrDaoSelectSingle.class, SteddagrInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SteddagrInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}

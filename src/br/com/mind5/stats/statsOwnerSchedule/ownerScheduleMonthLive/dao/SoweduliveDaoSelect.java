package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.info.SoweduliveInfo;

public final class SoweduliveDaoSelect implements DaoStmtExec<SoweduliveInfo> {
	private DaoStmtExec<SoweduliveInfo> helper;
	
	
	public SoweduliveDaoSelect(List<DaoStmtExecOption<SoweduliveInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, SoweduliveDaoSelectSingle.class, SoweduliveInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SoweduliveInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}

package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.info.SowedulagrInfo;

public final class SowedulagrDaoDelete implements DaoStmtExec<SowedulagrInfo> {
	private DaoStmtExec<SowedulagrInfo> helper;
	
	
	public SowedulagrDaoDelete(List<DaoStmtExecOption<SowedulagrInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, SowedulagrDaoDeleteSingle.class, SowedulagrInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SowedulagrInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}

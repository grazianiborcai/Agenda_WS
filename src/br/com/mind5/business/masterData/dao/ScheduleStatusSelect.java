package br.com.mind5.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.masterData.info.ScheduleStatusInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class ScheduleStatusSelect implements DaoStmtExec<ScheduleStatusInfo> {
	private DaoStmtExec<ScheduleStatusInfo> helper;
	
	
	public ScheduleStatusSelect(List<DaoStmtExecOption<ScheduleStatusInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, ScheduleStatusSelectSingle.class, ScheduleStatusInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<ScheduleStatusInfo> getResultset() {
		return helper.getResultset();
	}
}

package br.com.mind5.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.masterData.info.ScheduleStatusInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class ScheduleStatusSelect implements DaoStmtExec_<ScheduleStatusInfo> {
	private DaoStmtExec_<ScheduleStatusInfo> helper;
	
	
	public ScheduleStatusSelect(List<DaoStmtExecOption<ScheduleStatusInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, ScheduleStatusSelectSingle.class, ScheduleStatusInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<ScheduleStatusInfo> getResultset() {
		return helper.getResultset();
	}
}

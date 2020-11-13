package br.com.mind5.business.scheduleYearData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.scheduleYearData.info.SchedyeratInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoSchedyeratSelect implements DaoStmtExec<SchedyeratInfo> {
	private DaoStmtExec<SchedyeratInfo> helper;
	
	
	public DaoSchedyeratSelect(List<DaoStmtExecOption<SchedyeratInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoSchedyeratSelectSingle.class, SchedyeratInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SchedyeratInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}

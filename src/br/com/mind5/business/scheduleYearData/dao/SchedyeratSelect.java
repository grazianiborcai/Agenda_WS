package br.com.mind5.business.scheduleYearData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.scheduleYearData.info.SchedyeratInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class SchedyeratSelect implements DaoStmtExec<SchedyeratInfo> {
	private DaoStmtExec<SchedyeratInfo> helper;
	
	
	public SchedyeratSelect(List<DaoStmtExecOption<SchedyeratInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, SchedyeratSelectSingle.class, SchedyeratInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SchedyeratInfo> getResultset() {
		return helper.getResultset();
	}
}

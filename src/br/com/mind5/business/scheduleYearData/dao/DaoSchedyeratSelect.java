package br.com.mind5.business.scheduleYearData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.scheduleYearData.info.SchedyeratInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoSchedyeratSelect implements DaoStmtExecV2<SchedyeratInfo> {
	private DaoStmtExecV2<SchedyeratInfo> helper;
	
	
	public DaoSchedyeratSelect(List<DaoStmtExecOption<SchedyeratInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoSchedyeratSelectSingle.class, SchedyeratInfo.class);
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

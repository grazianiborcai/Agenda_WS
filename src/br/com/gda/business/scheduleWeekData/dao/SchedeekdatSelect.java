package br.com.gda.business.scheduleWeekData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class SchedeekdatSelect implements DaoStmtExec<SchedeekdatInfo> {
	private DaoStmtExec<SchedeekdatInfo> helper;
	
	
	public SchedeekdatSelect(List<DaoStmtExecOption<SchedeekdatInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, SchedeekdatSelectSingle.class, SchedeekdatInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SchedeekdatInfo> getResultset() {
		return helper.getResultset();
	}
}

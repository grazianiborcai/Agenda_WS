package br.com.mind5.business.scheduleWeekData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class SchedeekdatSelect implements DaoStmtExec_<SchedeekdatInfo> {
	private DaoStmtExec_<SchedeekdatInfo> helper;
	
	
	public SchedeekdatSelect(List<DaoStmtExecOption<SchedeekdatInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, SchedeekdatSelectSingle.class, SchedeekdatInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SchedeekdatInfo> getResultset() {
		return helper.getResultset();
	}
}

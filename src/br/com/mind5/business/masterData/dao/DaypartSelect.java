package br.com.mind5.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.masterData.info.DaypartInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class DaypartSelect implements DaoStmtExec_<DaypartInfo> {
	private DaoStmtExec_<DaypartInfo> helper;
	
	
	public DaypartSelect(List<DaoStmtExecOption<DaypartInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, DaypartSelectSingle.class, DaypartInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<DaypartInfo> getResultset() {
		return helper.getResultset();
	}
}

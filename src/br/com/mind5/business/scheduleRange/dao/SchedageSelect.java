package br.com.mind5.business.scheduleRange.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.scheduleRange.info.SchedageInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class SchedageSelect implements DaoStmtExec_<SchedageInfo> {
	private DaoStmtExec_<SchedageInfo> helper;
	
	
	public SchedageSelect(List<DaoStmtExecOption<SchedageInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, SchedageSelectSingle.class, SchedageInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SchedageInfo> getResultset() {
		return helper.getResultset();
	}
}

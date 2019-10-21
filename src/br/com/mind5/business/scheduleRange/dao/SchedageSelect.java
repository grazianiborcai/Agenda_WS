package br.com.mind5.business.scheduleRange.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.scheduleRange.info.SchedageInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class SchedageSelect implements DaoStmtExec<SchedageInfo> {
	private DaoStmtExec<SchedageInfo> helper;
	
	
	public SchedageSelect(List<DaoStmtExecOption<SchedageInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, SchedageSelectSingle.class, SchedageInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SchedageInfo> getResultset() {
		return helper.getResultset();
	}
}

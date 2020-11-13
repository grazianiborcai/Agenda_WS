package br.com.mind5.business.scheduleRange.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.scheduleRange.info.SchedageInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoSchedageSelect implements DaoStmtExec<SchedageInfo> {
	private DaoStmtExec<SchedageInfo> helper;
	
	
	public DaoSchedageSelect(List<DaoStmtExecOption<SchedageInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoSchedageSelectSingle.class, SchedageInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SchedageInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}

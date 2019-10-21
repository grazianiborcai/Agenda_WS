package br.com.mind5.business.scheduleMonthData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class SchedonthatSelect implements DaoStmtExec<SchedonthatInfo> {
	private DaoStmtExec<SchedonthatInfo> helper;
	
	
	public SchedonthatSelect(List<DaoStmtExecOption<SchedonthatInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, SchedonthatSelectSingle.class, SchedonthatInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SchedonthatInfo> getResultset() {
		return helper.getResultset();
	}
}

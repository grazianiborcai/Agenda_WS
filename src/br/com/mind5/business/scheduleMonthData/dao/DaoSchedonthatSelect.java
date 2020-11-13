package br.com.mind5.business.scheduleMonthData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoSchedonthatSelect implements DaoStmtExec<SchedonthatInfo> {
	private DaoStmtExec<SchedonthatInfo> helper;
	
	
	public DaoSchedonthatSelect(List<DaoStmtExecOption<SchedonthatInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoSchedonthatSelectSingle.class, SchedonthatInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SchedonthatInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}

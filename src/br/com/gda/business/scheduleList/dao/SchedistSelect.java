package br.com.gda.business.scheduleList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.scheduleList.info.SchedistInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class SchedistSelect implements DaoStmtExec<SchedistInfo> {
	private DaoStmtExec<SchedistInfo> helper;
	
	
	public SchedistSelect(List<DaoStmtExecOption<SchedistInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, SchedistSelectSingle.class, SchedistInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SchedistInfo> getResultset() {
		return helper.getResultset();
	}
}

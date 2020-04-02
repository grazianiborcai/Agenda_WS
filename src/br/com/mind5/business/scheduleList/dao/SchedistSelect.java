package br.com.mind5.business.scheduleList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.scheduleList.info.SchedistInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class SchedistSelect implements DaoStmtExec_<SchedistInfo> {
	private DaoStmtExec_<SchedistInfo> helper;
	
	
	public SchedistSelect(List<DaoStmtExecOption<SchedistInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, SchedistSelectSingle.class, SchedistInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SchedistInfo> getResultset() {
		return helper.getResultset();
	}
}

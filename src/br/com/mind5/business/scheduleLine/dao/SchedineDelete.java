package br.com.mind5.business.scheduleLine.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class SchedineDelete implements DaoStmtExec_<SchedineInfo> {
	private DaoStmtExec_<SchedineInfo> helper;
	
	
	public SchedineDelete(List<DaoStmtExecOption<SchedineInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, SchedineDeleteSingle.class, SchedineInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SchedineInfo> getResultset() {
		return helper.getResultset();
	}
}

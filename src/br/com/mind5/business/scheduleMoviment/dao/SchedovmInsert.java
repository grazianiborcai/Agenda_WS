package br.com.mind5.business.scheduleMoviment.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.scheduleMoviment.info.SchedovmInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class SchedovmInsert implements DaoStmtExec_<SchedovmInfo> {
	private DaoStmtExec_<SchedovmInfo> helper;
	
	
	public SchedovmInsert(List<DaoStmtExecOption<SchedovmInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, SchedovmInsertSingle.class, SchedovmInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SchedovmInfo> getResultset() {
		return helper.getResultset();
	}
}

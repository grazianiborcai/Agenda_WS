package br.com.mind5.business.scheduleLine.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class SchedineInsert implements DaoStmtExec<SchedineInfo> {
	private DaoStmtExec<SchedineInfo> helper;
	
	
	public SchedineInsert(List<DaoStmtExecOption<SchedineInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, SchedineInsertSingle.class, SchedineInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SchedineInfo> getResultset() {
		return helper.getResultset();
	}
}

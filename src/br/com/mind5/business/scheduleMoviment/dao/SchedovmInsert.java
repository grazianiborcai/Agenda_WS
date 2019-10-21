package br.com.mind5.business.scheduleMoviment.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.scheduleMoviment.info.SchedovmInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class SchedovmInsert implements DaoStmtExec<SchedovmInfo> {
	private DaoStmtExec<SchedovmInfo> helper;
	
	
	public SchedovmInsert(List<DaoStmtExecOption<SchedovmInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, SchedovmInsertSingle.class, SchedovmInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SchedovmInfo> getResultset() {
		return helper.getResultset();
	}
}

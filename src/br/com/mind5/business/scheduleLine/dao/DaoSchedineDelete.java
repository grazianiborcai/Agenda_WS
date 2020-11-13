package br.com.mind5.business.scheduleLine.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoSchedineDelete implements DaoStmtExec<SchedineInfo> {
	private DaoStmtExec<SchedineInfo> helper;
	
	
	public DaoSchedineDelete(List<DaoStmtExecOption<SchedineInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoSchedineDeleteSingle.class, SchedineInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SchedineInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}

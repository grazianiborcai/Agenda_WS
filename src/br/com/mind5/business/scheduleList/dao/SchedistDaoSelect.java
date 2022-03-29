package br.com.mind5.business.scheduleList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.scheduleList.info.SchedistInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class SchedistDaoSelect implements DaoStmtExec<SchedistInfo> {
	private DaoStmtExec<SchedistInfo> helper;
	
	
	public SchedistDaoSelect(List<DaoStmtExecOption<SchedistInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, SchedistDaoSelectSingle.class, SchedistInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SchedistInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}

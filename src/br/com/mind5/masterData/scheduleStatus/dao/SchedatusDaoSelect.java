package br.com.mind5.masterData.scheduleStatus.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.scheduleStatus.info.SchedatusInfo;

public final class SchedatusDaoSelect implements DaoStmtExec<SchedatusInfo> {
	private DaoStmtExec<SchedatusInfo> helper;
	
	
	public SchedatusDaoSelect(List<DaoStmtExecOption<SchedatusInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, SchedatusDaoSelectSingle.class, SchedatusInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SchedatusInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}

package br.com.mind5.masterData.scheduleStatus.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.scheduleStatus.info.SchedatusInfo;

public final class DaoSchedatusSelect implements DaoStmtExecV2<SchedatusInfo> {
	private DaoStmtExecV2<SchedatusInfo> helper;
	
	
	public DaoSchedatusSelect(List<DaoStmtExecOption<SchedatusInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoSchedatusSelectSingle.class, SchedatusInfo.class);
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

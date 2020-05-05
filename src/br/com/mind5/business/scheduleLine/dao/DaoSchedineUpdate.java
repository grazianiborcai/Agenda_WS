package br.com.mind5.business.scheduleLine.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoSchedineUpdate implements DaoStmtExecV2<SchedineInfo> {
	private DaoStmtExecV2<SchedineInfo> helper;
	
	
	public DaoSchedineUpdate(List<DaoStmtExecOption<SchedineInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoSchedineUpdateSingle.class, SchedineInfo.class);
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

package br.com.mind5.business.scheduleMonthData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoSchedonthatSelect implements DaoStmtExecV2<SchedonthatInfo> {
	private DaoStmtExecV2<SchedonthatInfo> helper;
	
	
	public DaoSchedonthatSelect(List<DaoStmtExecOption<SchedonthatInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoSchedonthatSelectSingle.class, SchedonthatInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SchedonthatInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}

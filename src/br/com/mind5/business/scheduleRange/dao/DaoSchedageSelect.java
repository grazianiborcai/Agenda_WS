package br.com.mind5.business.scheduleRange.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.scheduleRange.info.SchedageInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoSchedageSelect implements DaoStmtExecV2<SchedageInfo> {
	private DaoStmtExecV2<SchedageInfo> helper;
	
	
	public DaoSchedageSelect(List<DaoStmtExecOption<SchedageInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoSchedageSelectSingle.class, SchedageInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SchedageInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}

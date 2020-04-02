package br.com.mind5.business.storeWorkTimeRange.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeWorkTimeRange.info.StoworgInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class StoworgSelect implements DaoStmtExec_<StoworgInfo> {
	private DaoStmtExec_<StoworgInfo> helper;
	
	
	public StoworgSelect(List<DaoStmtExecOption<StoworgInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, StoworgSelectSingle.class, StoworgInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<StoworgInfo> getResultset() {
		return helper.getResultset();
	}
}

package br.com.mind5.business.storeWorkTimeSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class StowotarchSelect implements DaoStmtExec_<StowotarchInfo> {
	private DaoStmtExec_<StowotarchInfo> helper;
	
	
	public StowotarchSelect(List<DaoStmtExecOption<StowotarchInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, StowotarchSelectSingle.class, StowotarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StowotarchInfo> getResultset() {
		return helper.getResultset();
	}
}

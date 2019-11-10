package br.com.mind5.business.storeWorkTimeSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class StowotarchSelect implements DaoStmtExec<StowotarchInfo> {
	private DaoStmtExec<StowotarchInfo> helper;
	
	
	public StowotarchSelect(List<DaoStmtExecOption<StowotarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StowotarchSelectSingle.class, StowotarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StowotarchInfo> getResultset() {
		return helper.getResultset();
	}
}

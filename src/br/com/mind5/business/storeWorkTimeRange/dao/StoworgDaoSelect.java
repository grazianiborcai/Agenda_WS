package br.com.mind5.business.storeWorkTimeRange.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeWorkTimeRange.info.StoworgInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class StoworgDaoSelect implements DaoStmtExec<StoworgInfo> {
	private DaoStmtExec<StoworgInfo> helper;
	
	
	public StoworgDaoSelect(List<DaoStmtExecOption<StoworgInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StoworgDaoSelectSingle.class, StoworgInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<StoworgInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}

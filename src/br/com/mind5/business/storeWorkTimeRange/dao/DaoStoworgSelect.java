package br.com.mind5.business.storeWorkTimeRange.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeWorkTimeRange.info.StoworgInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoStoworgSelect implements DaoStmtExecV2<StoworgInfo> {
	private DaoStmtExecV2<StoworgInfo> helper;
	
	
	public DaoStoworgSelect(List<DaoStmtExecOption<StoworgInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoStoworgSelectSingle.class, StoworgInfo.class);
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

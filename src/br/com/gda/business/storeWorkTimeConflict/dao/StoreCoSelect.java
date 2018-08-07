package br.com.gda.business.storeWorkTimeConflict.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.storeWorkTimeConflict.info.StoreCoInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class StoreCoSelect implements DaoStmtExec<StoreCoInfo> {
	private DaoStmtExec<StoreCoInfo> helper;
	
	
	public StoreCoSelect(List<DaoStmtExecOption<StoreCoInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StoreCoSelectSingle.class, StoreCoInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StoreCoInfo> getResultset() {
		return helper.getResultset();
	}
}

package br.com.gda.business.store.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class StoreDelete implements DaoStmtExec<StoreInfo> {
	private DaoStmtExec<StoreInfo> helper;
	
	
	public StoreDelete(List<DaoStmtExecOption<StoreInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StoreDeleteSingle.class, StoreInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StoreInfo> getResultset() {
		return helper.getResultset();
	}
}

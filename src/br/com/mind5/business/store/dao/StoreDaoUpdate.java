package br.com.mind5.business.store.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class StoreDaoUpdate implements DaoStmtExec<StoreInfo> {
	private DaoStmtExec<StoreInfo> helper;
	
	
	public StoreDaoUpdate(List<DaoStmtExecOption<StoreInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StoreDaoUpdateSingle.class, StoreInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StoreInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}

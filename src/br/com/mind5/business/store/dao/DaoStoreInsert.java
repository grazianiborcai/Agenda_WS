package br.com.mind5.business.store.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoStoreInsert implements DaoStmtExec<StoreInfo> {
	private DaoStmtExec<StoreInfo> helper;
	
	
	public DaoStoreInsert(List<DaoStmtExecOption<StoreInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoStoreInsertSingle.class, StoreInfo.class);
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

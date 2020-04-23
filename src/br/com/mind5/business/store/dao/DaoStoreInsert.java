package br.com.mind5.business.store.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoStoreInsert implements DaoStmtExecV2<StoreInfo> {
	private DaoStmtExecV2<StoreInfo> helper;
	
	
	public DaoStoreInsert(List<DaoStmtExecOption<StoreInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoStoreInsertSingle.class, StoreInfo.class);
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

package br.com.mind5.business.store.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class StoreInsert implements DaoStmtExec_<StoreInfo> {
	private DaoStmtExec_<StoreInfo> helper;
	
	
	public StoreInsert(List<DaoStmtExecOption<StoreInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, StoreInsertSingle.class, StoreInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StoreInfo> getResultset() {
		return helper.getResultset();
	}
}

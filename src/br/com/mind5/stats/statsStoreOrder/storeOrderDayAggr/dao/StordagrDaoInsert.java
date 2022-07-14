package br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.info.StordagrInfo;

public final class StordagrDaoInsert implements DaoStmtExec<StordagrInfo> {
	private DaoStmtExec<StordagrInfo> helper;
	
	
	public StordagrDaoInsert(List<DaoStmtExecOption<StordagrInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StordagrDaoInsertSingle.class, StordagrInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
	}

	
	
	@Override public List<StordagrInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();
	}
}

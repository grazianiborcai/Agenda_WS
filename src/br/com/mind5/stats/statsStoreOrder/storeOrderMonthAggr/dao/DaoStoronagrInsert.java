package br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.info.StoronagrInfo;

public final class DaoStoronagrInsert implements DaoStmtExec<StoronagrInfo> {
	private DaoStmtExec<StoronagrInfo> helper;
	
	
	public DaoStoronagrInsert(List<DaoStmtExecOption<StoronagrInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoStoronagrInsertSingle.class, StoronagrInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
	}

	
	
	@Override public List<StoronagrInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();
	}
}

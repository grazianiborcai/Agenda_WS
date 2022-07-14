package br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.info.StoroniveInfo;

public final class StoroniveDaoSelect implements DaoStmtExec<StoroniveInfo> {
	private DaoStmtExec<StoroniveInfo> helper;
	
	
	public StoroniveDaoSelect(List<DaoStmtExecOption<StoroniveInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StoroniveDaoSelectSingle.class, StoroniveInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
	}

	
	
	@Override public List<StoroniveInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();
	}
}

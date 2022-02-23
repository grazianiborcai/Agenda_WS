package br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.info.StordiveInfo;

public final class DaoStordiveSelect implements DaoStmtExec<StordiveInfo> {
	private DaoStmtExec<StordiveInfo> helper;
	
	
	public DaoStordiveSelect(List<DaoStmtExecOption<StordiveInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoStordiveSelectSingle.class, StordiveInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
	}

	
	
	@Override public List<StordiveInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();
	}
}

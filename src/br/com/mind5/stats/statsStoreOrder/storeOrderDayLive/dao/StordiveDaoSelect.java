package br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.info.StordiveInfo;

public final class StordiveDaoSelect implements DaoStmtExec<StordiveInfo> {
	private DaoStmtExec<StordiveInfo> helper;
	
	
	public StordiveDaoSelect(List<DaoStmtExecOption<StordiveInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StordiveDaoSelectSingle.class, StordiveInfo.class);
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

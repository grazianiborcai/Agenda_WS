package br.com.mind5.stats.statsUserStore.userStoreAggr.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.stats.statsUserStore.userStoreAggr.info.StusoraggInfo;

public final class StusoraggDaoSelect implements DaoStmtExec<StusoraggInfo> {
	private DaoStmtExec<StusoraggInfo> helper;
	
	
	public StusoraggDaoSelect(List<DaoStmtExecOption<StusoraggInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StusoraggDaoSelectSingle.class, StusoraggInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StusoraggInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}

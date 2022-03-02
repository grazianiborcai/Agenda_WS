package br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.info.SowusagrInfo;

public final class SowusagrDaoSelect implements DaoStmtExec<SowusagrInfo> {
	private DaoStmtExec<SowusagrInfo> helper;
	
	
	public SowusagrDaoSelect(List<DaoStmtExecOption<SowusagrInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, SowusagrDaoSelectSingle.class, SowusagrInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SowusagrInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}

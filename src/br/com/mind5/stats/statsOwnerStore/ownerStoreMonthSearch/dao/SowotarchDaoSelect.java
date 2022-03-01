package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.info.SowotarchInfo;

public final class SowotarchDaoSelect implements DaoStmtExec<SowotarchInfo> {
	private DaoStmtExec<SowotarchInfo> helper;
	
	
	public SowotarchDaoSelect(List<DaoStmtExecOption<SowotarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, SowotarchDaoSelectSingle.class, SowotarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
	}

	
	
	@Override public List<SowotarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();
	}
}
